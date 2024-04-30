public class Example2 {
    private int i;

    Example2(int i) {
        this.i = i;
    }

    static Example2 getExample(int i) {
        return new Example2(i);
    }

    @Override
    public String toString() {
        return "An example [" + i + "]";
    }
}
