import java.io.*;

public class Getting_a_string_from_an_inputstream {
    // Getting a `String` from an `InputStream`/Mendapatkan `String` dari
    // `InputStream`

    // Sebuah String dapat dibaca dari InputStream menggunakan konstruktor array
    // byte.

    /*
     * import java.io.*;
     * public String readString(InputStream input) throws IOException {
     * byte[] bytes = new byte[50]; // supply the length of the string in bytes here
     * input.read(bytes);
     * return new String(bytes);
     * }
     */

    // Ini menggunakan rangkaian karakter default sistem, meskipun rangkaian
    // karakter alternatif dapat ditentukan:

    /*
     * return new String(bytes, Charset.forName("UTF-8"));
     */

    public static void main(String[] args) {
        try {
            InputStream inputStream = new ByteArrayInputStream("Contoh String".getBytes());
            Getting_a_string_from_an_inputstream main = new Getting_a_string_from_an_inputstream();
            String result = main.readString(inputStream);
            System.out.println("String yang dibaca: " + result);
            /*
             * output: String yang dibaca: Contoh String
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readString(InputStream input) throws IOException {
        byte[] bytes = new byte[50]; // supply the length of the string in bytes here
        input.read(bytes);
        return new String(bytes);
        // ------------------
    }

}
