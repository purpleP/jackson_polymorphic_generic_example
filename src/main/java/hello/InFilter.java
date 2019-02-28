package hello;

import java.util.List;

class InFilter<T> extends DataFilter<List<T>> {
    InFilter(){}

    InFilter(String property, List<T> value) {
        super(property, value);
    }
}
