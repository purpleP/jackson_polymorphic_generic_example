package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

class IsNullFilter<T> extends DataFilter<Void> {
    IsNullFilter(){}

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return null;
    }

    IsNullFilter(String property) {
        super(property, null);
    }

    IsNullFilter(String property, boolean negated) {
        super(property, null, negated);
    }
}
