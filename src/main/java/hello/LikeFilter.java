package hello;

class LikeFilter extends DataFilter<String> {
    LikeFilter(){}
    
    LikeFilter(String property, String value) {
        super(property, value);
    }

    LikeFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }
}
