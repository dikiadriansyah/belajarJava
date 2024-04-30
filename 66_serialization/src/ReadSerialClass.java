import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

import java.io.Serializable;

// import java.io.java.lang.ClassNotFoundException;

public class ReadSerialClass {
    public static void main(String[] args) {
        String filename = "time.ser";
        SerialClass time = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            time = (SerialClass) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        // print out restored time
        System.out.println("Restored time: " + time.getCurrentTime());
        /*
         * output:
         * Restored time: Wed Jan 24 14:10:03 WIB 2024
         */

    }
}