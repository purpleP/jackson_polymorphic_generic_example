package hello;

class EqFilter<T> extends DataFilter<T> {
    EqFilter() {}

    EqFilter(String property, T value) {
        super(property, value);
    }
}
