import java.security.*;

// Your implementation of ClassProvider interface
interface ClassProvider {
    byte[] getClass(String name);

    CodeSource getCodeSource();
}