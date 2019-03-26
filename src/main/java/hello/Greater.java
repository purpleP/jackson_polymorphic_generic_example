package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

public class Greater<T, U extends Comparable<U>> extends Conditional<T, U, U> {
    @Override BiFunction<Path<U>, U, Predicate> pred(CriteriaBuilder cb) {
        return cb::greaterThan;
    }

    Greater(){}
    
    Greater(String property, T value) {
        super(property, value);
    }

    Greater(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
