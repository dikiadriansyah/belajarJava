import java.io.IOException;

public interface Logger extends AutoCloseable {

    void log(String message) throws IOException;
}