package hello;

abstract class Lower<T> extends Conditional<T> {
    Lower(){}
    
    Lower(String property, T value) {
        super(property, value);
    }

    Lower(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
