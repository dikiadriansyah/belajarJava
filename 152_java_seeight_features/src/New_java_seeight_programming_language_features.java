public class New_java_seeight_programming_language_features {
    // New Java SE 8 programming language features/Fitur bahasa pemrograman Java SE
    // 8 baru

    /*
     * 1. Ekspresi Lambda, fitur bahasa baru, telah diperkenalkan dalam rilis ini.
     * Mereka memungkinkan Anda memperlakukan fungsionalitas sebagai argumen metode,
     * atau kode sebagai data. Ekspresi Lambda memungkinkan Anda mengekspresikan
     * instans antarmuka metode tunggal (disebut sebagai antarmuka fungsional)
     * dengan lebih ringkas.
     * 1. Referensi metode memberikan ekspresi lambda yang mudah dibaca untuk metode
     * yang sudah memiliki nama.
     * 2. Metode default memungkinkan fungsionalitas baru ditambahkan ke antarmuka
     * perpustakaan dan memastikan kompatibilitas biner dengan kode yang ditulis
     * untuk versi lama antarmuka tersebut.
     * 3. API Baru dan Disempurnakan yang Memanfaatkan Ekspresi dan Aliran Lambda di
     * Java SE 8 menjelaskan kelas baru dan disempurnakan yang memanfaatkan ekspresi
     * dan aliran lambda.
     * 
     * Inferensi Tipe yang Ditingkatkan - Kompiler Java memanfaatkan pengetikan
     * target untuk menyimpulkan parameter tipe pemanggilan metode generik. Tipe
     * target dari sebuah ekspresi adalah tipe data yang diharapkan oleh kompiler
     * Java bergantung pada tempat ekspresi tersebut muncul. Misalnya, Anda bisa
     * menggunakan tipe target pernyataan penugasan untuk inferensi tipe di Java SE
     * 7. Namun, di Java SE 8, Anda bisa menggunakan tipe target untuk inferensi
     * tipe dalam lebih banyak konteks.
     * 1. Target Typing dalam Lambda Expressions
     * 2. Type Inference
     * 
     * Anotasi Berulang memberikan kemampuan untuk menerapkan jenis anotasi yang
     * sama lebih dari sekali pada deklarasi atau penggunaan jenis yang sama.
     * 
     * Anotasi Tipe memberikan kemampuan untuk menerapkan anotasi di mana pun tipe
     * digunakan, tidak hanya pada deklarasi. Digunakan dengan sistem tipe
     * pluggable, fitur ini memungkinkan peningkatan pemeriksaan tipe kode Anda.
     * 
     * Refleksi parameter metode - Anda dapat memperoleh nama parameter formal
     * metode apa pun atau
     * konstruktor dengan metode java.lang.reflect.Executable.getParameters. (Kelas
     * Metode dan Konstruktor memperluas kelas Executable dan karenanya mewarisi
     * metode Executable.getParameters)
     * Namun, file .class tidak menyimpan nama parameter formal secara default.
     * Untuk menyimpan nama parameter formal dalam file .class tertentu, dan dengan
     * demikian mengaktifkan API Refleksi untuk mengambil nama parameter formal,
     * kompilasi file sumber dengan opsi -parameters dari kompiler javac.
     * 
     * Date-time-api - Menambahkan api waktu baru di java.time. Jika menggunakan
     * ini, Anda tidak perlu menentukan zona waktu.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
