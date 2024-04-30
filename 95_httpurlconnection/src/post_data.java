import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class post_data {
    // POST data/data POSTING

    /*
     * public static void post(String url, byte [] data, String contentType) throws
     * IOException {
     * HttpURLConnection connection = null;
     * OutputStream out = null;
     * InputStream in = null;
     * try {
     * connection = (HttpURLConnection) new URL(url).openConnection();
     * connection.setRequestProperty("Content-Type", contentType);
     * connection.setDoOutput(true);
     * out = connection.getOutputStream();
     * out.write(data);
     * out.close();
     * in = connection.getInputStream();
     * BufferedReader reader = new BufferedReader(new InputStreamReader(in));
     * String line = null;
     * while ((line = reader.readLine()) != null) {
     * System.out.println(line);
     * }
     * in.close();
     * } finally {
     * if (connection != null) connection.disconnect();
     * if (out != null) out.close();
     * if (in != null) in.close();
     * }
     * }
     */

    // Ini akan POST data ke URL yang ditentukan, lalu membaca respons baris demi
    // baris.

    // Bagaimana itu bekerja

    /*
     * 1. Seperti biasa kita memperoleh HttpURLConnection dari sebuah URL.
     * 2. Atur tipe konten menggunakan setRequestProperty, secara default
     * application/x-www-form-urlencoded
     * 3. setDoOutput(true) memberitahu koneksi bahwa kita akan mengirimkan data.
     * 4. Kemudian kita memperoleh OutputStream dengan memanggil getOutputStream()
     * dan menulis data ke dalamnya. Jangan lupa untuk menutupnya setelah selesai.
     * 5. Terakhir kita membaca respon server.
     */

    public static void main(String[] args) throws Exception {
        try {
            String box1 = "{\\\"name\\\": \\\"Apple iPad Air\\\", \\\"data\\\": { \\\"Generation\\\": \\\"4th\\\", \\\"Price\\\": \\\"519.99\\\", \\\"Capacity\\\": \\\"256 GB\\\" }}";
            String url = "https://api.restful-api.dev/objects/"; // Ganti dengan URL yang sesuai
            String contentType = "application/json"; // Ganti dengan tipe konten yang sesuai
            byte[] data = box1.getBytes(); // Ganti dengan data yang ingin Anda kirim

            post(url, data, contentType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Hello world from Spring Boot
         */
    }

    public static void post(String url, byte[] data, String contentType) throws IOException {
        HttpURLConnection connection = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Content-Type", contentType);
            connection.setDoOutput(true);
            out = connection.getOutputStream();
            out.write(data);
            out.close();
            in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } finally {
            if (connection != null)
                connection.disconnect();
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        }
    }

}
