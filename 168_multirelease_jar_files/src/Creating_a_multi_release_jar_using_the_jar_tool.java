import java.net.URL;

public class Creating_a_multi_release_jar_using_the_jar_tool {
    // Creating a multi-release Jar using the jar tool/Membuat Jar multi-rilis
    // menggunakan alat jar

    /*
     * Perintah jar dapat digunakan untuk membuat Jar multi-rilis yang berisi dua
     * versi dari kelas yang sama yang dikompilasi
     * baik Java 8 dan Java 9, meskipun dengan peringatan yang menyatakan bahwa
     * kelas-kelasnya identik:
     * 
     * C:\Users\manouti>jar --create --file MR.jar -C sampleproject-base demo
     * --release 9 -C
     * sampleproject-9 demo
     * Warning: entry META-INF/versions/9/demo/SampleClass.class contains a class
     * that
     * is identical to an entry already in the jar
     * 
     * 
     */

    /*
     * Opsi --release 9 memberitahu jar untuk memasukkan semua yang berikut (paket
     * demo di dalam sampleproject-9
     * direktori) di dalam entri berversi di MRJAR, yaitu di bawah
     * root/META-INF/versions/9. Hasilnya adalah konten berikut:
     * 
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

    // Sekarang mari kita buat kelas bernama Main yang mencetak URL SampleClass, dan
    // menambahkannya untuk versi Java 9:
    /*
     * package demo;
     * import java.net.URL;
     * public class Main {
     * public static void main(String[] args) throws Exception {
     * URL url = Main.class.getClassLoader().getResource("demo/SampleClass.class");
     * System.out.println(url);
     * }
     * }
     * 
     */

    // Jika kita mengkompilasi kelas ini dan menjalankan kembali perintah jar, kita
    // mendapatkan kesalahan:
    /*
     * C:\Users\manouti>jar --create --file MR.jar -C sampleproject-base demo
     * --release 9 -C
     * sampleproject-9 demoentry: META-INF/versions/9/demo/Main.class, contains a
     * new public class not
     * found in base entries
     * Warning: entry META-INF/versions/9/demo/Main.java, multiple resources with
     * same name
     * Warning: entry META-INF/versions/9/demo/SampleClass.class contains a class
     * that
     * is identical to an entry already in the jar
     * invalid multi-release jar file MR.jar deleted
     * 
     */

    /*
     * Alasannya adalah alat jar mencegah penambahan kelas publik ke entri berversi
     * jika kelas tersebut tidak ditambahkan ke entri dasar juga. Hal ini dilakukan
     * agar MRJAR menampilkan API publik yang sama untuk versi Java yang berbeda.
     * Perhatikan bahwa saat runtime, aturan ini tidak diperlukan. Ini mungkin hanya
     * diaplikasikan dengan alat seperti toples. Dalam kasus khusus ini, tujuan Main
     * adalah untuk menjalankan kode sampel, jadi kita cukup menambahkan salinannya
     * di entri dasar. Jika kelas tersebut merupakan bagian dari implementasi baru
     * yang hanya kita perlukan untuk Java 9, maka kelas tersebut dapat dijadikan
     * non-publik.
     * 
     * Untuk menambahkan Main ke entri root, pertama-tama kita perlu
     * mengkompilasinya untuk menargetkan rilis pra-Java 9. Ini dapat dilakukan
     * dengan menggunakan opsi --release javac yang baru:
     * 
     * C:\Users\manouti\sampleproject-base\demo>javac --release 8 Main.java
     * C:\Users\manouti\sampleproject-base\demo>cd ../..
     * C:\Users\manouti>jar --create --file MR.jar -C sampleproject-base demo
     * --release 9 -C
     * sampleproject-9 demo
     * 
     */

    // Menjalankan kelas Utama menunjukkan bahwa SampleClass dimuat dari direktori
    // berversi:
    /*
     * C:\Users\manouti>java --class-path MR.jar demo.Main
     * jar:file:/C:/Users/manouti/MR.jar!/META-INF/versions/9/demo/SampleClass.class
     */
    public static void main(String[] args) throws Exception {
        URL url = Creating_a_multi_release_jar_using_the_jar_tool.class.getClassLoader()
                .getResource("Example_of_a_multirelease_jar_files_contents.class");
        System.out.println(url);
        /*
         * output: file:/C:/Users/diki/AppData/Roaming/Code/User/workspaceStorage/
         * 44a01b534d757a977492f8382d1624a1/redhat.java/jdt_ws/belajarJava_4f317acc/bin/
         * Example_of_a_multirelease_jar_files_contents.class
         */
    }
}
