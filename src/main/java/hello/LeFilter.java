package hello;

abstract class LeFilter<T, U extends Comparable<U>> extends DataFilter<T, U, U> {

    LeFilter(){}
    
    LeFilter(String property, T value) {
        super(property, value);
    }

    LeFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
