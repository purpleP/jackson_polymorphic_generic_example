package hello;

class ContainsFilter extends DataFilter<String> {
    ContainsFilter(){}

    ContainsFilter(String property, String value) {
        super(property, value);
    }
    
    ContainsFilter(String property, String value, boolean negated) {
        super(property, value, negated);
    }
}
