import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class get_response_body_from_a_url_as_a_string {
    // Get response body from a URL as a String/Dapatkan isi respons dari URL
    // sebagai String

    /*
     * String getText(String url) throws IOException {
     * HttpURLConnection connection = (HttpURLConnection) new
     * URL(url).openConnection();
     * //add headers to the connection, or check the status if desired..
     * 
     * // handle error response code it occurs
     * int responseCode = conn.getResponseCode();
     * InputStream inputStream;
     * if (200 <= responseCode && responseCode <= 299) {
     * inputStream = connection.getInputStream();
     * } else {
     * inputStream = connection.getErrorStream();
     * }
     * BufferedReader in = new BufferedReader(
     * new InputStreamReader(
     * inputStream));
     * StringBuilder response = new StringBuilder();
     * String currentLine;
     * while ((currentLine = in.readLine()) != null)
     * response.append(currentLine);
     * in.close();
     * return response.toString();
     * }
     * 
     */

    // Ini akan mengunduh data teks dari URL yang ditentukan, dan mengembalikannya
    // sebagai sebuah String.

    // Cara kerjanya:

    /*
     * Pertama, kita membuat HttpUrlConnection dari URL kita, dengan new
     * URL(url).openConnection(). Kami melemparkan
     * UrlConnection ini kembali ke HttpUrlConnection, jadi kami memiliki akses ke
     * hal-hal seperti menambahkan header (seperti User Agent), atau memeriksa
     * kode respons. (Contoh ini tidak melakukan hal tersebut, namun mudah untuk
     * ditambahkan.)
     * 
     * Kemudian, buat InputStream berdasarkan kode respons (untuk penanganan
     * kesalahan)
     * 
     * Kemudian, buat BufferedReader yang memungkinkan kita membaca teks dari
     * InputStream yang kita dapatkan dari koneksi.
     * 
     * Sekarang, kita menambahkan teks ke StringBuilder, baris demi baris.
     * 
     * Tutup InputStream, dan kembalikan String yang sekarang kita miliki.
     */

    // Catatan:
    /*
     * Metode ini akan memunculkan IoException jika terjadi kegagalan (seperti
     * kesalahan jaringan, atau tidak ada koneksi internet),
     * dan itu juga akan memunculkan MalformedUrlException yang tidak dicentang jika
     * URL yang diberikan tidak valid.
     * 
     * Ini dapat digunakan untuk membaca dari URL apa pun yang mengembalikan teks,
     * seperti halaman web (HTML), REST API yang
     * mengembalikan JSON atau XML, dll.
     * 
     * Lihat juga: Baca URL ke String dalam beberapa baris kode Java.
     */

    // Penggunaan:
    // sangat sederhana:

    /*
     * String text = getText(”http://example.com");
     * //Do something with the text from example.com, in this case the HTML.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ---------
        String text = getText("http://example.com");

        // Do something with the text from example.com, in this case the HTML.
        System.out.println(text);
        /*
         * output:
         * <!doctype html><html><head> <title>Example Domain</title> <meta
         * charset="utf-8" /> <meta http-equiv="Content-type"
         * content="text/html; charset=utf-8" /> <meta name="viewport"
         * content="width=device-width, initial-scale=1" /> <style type="text/css"> body
         * { background-color: #f0f0f2; margin:
         * 0; padding: 0; font-family: -apple-system, system-ui, BlinkMacSystemFont,
         * "Segoe UI", "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
         * } div { width: 600px; margin: 5em auto; padding: 2em; background-color:
         * #fdfdff; border-radius: 0.5em; box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);
         * } a:link, a:visited { color: #38488f; text-decoration: none; } @media
         * (max-width: 700px) {
         * div { margin: 0 auto; width: auto; } } </style> </head><body><div>
         * <h1>Example Domain</h1> <p>This domain is for use in illustrative examples in
         * documents. You may use this domain in literature without prior coordination
         * or asking for permission.</p> <p><a
         * href="https://www.iana.org/domains/example">More
         * information...</a></p></div></body></html>
         */
    }

    static String getText(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        // add headers to the connection, or check the status if desired..

        // handle error response code it occurs
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (200 <= responseCode && responseCode <= 299) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        inputStream));
        StringBuilder response = new StringBuilder();
        String currentLine;
        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);
        in.close();
        return response.toString();
    }

}
