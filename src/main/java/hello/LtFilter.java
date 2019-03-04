package hello;

import java.util.List;

class LtFilter<T> extends DataFilter<List<T>> {
    LtFilter(){}
    
    LtFilter(String property, List<T> value) {
        super(property, value);
    }

    LtFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }
}
