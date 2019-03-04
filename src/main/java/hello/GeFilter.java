package hello;

import java.util.List;

class GeFilter<T> extends DataFilter<List<T>> {
    GeFilter(){}
    
    GeFilter(String property, List<T> value) {
        super(property, value);
    }

    GeFilter(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }
}
