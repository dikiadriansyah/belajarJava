import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Check_if_resource_exists {
    // Check if resource exists/Periksa apakah sumber daya ada

    /**
     * Checks if a resource exists by sending a HEAD-Request.
     * 
     * @param url
     *            The url of a resource which has to be checked.
     * @return true if the response code is 200 OK.
     */
    // public static final boolean checkIfResourceExists(URL url) throws IOException
    // {
    // HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    // conn.setRequestMethod("HEAD");
    // int code = conn.getResponseCode();
    // conn.disconnect();
    // return code == 200;
    // }

    // Penjelasan:
    /*
     * Jika Anda hanya memeriksa apakah ada sumber daya, lebih baik menggunakan
     * permintaan HEAD daripada GET. Hal ini menghindari overhead
     * mentransfer sumber daya.
     * 
     * Perhatikan bahwa metode ini hanya mengembalikan nilai true jika kode
     * responsnya adalah 200. Jika Anda mengantisipasi respons pengalihan (yaitu
     * 3XX),
     * maka metode tersebut mungkin perlu ditingkatkan untuk menghormati mereka.
     */

    // contoh:
    /*
     * checkIfResourceExists(new URL("http://images.google.com/")); // true
     * checkIfResourceExists(new URL("http://pictures.google.com/")); // false
     */

    public static void main(String[] args) throws Exception {
        // checkIfResourceExists(new URL("https://api.restful-api.dev/objects/6")); //
        // true
        // checkIfResourceExists(new URL("http://pictures.google.com/")); // false
        boolean exists = checkIfResourceExists(new URL("https://api.restful-api.dev/objects/6"));
        System.out.println("Resource exists: " + exists);
        /*
         * output:
         * Resource exists: true
         */
    }

    public static final boolean checkIfResourceExists(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("HEAD");
        int code = conn.getResponseCode();
        conn.disconnect();
        return code == 200;
    }

}
