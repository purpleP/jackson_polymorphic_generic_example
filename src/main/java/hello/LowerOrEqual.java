package hello;

abstract class LowerOrEqual<T, U extends Comparable<U>> extends Conditional<T, U, U> {

    LowerOrEqual(){}
    
    LowerOrEqual(String property, T value) {
        super(property, value);
    }

    LowerOrEqual(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
