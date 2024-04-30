public class Properties_file_to_log_to_db {
    // Properties-File to log to DB/Properti-File untuk masuk ke DB

    /*
     * Agar contoh ini berfungsi, Anda memerlukan driver JDBC yang kompatibel dengan
     * sistem tempat database dijalankan. Sebuah
     * opensource yang memungkinkan Anda terhubung ke database DB2 pada Sistem IBM
     * saya dapat ditemukan di sini: JT400
     * 
     * Meskipun contoh ini khusus untuk DB2, contoh ini berfungsi untuk hampir semua
     * sistem lain jika Anda menukar driver dan
     * sesuaikan URL JDBC.
     */

    /*
     * # Root logger option
     * log4j.rootLogger= ERROR, DB
     * # Redirect log messages to a DB2
     * # Define the DB appender
     * log4j.appender.DB=org.apache.log4j.jdbc.JDBCAppender
     * # Set JDBC URL (!!! adapt to your target system !!!)
     * log4j.appender.DB.URL=jdbc:as400://10.10.10.1:446/DATABASENAME;naming=system;
     * errors=full;
     * # Set Database Driver (!!! adapt to your target system !!!)
     * log4j.appender.DB.driver=com.ibm.as400.access.AS400JDBCDriver
     * # Set database user name and password
     * log4j.appender.DB.user=USER
     * log4j.appender.DB.password=PASSWORD
     * # Set the SQL statement to be executed.
     * log4j.appender.DB.sql=INSERT INTO DB.TABLENAME
     * VALUES('%d{yyyy-MMdd}','%d{HH:mm:ss}','%C','%p','%m')
     * # Define the layout for file appender
     * log4j.appender.DB.layout=org.apache.log4j.PatternLayout
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
