import java.io.File; // Import untuk kelas File

public class DataReader2 {
    public String readVal() {
        // Refers to a file somewhere in your application deployment, or
        // perhaps retrieved over a deployment-specific network.
        File f;
        String s = "data";
        // ... Read data from f into s ...
        return s;
    }

}
