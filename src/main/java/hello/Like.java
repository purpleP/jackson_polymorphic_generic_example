package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class Like extends Conditional<String, String, String> {
    @Override BiFunction<Path<String>, String, Predicate> pred(CriteriaBuilder cb) {
        return cb::like;
    }

    Like(){}
    
    Like(String property, String value) {
        super(property, value);
    }

    Like(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
