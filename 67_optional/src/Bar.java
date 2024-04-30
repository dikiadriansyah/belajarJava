import java.util.Optional;

public class Bar {
    private String message;

    public Bar() {
        this.message = "Hello from Bar!";
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "message='" + message + '\'' +
                '}';
    }
}
