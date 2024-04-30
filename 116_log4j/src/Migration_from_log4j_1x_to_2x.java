public class Migration_from_log4j_1x_to_2x {
    // Migrating from log4j 1.x to 2.x/Bermigrasi dari log4j 1.x ke 2.x

    /*
     * Jika Anda ingin bermigrasi dari log4j 1.x yang ada di proyek Anda ke log4j
     * 2.x, hapus semua log4j 1.x yang ada
     * dependensi dan tambahkan ketergantungan berikut:
     * 
     * Log4j 1.x API Bridge
     * Maven Build
     * <dependencies>
     * <dependency>
     * <groupId>org.apache.logging.log4j</groupId>
     * <artifactId>log4j-1.2-api</artifactId>
     * <version>2.6.2</version>
     * </dependency>
     * </dependencies>
     * 
     * Ivy Build
     * <dependencies>
     * <dependency org="org.apache.logging.log4j" name="log4j-1.2-api" rev="2.6.2"
     * />
     * </dependencies>
     * 
     * Gradle Build
     * dependencies {
     * compile group: 'org.apache.logging.log4j', name: 'log4j-1.2-api', version:
     * '2.6.2'
     * }
     * 
     */

    /*
     * Apache Commons Logging Bridge Jika proyek Anda menggunakan Apache Commons
     * Logging yang menggunakan log4j 1.x dan Anda
     * ingin memigrasikannya ke log4j 2.x lalu tambahkan dependensi berikut:
     * 
     * Maven Build
     * <dependencies>
     * <dependency>
     * <groupId>org.apache.logging.log4j</groupId>
     * <artifactId>log4j-jcl</artifactId>
     * <version>2.6.2</version>
     * </dependency>
     * </dependencies>
     * Ivy Build
     * <dependencies>
     * <dependency org="org.apache.logging.log4j" name="log4j-jcl" rev="2.6.2" />
     * </dependencies>
     * Gradle Build
     * dependencies {
     * compile group: 'org.apache.logging.log4j', name: 'log4j-jcl', version:
     * '2.6.2'
     * }
     * 
     */

    /*
     * Catatan: Jangan hapus dependensi apa pun yang ada pada logging Apache commons
     */

    // Referensi: https://logging.apache.org/log4j/2.x/maven-artifacts.html

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
