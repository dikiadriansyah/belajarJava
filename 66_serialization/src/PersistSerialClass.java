import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class PersistSerialClass {
    public static void main(String[] args) {
        String filename = "time.ser";
        SerialClass time = new SerialClass(); // We will write this object to file system.
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(time); // Write byte stream to file system.
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}