package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class GreaterOrEqual<T> extends Conditional<T> {

    @Override Predicate pred(
        CriteriaBuilder cb, Path path, Object v
    ) {
        return cb.greaterThanOrEqualTo((Path<Comparable>) path, (Comparable) v);
    }

    GreaterOrEqual(){}
    
    GreaterOrEqual(String property, T value) {
        super(property, value);
    }

    GreaterOrEqual(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
