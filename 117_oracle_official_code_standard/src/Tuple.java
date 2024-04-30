public class Tuple<T> {

    private T[] elements;

    public Tuple(T... elements) {
        this.elements = elements;
    }

    public T[] getElements() {
        return elements;
    }
}
