package hello;

abstract class Lower<T, U extends Comparable<U>> extends Conditional<T, U, U> {
    Lower(){}
    
    Lower(String property, T value) {
        super(property, value);
    }

    Lower(String property, T value, boolean negated) {
        super(property, value, negated);
    }

}
