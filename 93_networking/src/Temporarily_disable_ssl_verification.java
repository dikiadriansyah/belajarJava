import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import java.security.cert.CertificateException;

public class Temporarily_disable_ssl_verification {
    // Temporarily disable SSL verification (for testing purposes) / Nonaktifkan
    // sementara verifikasi SSL (untuk tujuan pengujian)

    /*
     * Terkadang dalam lingkungan pengembangan atau pengujian, rantai sertifikat SSL
     * mungkin belum sepenuhnya terbentuk(yet).
     * 
     * Untuk terus mengembangkan dan menguji, Anda dapat mematikan verifikasi SSL
     * secara terprogram dengan menginstal "all-trusting" manajer kepercayaan:
     * try {
     * // Create a trust manager that does not validate certificate chains
     * TrustManager[] trustAllCerts = new TrustManager[] {
     * new X509TrustManager() {
     * public X509Certificate[] getAcceptedIssuers() {
     * return null;
     * }
     * public void checkClientTrusted(X509Certificate[] certs, String authType) {
     * }
     * public void checkServerTrusted(X509Certificate[] certs, String authType) {
     * }
     * }
     * };
     * // Install the all-trusting trust manager
     * SSLContext sc = SSLContext.getInstance("SSL");
     * sc.init(null, trustAllCerts, new java.security.SecureRandom());
     * HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
     * // Create all-trusting host name verifier
     * HostnameVerifier allHostsValid = new HostnameVerifier() {
     * public boolean verify(String hostname, SSLSession session) {
     * return true;
     * }
     * };
     * // Install the all-trusting host verifier
     * HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
     * } catch (NoSuchAlgorithmException | KeyManagementException e) {
     * e.printStackTrace();
     * }
     * 
     */

    public static void main(String[] args) {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
