public class Argument {
    private String value;

    public Argument(String value) {
        this.value = value;
    }

    public String prettyPrint() {
        return "Argument: " + value;
    }
}
