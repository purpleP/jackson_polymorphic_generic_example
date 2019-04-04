package hello;

abstract class LowerOrEqual<T> extends Conditional<T> {

    LowerOrEqual(){}
    
    LowerOrEqual(String property, T value) {
        super(property, value);
    }

    LowerOrEqual(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
