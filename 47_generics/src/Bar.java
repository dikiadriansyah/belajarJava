public class Bar {

    private String name;

    public Bar() {
        this.name = "Default Bar";
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                '}';
    }
}
