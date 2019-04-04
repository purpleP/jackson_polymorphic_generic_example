package hello;

public abstract class Contains extends Conditional<String> {

    Contains(){}

    Contains(String property, String value) {
        super(property, value);
    }
    
    Contains(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
