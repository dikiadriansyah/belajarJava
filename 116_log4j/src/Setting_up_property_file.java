public class Setting_up_property_file {
    // Setting up property file/Menyiapkan file properti
    /*
     * Log4j memberi Anda kemungkinan untuk memasukkan data ke konsol dan file
     * secara bersamaan. Buat file log4j.properties dan masukkan ke dalam
     * konfigurasi dasar ini:
     * 
     * # Root logger option
     * log4j.rootLogger=DEBUG, stdout, file
     * # Redirect log messages to console
     * log4j.appender.stdout=org.apache.log4j.ConsoleAppender
     * log4j.appender.stdout.Target=System.out
     * log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
     * 
     * log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p
     * %c{1}:%L - %m%n
     * # Redirect log messages to a log file, support file rolling.
     * log4j.appender.file=org.apache.log4j.RollingFileAppender
     * log4j.appender.file.File=C:\\log4j-application.log
     * log4j.appender.file.MaxFileSize=5MB
     * log4j.appender.file.MaxBackupIndex=10
     * log4j.appender.file.layout=org.apache.log4j.PatternLayout
     * log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p
     * %c{1}:%L - %m%n
     */

    // Jika Anda menggunakan pakar, letakkan file properti ini di jalur:
    /// ProjectFolder/src/java/resources
}
