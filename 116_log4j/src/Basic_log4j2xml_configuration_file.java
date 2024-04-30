public class Basic_log4j2xml_configuration_file {
    // Basic log4j2.xml configuration file/File konfigurasi log4j2.xml dasar

    /*
     * <?xml version="1.0" encoding="UTF-8"?>
     * <Configuration>
     * <Appenders>
     * <Console name="STDOUT" target="SYSTEM_OUT">
     * <PatternLayout pattern="%d %-5p [%t] %C{2} %m%n"/>
     * </Console>
     * </Appenders>
     * <Loggers>
     * <Root level="debug">
     * <AppenderRef ref="STDOUT"/>
     * </Root>
     * </Loggers>
     * </Configuration>
     * 
     */

    /*
     * Ini adalah konfigurasi dasar log4j2.xml yang memiliki konsol appender dan
     * root logger. Tata letak pola
     * menentukan pola mana yang harus digunakan untuk mencatat pernyataan.
     * Untuk men-debug pemuatan log4j2.xml Anda dapat menambahkan atribut status =
     * <WARN | DEBUG | ERROR | FATAL |
     * TRACE | INFO> di tag konfigurasi log4j2.xml Anda.
     * Anda juga dapat menambahkan interval monitor sehingga memuat konfigurasi
     * kembali setelah periode interval yang ditentukan. Itu
     * interval monitor dapat ditambahkan ke tag konfigurasi sebagai berikut:
     * monitorInterval = 30. Artinya config
     * akan dimuat setiap 30 detik.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
