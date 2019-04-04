package hello;

import java.util.List;

public abstract class In<T> extends Conditional<List<T>> {

    In(){}
    
    In(String property, List<T> value) {
        super(property, value);
    }

    In(String property, List<T> value, boolean negated) {
        super(property, value, negated);
    }

    // @Override
    // @SuppressWarnings("unchecked")
    // protected List<U> transform(Class<? extends U> cls) {
    //     return value.stream().map(v -> (U) trans(v, cls)).collect(Collectors.toList());
    // }

}
