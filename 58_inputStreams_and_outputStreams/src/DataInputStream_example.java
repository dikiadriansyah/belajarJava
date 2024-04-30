import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStream_example {
    // DataInputStream Example/contoh DataInputStream

    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("outfilename");
        DataInputStream inst = new DataInputStream(input);
        int count = input.available();
        byte[] arr = new byte[count];
        inst.read(arr);
        for (byte byt : arr) {
            char ki = (char) byt;
            System.out.print(ki + "-");
        }

        /*
         * output:
         * --h-e- -t-e-x-t-
         * -m-o-r-e- -t-e-x-t-
         * -
         */

    }
}
