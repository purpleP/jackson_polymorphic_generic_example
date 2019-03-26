package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class In<T, U> extends Conditional<List<T>, U, List<U>> {
    @Override BiFunction<Path<U>, List<U>, Predicate> pred(CriteriaBuilder cb) {
        return (p, l) -> l.isEmpty() ? cb.or() : p.in(l);
    }

    In(){}
    
    In(String property, List<T> value) {
        super(property, value);
    }

    In(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<U> transform(Class<? extends U> cls) {
        return value.stream().map(v -> (U) trans(v, cls)).collect(Collectors.toList());
    }

}
