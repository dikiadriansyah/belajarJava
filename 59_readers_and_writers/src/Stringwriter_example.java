import java.io.*;

public class Stringwriter_example {
    // contoh StringWriter

    /*
     * Kelas Java StringWriter adalah aliran karakter yang mengumpulkan output dari
     * buffer string, yang dapat digunakan untuk membuat string.
     * 
     * Kelas StringWriter memperluas kelas Writer.
     * 
     * Di kelas StringWriter, sumber daya sistem seperti soket jaringan dan file
     * tidak digunakan, sehingga menutup
     * StringWriter tidak diperlukan
     */

    /*
     * import java.io.*;
     * public class StringWriterDemo {
     * public static void main(String[] args) throws IOException {
     * char[] ary = new char[1024];
     * StringWriter writer = new StringWriter();
     * FileInputStream input = null;
     * BufferedReader buffer = null;
     * input = new FileInputStream("c://stringwriter.txt");
     * buffer = new BufferedReader(new InputStreamReader(input, "UTF-8"));
     * int x;
     * while ((x = buffer.read(ary)) != -1) {
     * writer.write(ary, 0, x);
     * }
     * System.out.println(writer.toString());
     * writer.close();
     * buffer.close();
     * }
     * }
     */

    /*
     * Contoh di atas membantu kita mengetahui contoh sederhana StringWriter
     * menggunakan BufferedReader untuk membaca data file dari stream.
     */

    public static void main(String[] args) {
        char[] ary = new char[1024];
        StringWriter writer = new StringWriter();
        FileInputStream input = null;
        BufferedReader buffer = null;

        try {
            input = new FileInputStream("outfilename");
            buffer = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            int x;
            while ((x = buffer.read(ary)) != -1) {
                writer.write(ary, 0, x);
            }
            System.out.println(writer.toString());
            writer.close();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * the text
         * more text
         * a
         */

    }
}
