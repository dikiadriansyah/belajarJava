import java.net.URL;

public class Url_of_a_loaded_class_inside_a_multi_release_jar {
    // URL of a loaded class inside a multi-release Jar/URL kelas yang dimuat di
    // dalam Jar multi-rilis

    /*
     * Mengingat Jar multi-rilis berikut:
     * jar root
     * - demo
     * - SampleClass.class
     * - META-INF
     * - versions
     * - 9
     * - demo
     * - SampleClass.class
     * 
     */

    // Kelas berikut mencetak URL SampleClass:
    /*
     * package demo;
     * import java.net.URL;
     * public class Main {
     * public static void main(String[] args) throws Exception {
     * URL url = Main.class.getClassLoader().getResource("demo/SampleClass.class");
     * System.out.println(url);
     * }
     * }
     */

    /*
     * Jika kelas dikompilasi dan ditambahkan pada entri berversi untuk Java 9 di
     * MRJAR, menjalankannya akan menghasilkan:
     * C:\Users\manouti>java --class-path MR.jar demo.Main
     * jar:file:/C:/Users/manouti/MR.jar!/META-INF/versions/9/demo/SampleClass.class
     * 
     */
    public static void main(String[] args) throws Exception {
        URL url = Url_of_a_loaded_class_inside_a_multi_release_jar.class.getClassLoader()
                .getResource("Example_of_a_multirelease_jar_files_contents.class");
        System.out.println(url);
        // output:
        // file:/C:/Users/diki/AppData/Roaming/Code/User/workspaceStorage/44a01b534d757a977492f8382d1624a1/redhat.java/jdt_ws/belajarJava_4f317acc/bin/Example_of_a_multirelease_jar_files_contents.class
    }
}
