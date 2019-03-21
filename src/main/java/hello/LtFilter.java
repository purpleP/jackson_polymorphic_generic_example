package hello;

abstract class LtFilter<T, U extends Comparable<U>> extends DataFilter<T, U, U> {
    LtFilter(){}
    
    LtFilter(String property, T value) {
        super(property, value);
    }

    LtFilter(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
