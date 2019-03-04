package hello;

import java.util.List;

class GtFilter<T> extends DataFilter<List<T>> {
    GtFilter(){}
    
    GtFilter(String property, List<T> value) {
        super(property, value);
    }

    GtFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }
}
