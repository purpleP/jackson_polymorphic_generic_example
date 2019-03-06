package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class GeFilter<T extends Comparable<T>> extends DataFilter<T> {
    GeFilter(){}
    
    GeFilter(String property, T value) {
        super(property, value);
    }

    GeFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }


    @SuppressWarnings("unchecked")
    <G extends Comparable<? super G>> Predicate cast(
        Path<?> path, CriteriaBuilder cb, Object obj
    ) {
        Path<G> p = (Path<G>) path;
        return cb.greaterThan(p, (G) obj);
    }

    @Override protected Predicate make(
        CriteriaBuilder cb, Path<?> path, Class<?> cls, Object obj
    ) {
        return cast(path, cb, obj);
    }
}
