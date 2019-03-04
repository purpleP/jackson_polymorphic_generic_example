package hello;

import java.util.List;

class InFilter<T> extends DataFilter<List<T>> {
    InFilter(){}
    
    InFilter(String property, List<T> value) {
        super(property, value);
    }

    InFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }
}
