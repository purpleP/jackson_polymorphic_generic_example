package hello;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Map.entry;

public abstract class Conditional<T> extends AbstractConditional {

    abstract Predicate pred(CriteriaBuilder cb, Path path, Object v);

    private static Map<
        Map.Entry<Class<?>, Class<?>>, Function<Object, Object>
    > converters = Map.ofEntries(
        mk(Integer.class, Long.class, Integer::longValue),
        mk(Integer.class, long.class, Integer::longValue),
        mk(String.class, LocalDate.class, LocalDate::parse),
        mk(String.class, ZonedDateTime.class, ZonedDateTime::parse)
    );

    @JsonProperty
    T value;

    Conditional() {}

    private static <X, Y>
        Map.Entry<Map.Entry<Class<?>, Class<?>>, Function<Object, Object>>
        mk(Class<X> from, Class<Y> to, Function<? super X, ? extends Y> f) {
            return entry(entry(from, to), x -> f.apply(from.cast(x)));
    }

    public Conditional(String property, T value) {
        this(property, value, false);
    }

    public Conditional(String property, T value, boolean negated) {
        super(property, negated);
        this.value = value;
    }


    public Predicate makePredicate(Path<?> path, CriteriaBuilder cb) {
        return pred(cb, path, trans(value, path.getJavaType()));
    }

    <X, Y> Object trans(X value, Class<? extends Y> cls) {
        return Optional.ofNullable(
            Conditional.converters.get(Map.entry(value.getClass(), cls))
        ).map(f -> f.apply(value)).orElse(value);
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
