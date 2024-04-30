public class How_to_get_log4j {
    // How to get Log4j/Bagaimana cara mendapatkan Log4j

    // Current version (log4j2)

    // gunakan maven:
    // Tambahkan ketergantungan berikut ke file POM.xml Anda:

    /*
     * <dependencies>
     * <dependency>
     * <groupId>org.apache.logging.log4j</groupId>
     * <artifactId>log4j-api</artifactId>
     * <version>2.6.2</version>
     * </dependency>
     * <dependency>
     * <groupId>org.apache.logging.log4j</groupId>
     * <artifactId>log4j-core</artifactId>
     * <version>2.6.2</version>
     * </dependency>
     * </dependencies>
     */

    // gunakan ivy:
    /*
     * <dependencies>
     * <dependency org="org.apache.logging.log4j" name="log4j-api" rev="2.6.2" />
     * <dependency org="org.apache.logging.log4j" name="log4j-core" rev="2.6.2" />
     * </dependencies>
     * 
     */

    // gunakan gradle:
    /*
     * dependencies {
     * compile group: 'org.apache.logging.log4j', name: 'log4j-api', version:
     * '2.6.2'
     * compile group: 'org.apache.logging.log4j', name: 'log4j-core', version:
     * '2.6.2'
     * }
     */

    // dapatkan log4j 1.x
    // catatan: Log4j 1.x has reached End-of-Life (EOL) (see Remarks).

    // gunakan maven:
    // Deklarasikan ketergantungan ini dalam file POM.xml:
    /*
     * <dependency>
     * <groupId>log4j</groupId>
     * <artifactId>log4j</artifactId>
     * <version>1.2.17</version>
     * </dependency>
     */

    // Menggunakan Ivy:
    /*
     * <dependency org="log4j" name="log4j" rev="1.2.17"/>
     * 
     */

    // gunakan gradle:
    // compile group: 'log4j', name: 'log4j', version: '1.2.17'

    // gunakan buildr:
    // 'log4j:log4j:jar:1.2.17'

    // Menambahkan secara manual di jalur build:
    // unduh dari Log4j website project

    public static void main(String[] args) throws Exception {
    }
}
