package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class Greater<T> extends Conditional<T> {

    @Override Predicate pred(CriteriaBuilder cb, Path path, Object v) {
        return cb.greaterThan((Path<Comparable>) path, (Comparable) v);
    }

    Greater(){}
    
    Greater(String property, T value) {
        super(property, value);
    }

    Greater(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
