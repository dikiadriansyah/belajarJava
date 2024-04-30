import javax.swing.*;
import java.awt.Container;

public class Making_an_executable_jar_from_the_command_line {
    // Making an executable JAR from the command line/Membuat JAR yang dapat
    // dieksekusi dari baris perintah

    /*
     * Untuk membuat toples, Anda memerlukan satu atau lebih file kelas. Ini harus
     * memiliki metode utama jika ingin dijalankan dengan klik dua kali.
     * Untuk contoh ini, kita akan menggunakan:
     * 
     * import javax.swing.*;
     * import java.awt.Container;
     * public class HelloWorld {
     * public static void main(String[] args) {
     * JFrame f = new JFrame("Hello, World");
     * JLabel label = new JLabel("Hello, World");
     * Container cont = f.getContentPane();
     * cont.add(label);
     * f.setSize(400,100);
     * f.setVisible(true);
     * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * }
     * }
     */

    // Ini telah diberi nama HelloWorld.java
    /*
     * Selanjutnya, kami ingin mengkompilasi program ini.
     * 
     * Anda dapat menggunakan program apa pun yang Anda ingin melakukan ini. Untuk
     * menjalankan dari baris perintah, lihat dokumentasi kompilasi
     * dan menjalankan program java pertama Anda.
     * 
     * Setelah Anda memiliki HelloWorld.class, buatlah folder baru dan beri nama apa
     * pun yang Anda inginkan.
     * Buat file lain bernama manifest.txt dan tempel ke dalamnya
     * 
     * Main-Class: HelloWorld
     * Class-Path: HelloWorld.jar
     * 
     */

    /*
     * Taruh di folder yang sama dengan HelloWorld.class
     * Gunakan baris perintah untuk menjadikan direktori Anda saat ini (cd
     * C:\Your\Folder\Path\Here di windows) sebagai folder Anda.
     * Gunakan Terminal dan ubah direktori ke direktori (cd
     * /Users/user/Documents/Java/jarfolder di Mac) Anda
     * map.
     * 
     * Setelah selesai, ketik jar -cvfm HelloWorld.jar manifest.txt HelloWorld.class
     * dan tekan enter. Ini
     * membuat file jar (dalam folder dengan manifes Anda dan HelloWorld.class)
     * menggunakan file .class yang ditentukan dan diberi nama
     * HaloDunia.jar. Lihat bagian Sintaks untuk informasi tentang opsi (seperti -m
     * dan -v).
     * Setelah langkah-langkah ini, buka direktori Anda dengan file manifes dan Anda
     * akan menemukan HelloWorld.jar
     * Mengkliknya akan menampilkan Hello, World dalam kotak teks
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        JFrame f = new JFrame("Hello, World");
        JLabel label = new JLabel("Hello, World");
        Container cont = f.getContentPane();
        cont.add(label);
        f.setSize(400, 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
