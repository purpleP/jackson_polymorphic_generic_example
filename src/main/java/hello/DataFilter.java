package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import static java.util.Map.entry;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "TYPE")
@JsonSubTypes({
    @JsonSubTypes.Type(value=IsNullFilter.class, name = "IS_NULL"),
    @JsonSubTypes.Type(value=EqFilter.class, name = "EQ"),
    @JsonSubTypes.Type(value=GeFilter.class, name = "GE"),
    @JsonSubTypes.Type(value=GtFilter.class, name = "GT"),
    @JsonSubTypes.Type(value=LeFilter.class, name = "LE"),
    @JsonSubTypes.Type(value=LtFilter.class, name = "LT"),
    @JsonSubTypes.Type(value=InFilter.class, name = "IN"),
    @JsonSubTypes.Type(value=LikeFilter.class, name = "LIKE"),
    @JsonSubTypes.Type(value=ContainsFilter.class, name = "CONTAINS")
})
public abstract class DataFilter<T, U, G> {

    abstract BiFunction<Path<U>, G, Predicate> pred(CriteriaBuilder cb);

    private static Map<
        Map.Entry<Class<?>, Class<?>>, Function<Object, Object>
    > converters = Map.ofEntries(
        mk(Integer.class, Long.class, Integer::longValue),
        mk(Integer.class, long.class, Integer::longValue),
        mk(String.class, LocalDate.class, LocalDate::parse),
        mk(String.class, ZonedDateTime.class, ZonedDateTime::parse)
    );

    @JsonProperty
    boolean negated;
    @JsonProperty
    String property;
    @JsonProperty
    T value;


    DataFilter() {}

    private static <X, Y>
        Map.Entry<Map.Entry<Class<?>, Class<?>>, Function<Object, Object>>
        mk(Class<X> from, Class<Y> to, Function<? super X, ? extends Y> f) {
            return entry(entry(from, to), x -> f.apply(from.cast(x)));
    }

    public DataFilter(String property, T value) {
        this(property, value, false);
    }

    public DataFilter(String property, T value, boolean negated) {
        this.negated = negated;
        this.property = property;
        this.value = value;
    }


    public <R> Predicate toPredicate(Root<R> root, CriteriaBuilder cb) {
        Path<U> path = root.get(property);
        Predicate p = pred(cb).apply(path, transform(path.getJavaType()));
        return negated ? p.not() : p;
    }

    <X, Y> Object trans(X value, Class<? extends Y> cls) {
        return Optional.ofNullable(DataFilter.converters.get(Map.entry(value.getClass(), cls)))
                .map(f -> f.apply(value)).orElse(value);
    }

    @SuppressWarnings("unchecked")
    G transform(Class<? extends U> cls) {
        return (G) trans(value, cls);
    }


    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
            "negated='" + negated + '\'' +
            "property='" + property + '\'' +
            ", value=" + value +
            '}';
    }
}
