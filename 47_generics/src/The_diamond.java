import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class The_diamond {
    // The Diamond / Berlian

    /*
     * Java 7 memperkenalkan Diamond1 untuk menghapus beberapa boiler-plate di
     * sekitar instantiasi kelas generik. Dengan Java 7+ Anda dapat menulis:
     * List<String> list = new LinkedList<>();
     * 
     * Di mana Anda harus menulis di versi sebelumnya, ini:
     * List<String> list = new LinkedList<String>();
     * 
     */

    // Salah satu batasannya adalah untuk Kelas Anonim, di mana Anda masih harus
    // menyediakan parameter tipe dalam pembuatan instance:
    /*
     * // This will compile:
     * Comparator<String> caseInsensitiveComparator = new Comparator<String>() {
     * 
     * @Override
     * public int compare(String s1, String s2) {
     * return s1.compareToIgnoreCase(s2);
     * }
     * };
     * // But this will not:
     * Comparator<String> caseInsensitiveComparator = new Comparator<>() {
     * 
     * @Override
     * public int compare(String s1, String s2) {
     * return s1.compareToIgnoreCase(s2);
     * }
     * };
     * 
     */

    // Version > Java SE 8
    /*
     * Meskipun penggunaan berlian dengan Kelas Dalam Anonim tidak didukung di Java
     * 7 dan 8, itu akan disertakan sebagai fitur baru di Java 9.
     */
    // Catatan kaki:
    /*
     * 1 - Beberapa orang menyebut penggunaan <> sebagai "operator berlian". Ini
     * tidak benar. Berlian tidak berperilaku seperti
     * operator, dan tidak dijelaskan atau terdaftar di mana pun di JLS atau
     * Tutorial Java (resmi) sebagai operator. Memang, <>
     * bahkan bukan token Java yang berbeda. Melainkan itu adalah token < diikuti
     * oleh > token, dan itu sah (meskipun gayanya buruk) untuk dimiliki
     * spasi atau komentar di antara keduanya. JLS dan Tutorial secara konsisten
     * menyebut <> sebagai "berlian", dan
     * oleh karena itu itulah istilah yang tepat untuk itu.
     */

    public static void main(String[] args) {
        // Membuat daftar string
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("banana");
        stringList.add("Orange");
        stringList.add("grape");

        Comparator<String> caseInsensitiveComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        };

        // Menggunakan comparator untuk mengurutkan daftar string
        Collections.sort(stringList, caseInsensitiveComparator);

        // Menampilkan hasil pengurutan
        System.out.println("String setelah diurutkan secara case-insensitive:");
        for (String str : stringList) {
            System.out.println(str);
        }

        /*
         * output:
         * String setelah diurutkan secara case-insensitive:
         * Apple
         * banana
         * grape
         * Orange
         */

    }
}
