package hello;

public abstract class Like extends Conditional<String> {

    Like(){}
    
    Like(String property, String value) {
        super(property, value);
    }

    Like(String property, String value, boolean negated) {
        super(property, value, negated);
    }

}
