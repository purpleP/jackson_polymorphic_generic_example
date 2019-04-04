package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class Equal<T> extends Conditional<T> {


    @Override Predicate pred(CriteriaBuilder cb, Path path, Object v) {
        return cb.equal(path, v);
    }

    Equal() {}
    
    Equal(String property, T value) {
        super(property, value);
    }

    Equal(String property, T value, boolean negated) {
        super(property, value,  negated);
    }
}
