import java.io.*;
import java.net.Socket;

public class Socket_example_reading_a_web_page_using_a_simple_socket {
    // Socket example - reading a web page using a simple socket/ Contoh soket -
    // membaca halaman web menggunakan soket sederhana

    /*
     * import java.io.*;
     * import java.net.Socket;
     * public class Main {
     * public static void main(String[] args) throws IOException {//We don't handle
     * Exceptions in this
     * example
     * //Open a socket to stackoverflow.com, port 80
     * Socket socket = new Socket("stackoverflow.com",80);
     * //Prepare input, output stream before sending request
     * OutputStream outStream = socket.getOutputStream();
     * InputStream inStream = socket.getInputStream();
     * BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
     * PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));
     * //Send a basic HTTP header
     * writer.print("GET / HTTP/1.1\nHost:stackoverflow.com\n\n");
     * writer.flush();
     * //Read the response
     * System.out.println(readFully(reader));
     * //Close the socket
     * socket.close();
     * }
     * 
     * private static String readFully(Reader in) {
     * StringBuilder sb = new StringBuilder();
     * int BUFFER_SIZE=1024;
     * char[] buffer = new char[BUFFER_SIZE]; // or some other size,
     * int charsRead = 0;
     * while ( (charsRead = rd.read(buffer, 0, BUFFER_SIZE)) != -1) {
     * sb.append(buffer, 0, charsRead);
     * }
     * }
     * }
     */

    /*
     * Anda akan mendapatkan respons yang dimulai dengan HTTP/1.1 200 OK, yang
     * menunjukkan respons HTTP normal, diikuti dengan
     * sisa header HTTP, diikuti oleh halaman web mentah dalam bentuk HTML.
     * 
     * Perhatikan bahwa metode readFully() penting untuk mencegah pengecualian EOF
     * prematur. Baris terakhir halaman web mungkin kehilangan pengembalian, untuk
     * menandakan akhir baris, maka
     * readLine() akan mengeluh, jadi seseorang harus membacanya dengan tangan atau
     * menggunakan metode utilitas dari Apache commons-io IOUtils
     * 
     * Contoh ini dimaksudkan sebagai demonstrasi sederhana untuk menghubungkan ke
     * sumber daya yang ada menggunakan soket, ini bukan cara praktis untuk
     * mengakses halaman web. Jika Anda perlu mengakses halaman web menggunakan
     * Java, sebaiknya gunakan pustaka klien HTTP yang sudah ada seperti Apache HTTP
     * Client atau Google's HTTP Client
     */

    public static void main(String[] args) throws IOException {
        // Open a socket to stackoverflow.com, port 80
        Socket socket = new Socket("stackoverflow.com", 80);
        // Prepare input, output stream before sending request
        OutputStream outStream = socket.getOutputStream();
        InputStream inStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
        // Send a basic HTTP header
        writer.print("GET / HTTP/1.1\r\nHost: stackoverflow.com\r\n\r\n");
        writer.flush();
        // Read the response
        System.out.println(readFully(reader));
        // Close the socket
        socket.close();
    }

    private static String readFully(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int BUFFER_SIZE = 1024;
        char[] buffer = new char[BUFFER_SIZE];
        int charsRead;
        while ((charsRead = reader.read(buffer, 0, BUFFER_SIZE)) != -1) {
            sb.append(buffer, 0, charsRead);
        }
        return sb.toString();
    }

}
