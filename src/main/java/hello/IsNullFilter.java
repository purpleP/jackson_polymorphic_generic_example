package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.BiFunction;

class IsNullFilter<U> extends DataFilter<Void, U, Void> {
    @Override BiFunction<Path<U>, Void, Predicate> pred(CriteriaBuilder cb) {
        return null;
    }

    IsNullFilter(){}

    @Override public Predicate toPredicate(Root<?> root, CriteriaBuilder cb) {
        return root.get(property).isNull();
    }

    IsNullFilter(String property) {
        super(property, null);
    }

    IsNullFilter(String property, boolean negated) {
        super(property, null, negated);
    }
}
