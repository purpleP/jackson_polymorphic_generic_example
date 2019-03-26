package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "TYPE")
@JsonSubTypes({
    @JsonSubTypes.Type(value = IsNull.class, name = "IS_NULL"),
    @JsonSubTypes.Type(value = Equal.class, name = "EQ"),
    @JsonSubTypes.Type(value = GreaterOrEqual.class, name = "GE"),
    @JsonSubTypes.Type(value = Greater.class, name = "GT"),
    @JsonSubTypes.Type(value = LowerOrEqual.class, name = "LE"),
    @JsonSubTypes.Type(value = Lower.class, name = "LT"),
    @JsonSubTypes.Type(value = In.class, name = "IN"),
    @JsonSubTypes.Type(value = LikeFilter.class, name = "LIKE"),
    @JsonSubTypes.Type(value = Contains.class, name = "CONTAINS")
})
public abstract class AbstractConditional {
    @JsonProperty
    boolean negated;
    @JsonProperty
    String property;

    AbstractConditional() {}

    AbstractConditional(String property) {
        this(property, false);
    }

    AbstractConditional(String property, boolean negated) {
        this.property = property;
        this.negated = negated;
    }

    abstract Predicate makePredicate(Path<?> path, CriteriaBuilder cb);

    Predicate toPredicate(Root<?> root, CriteriaBuilder cb) {
        Predicate p = makePredicate(root.get(property), cb);
        return negated ? p.not() : p;
    }
}
