import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// import servicetest.Logger;

public class FileLogger implements Logger {
    private final BufferedWriter writer;

    public FileLogger() throws IOException {
        writer = new BufferedWriter(new FileWriter("log.txt"));
    }

    @Override
    public void log(String message) throws IOException {
        writer.append(message);
        writer.newLine();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}