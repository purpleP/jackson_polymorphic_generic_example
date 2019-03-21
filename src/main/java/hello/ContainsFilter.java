package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

class ContainsFilter extends DataFilter<String, String, String> {
    @Override BiFunction<Path<String>, String, Predicate> pred(CriteriaBuilder cb) {
        return (p, v) -> cb.like(p, "%" + v + "%");
    }

    ContainsFilter(){}

    ContainsFilter(String property, String value) {
        super(property, value);
    }
    
    ContainsFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
