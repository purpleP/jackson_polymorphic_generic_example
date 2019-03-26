package hello;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

class IsNull extends AbstractConditional {

    IsNull(){}

    @Override public Predicate toPredicate(Root<?> root, CriteriaBuilder cb) {
        return root.get(property).isNull();
    }

    IsNull(String property) {
        super(property);
    }

    IsNull(String property, boolean negated) {
        super(property, negated);
    }

    @Override Predicate makePredicate(Path<?> path, CriteriaBuilder cb) {
        return path.isNull();
    }
}
