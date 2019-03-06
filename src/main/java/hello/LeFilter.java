package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class LeFilter<T extends Comparable<T>> extends DataFilter<T> {
    LeFilter(){}
    
    LeFilter(String property, T value) {
        super(property, value);
    }

    LeFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

}
