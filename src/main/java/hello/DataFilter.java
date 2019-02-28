package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "TYPE")
@JsonSubTypes({
    @JsonSubTypes.Type(value=EqFilter.class, name = "EQ"),
    @JsonSubTypes.Type(value=InFilter.class, name = "IN")
})
abstract class DataFilter<T> {
    @JsonProperty
    String property;
    @JsonProperty
    T value;

    DataFilter() {}

    public DataFilter(String property, T value) {
        this.property = property;
        this.value = value;
    }

    @Override public String toString() {
        return this.getClass().getName() + "{" +
            "property='" + property + '\'' +
            ", value=" + value +
            '}';
    }
}
