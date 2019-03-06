package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

class InFilter<T> extends DataFilter<List<T>> {
    InFilter(){}
    
    InFilter(String property, List<T> value) {
        super(property, value);
    }

    InFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

}
