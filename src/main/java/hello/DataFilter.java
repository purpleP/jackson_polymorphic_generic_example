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

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

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
public abstract class DataFilter<T> {
    @JsonProperty
    boolean negated;
    @JsonProperty
    String property;
    @JsonProperty
    T value;

    DataFilter() {}

    public DataFilter(String property, T value) {
        this(property, value, false);
    }

    public DataFilter(String property, T value, boolean negated) {
        this.negated = negated;
        this.property = property;
        this.value = value;
    }

    public <R> Predicate toPredicate(Root<R> root, CriteriaBuilder cb) {
        Path<?> path = root.get(property);
        Class<?> cls = path.getJavaType();
        Object obj;
        if (cls.isAssignableFrom(LocalDate.class)) {
            obj = LocalDate.parse((String) value);
        } else if (cls.isAssignableFrom(ZonedDateTime.class)) {
            obj = ZonedDateTime.parse((String) value);
        } else {
            obj = value;
        }
        return make(cb, path, cls, cls.cast(obj));
    }

    protected abstract Predicate make(
        CriteriaBuilder cb,
        Path<?> path,
        Class<?> cls,
        Object obj
    );

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
            "negated='" + negated + '\'' +
            "property='" + property + '\'' +
            ", value=" + value +
            '}';
    }
}
