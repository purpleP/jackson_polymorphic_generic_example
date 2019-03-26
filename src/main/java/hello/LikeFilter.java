package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class LikeFilter extends Conditional<String, String, String> {
    @Override BiFunction<Path<String>, String, Predicate> pred(CriteriaBuilder cb) {
        return cb::like;
    }

    LikeFilter(){}
    
    LikeFilter(String property, String value) {
        super(property, value);
    }

    LikeFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
