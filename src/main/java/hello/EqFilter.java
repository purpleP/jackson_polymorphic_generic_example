package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class EqFilter<T> extends DataFilter<T> {
    EqFilter() {}
    
    EqFilter(String property, T value) {
        super(property, value);
    }

    EqFilter(String property, T value, boolean negated) {
        super(property, value,  negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return cb.equal(path, obj);
    }


}
