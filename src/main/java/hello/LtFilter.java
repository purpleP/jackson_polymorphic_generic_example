package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class LtFilter<T extends Comparable<T>> extends DataFilter<T> {
    LtFilter(){}
    
    LtFilter(String property, T value) {
        super(property, value);
    }

    LtFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

}
