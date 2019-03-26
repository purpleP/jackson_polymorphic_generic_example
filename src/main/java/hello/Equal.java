package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class Equal<T, U> extends Conditional<T, U, U> {
    @Override BiFunction<Path<U>, U, Predicate> pred(CriteriaBuilder cb) {
        return cb::equal;
    }

    Equal() {}
    
    Equal(String property, T value) {
        super(property, value);
    }

    Equal(String property, T value, boolean negated) {
        super(property, value,  negated);
    }
}
