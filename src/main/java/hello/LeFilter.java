package hello;

import java.util.List;

class LeFilter<T> extends DataFilter<List<T>> {
    LeFilter(){}
    
    LeFilter(String property, List<T> value) {
        super(property, value);
    }

    LeFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }
}
