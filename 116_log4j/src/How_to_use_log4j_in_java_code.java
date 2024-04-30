public class How_to_use_log4j_in_java_code {
    // How to use Log4j in Java code/Cara menggunakan Log4j dalam kode Java

    // Pertama-tama perlu membuat final static objek logger :
    // final static Logger logger = Logger.getLogger(classname.class);

    // Kemudian, panggil metode logging:

    /*
     * //logs an error message
     * logger.info("Information about some param: " + parameter); // Note that this
     * line could throw a NullPointerException!
     * 
     * //in order to improve performance, it is advised to use the `isXXXEnabled()`
     * Methods
     * if( logger.isInfoEnabled() ){
     * logger.info("Information about some param: " + parameter);
     * }
     * // In log4j2 parameter substitution is preferable due to readability and
     * performance
     * // The parameter substitution only takes place if info level is active which
     * obsoletes the use of isXXXEnabled().
     * logger.info("Information about some param: {}" , parameter);
     * //logs an exception
     * logger.error("Information about some error: ", exception);
     * 
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
