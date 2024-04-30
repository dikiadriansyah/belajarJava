public class viewing_bytecode_with_javap {
    // Viewing bytecode with javap/Melihat bytecode dengan javap

    /*
     * Jika Anda ingin melihat bytecode yang dihasilkan untuk program Java, Anda
     * dapat menggunakan perintah javap yang disediakan untuk melihatnya.
     * Dengan asumsi bahwa kita memiliki file sumber Java berikut:
     */

    /*
     * package com.stackoverflow.documentation;
     * import org.springframework.stereotype.Service;
     * import java.io.IOException;
     * import java.io.InputStream;
     * import java.util.List;
     * 
     * @Service
     * public class HelloWorldService {
     * public void sayHello() {
     * System.out.println("Hello, World!");
     * }
     * private Object[] pvtMethod(List<String> strings) {
     * return new Object[]{strings};
     * }
     * protected String tryCatchResources(String filename) throws IOException {
     * try (InputStream inputStream = getClass().getResourceAsStream(filename)) {
     * byte[] bytes = new byte[8192];
     * int read = inputStream.read(bytes);
     * return new String(bytes, 0, read);
     * } catch (IOException | RuntimeException e) {
     * e.printStackTrace();
     * throw e;
     * }
     * }
     * void stuff() {
     * System.out.println("stuff");
     * }
     * }
     */

    // Setelah mengkompilasi file sumber, penggunaan paling sederhana adalah:
    /*
     * cd <directory containing classes> (e.g. target/classes)
     * javap com/stackoverflow/documentation/SpringExample
     */

    // Yang menghasilkan output
    /*
     * Compiled from "HelloWorldService.java"
     * public class com.stackoverflow.documentation.HelloWorldService {
     * public com.stackoverflow.documentation.HelloWorldService();
     * public void sayHello();
     * protected java.lang.String tryCatchResources(java.lang.String) throws
     * java.io.IOException;
     * void stuff();
     * }
     */

    /*
     * Ini mencantumkan semua metode non-pribadi di kelas, tapi itu tidak terlalu
     * berguna untuk sebagian besar tujuan. Pengikut
     * perintah jauh lebih berguna:
     * javap -p -c -s -constants -l -v
     * com/stackoverflow/documentation/HelloWorldService
     */

    // Yang menghasilkan output:
    /*
     * Classfile
     * /Users/pivotal/IdeaProjects/stackoverflow-springdocs/target/classes/com/
     * stackoverflow/documentation/HelloWorldService.class
     * Last modified Jul 22, 2016; size 2167 bytes
     * MD5 checksum 6e33b5c292ead21701906353b7f06330
     * Compiled from "HelloWorldService.java"
     * public class com.stackoverflow.documentation.HelloWorldService
     * minor version: 0
     * major version: 51
     * flags: ACC_PUBLIC, ACC_SUPER
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
