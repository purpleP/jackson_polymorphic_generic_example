package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class Contains extends Conditional<String, String, String> {
    @Override BiFunction<Path<String>, String, Predicate> pred(CriteriaBuilder cb) {
        return (p, v) -> cb.like(p, "%" + v + "%");
    }

    Contains(){}

    Contains(String property, String value) {
        super(property, value);
    }
    
    Contains(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
