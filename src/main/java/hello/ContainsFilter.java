package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class ContainsFilter extends DataFilter<String> {
    ContainsFilter(){}

    ContainsFilter(String property, String value) {
        super(property, value);
    }
    
    ContainsFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

}
