package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class LikeFilter extends DataFilter<String> {
    LikeFilter(){}
    
    LikeFilter(String property, String value) {
        super(property, value);
    }

    LikeFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

}
