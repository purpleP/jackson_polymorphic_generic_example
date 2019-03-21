package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.function.BiFunction;

public class GtFilter<T, U extends Comparable<U>> extends DataFilter<T, U, U> {
    @Override BiFunction<Path<U>, U, Predicate> pred(CriteriaBuilder cb) {
        return cb::greaterThan;
    }

    GtFilter(){}
    
    GtFilter(String property, T value) {
        super(property, value);
    }

    GtFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
