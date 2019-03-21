package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class EqFilter<T, U> extends DataFilter<T, U, U> {
    @Override BiFunction<Path<U>, U, Predicate> pred(CriteriaBuilder cb) {
        return cb::equal;
    }

    EqFilter() {}
    
    EqFilter(String property, T value) {
        super(property, value);
    }

    EqFilter(String property, T value, boolean negated) {
        super(property, value,  negated);
    }
}
