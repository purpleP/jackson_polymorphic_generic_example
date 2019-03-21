package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class InFilter<T, U> extends DataFilter<List<T>, U, List<U>> {
    @Override BiFunction<Path<U>, List<U>, Predicate> pred(CriteriaBuilder cb) {
        return (p, l) -> l.isEmpty() ? cb.or() : p.in(l);
    }

    InFilter(){}
    
    InFilter(String property, List<T> value) {
        super(property, value);
    }

    InFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<U> transform(Class<? extends U> cls) {
        return value.stream().map(v -> (U) trans(v, cls)).collect(Collectors.toList());
    }

}
