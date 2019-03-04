package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import java.util.Date;

import javax.persistence.criteria.Root;

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
abstract class DataFilter<T> {
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


    public <R> void toPredicate(Root<R> root) {
        if (root.get("property").getJavaType() == Date.class) {
            DateTimeFormat.ISO_OFFSET_DATE
        }
        return null;
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
