package hello;

class IsNullFilter<T> extends DataFilter<Void> {
    IsNullFilter(){}
    
    IsNullFilter(String property) {
        super(property, null);
    }

    IsNullFilter(String property, boolean negated) {
        super(property, null, negated);
    }
}
