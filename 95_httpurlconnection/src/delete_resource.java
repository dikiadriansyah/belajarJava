import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class delete_resource {
    // Delete resource/Hapus sumber daya

    /*
     * public static void delete (String urlString, String contentType) throws
     * IOException {
     * HttpURLConnection connection = null;
     * 
     * try {
     * URL url = new URL(urlString);
     * connection = (HttpURLConnection) url.openConnection();
     * connection.setDoInput(true);
     * connection.setRequestMethod("DELETE");
     * connection.setRequestProperty("Content-Type", contentType);
     * 
     * Map<String, List<String>> map = connection.getHeaderFields();
     * StringBuilder sb = new StringBuilder();
     * Iterator<Map.Entry<String, String>> iterator =
     * responseHeader.entrySet().iterator();
     * while(iterator.hasNext())
     * {
     * Map.Entry<String, String> entry = iterator.next();
     * sb.append(entry.getKey());
     * sb.append('=').append('"');
     * sb.append(entry.getValue());
     * sb.append('"');
     * if(iterator.hasNext())
     * {
     * sb.append(',').append(' ');
     * }
     * }
     * System.out.println(sb.toString());
     * 
     * } catch (Exception e) {
     * e.printStackTrace();
     * } finally {
     * if (connection != null) connection.disconnect();
     * }
     * }
     */

    /*
     * Ini akan delete sumber daya di URL yang ditentukan, lalu mencetak header
     * respons.
     */

    // bagaimana ini bekerja
    /*
     * 1. kita memperoleh HttpURLConnection dari sebuah URL.
     * 2. Atur tipe konten menggunakan setRequestProperty, secara default 3.
     * application/x-www-form-urlencoded
     * 4. setDoInput(true) memberi tahu koneksi bahwa kita bermaksud menggunakan
     * koneksi URL untuk input.
     * 5. setRequestMethod("DELETE") untuk melakukan HTTP DELETE
     */

    // Akhirnya kami mencetak header respons server.

    public static void main(String[] args) throws Exception {

        try {
            delete("https://api.restful-api.dev/objects/6", "application/json");
            /*
             * output:
             * Transfer-Encoding="[chunked]", null="[HTTP/1.1 405 Method Not Allowed]",
             * CF-Cache-Status="[DYNAMIC]", CF-RAY="[85ac65bebd4424c3-HKG]",
             * Server="[cloudflare]",
             * NEL="[{"success_fraction":0,"report_to":"cf-nel","max_age":604800}]",
             * Report-To="[{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?
             * s=Nq5JQkio9cERXRnHVSKspeKWzAEApPY2A2sKdlVvOSD1CsMdXQ3Edv3W1rU%
             * 2FRvT5jenLRFCCQrmu8hxzPMc6Iu%2FOWaBr3A2WyHyhyC9DCVinyize%2BXSvl2i%
             * 2B4D6zBIrsM1U%2Fmma0"}],"group":"cf-nel","max_age":604800}]",
             * Connection="[keep-alive]",
             * Vary="[Access-Control-Request-Headers, Access-Control-Request-Method, Origin]"
             * , alt-svc="[h3=":443"; ma=86400]", Date="[Sun, 25 Feb 2024 02:07:54 GMT]",
             * Content-Type="[application/json]"
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String urlString, String contentType) throws IOException {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", contentType);

            Map<String, List<String>> map = connection.getHeaderFields();
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, List<String>> entry = iterator.next();
                sb.append(entry.getKey());
                sb.append('=').append('"');
                sb.append(entry.getValue());
                sb.append('"');
                if (iterator.hasNext()) {
                    sb.append(',').append(' ');
                }
            }
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

}
