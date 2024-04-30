import java.util.*;
// import common.collect.Lists;

public class Sorting_a_generic_list implements Comparable<Sorting_a_generic_list> {
    // Sorting a generic list

    // public final Long id;
    // public final String username;

    // public Sorting_a_generic_list(Long id, String username) {
    // this.id = id;
    // this.username = username;
    // }

    // @Override
    // public String toString() {
    // return String.format("%s:%d", username, id);
    // }

    /*
     * Kelas Collections menawarkan dua metode statis standar untuk mengurutkan
     * daftar(list):
     * 1. sort(List<T> list) applicable to lists where T extends Comparable<? super
     * T>, and
     * 2. sort(List<T> list, Comparator<? super T> c) applicable to lists of any
     * type.
     */

    /*
     * Menerapkan yang pertama memerlukan perubahan kelas elemen daftar yang
     * diurutkan, yang tidak selalu memungkinkan. Ini mungkin juga tidak diinginkan
     * karena meskipun menyediakan penyortiran default, perintah penyortiran lain
     * mungkin diperlukan dalam keadaan yang berbeda, atau penyortiran hanyalah
     * tugas yang dilakukan satu kali saja.
     */

    /*
     * Misalkan kita mempunyai tugas untuk mengurutkan objek yang merupakan turunan
     * dari kelas berikut:
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Sorting_a_generic_list box1 = new Sorting_a_generic_list(1L, "Dhiki");

        // System.out.println(box1); // Dhiki: 1

        /*
         * Untuk menggunakan Collections.sort(List<Sorting_a_generic_list> list) kita
         * perlu memodifikasi
         * kelas Sorting_a_generic_list untuk mengimplementasikan antarmuka
         * Comparable(interface
         * comparable). Misalnya
         */

        // -----------------------------------
        // List<Sorting_a_generic_list> users = Lists.newArrayList(
        // new Sorting_a_generic_list(33L, "A"),
        // new Sorting_a_generic_list(25L, "B"),
        // new Sorting_a_generic_list(28L, ""));

        // Collections.sort(users);
        // System.out.print(users);
        // [B:25, C:28, A:33]

        /*
         * Namun, misalkan kita ingin mengurutkan objek Sorting_a_generic_list
         * berdasarkan nama, bukan
         * berdasarkan id. Alternatifnya, misalkan kita belum bisa mengubah kelas agar
         * mengimplementasikan Comparable.
         * 
         * Di sinilah metode sortir dengan argumen Comparator berguna:
         */
        // Collections.sort(users, new Comparator<Sorting_a_generic_list>() {
        // @Override
        /* Order two 'User' objects based on their names. */
        // public int compare(Sorting_a_generic_list left, Sorting_a_generic_list right)
        // {
        // return left.username.compareTo(right.username);
        // }
        // });
        // System.out.print(users);
        // [A:33, B:25, C:28]

        // Version ≥ Java SE 8
        /*
         * Di Java 8 Anda bisa menggunakan lambda alih-alih kelas anonim. Yang terakhir
         * direduksi menjadi satu kalimat:
         */
        // Collections.sort(users, (l, r) -> l.username.compareTo(r.username));

        // Selanjutnya, Java 8 menambahkan metode pengurutan default pada antarmuka
        // Daftar, yang lebih menyederhanakan penyortiran.
        // users.sort((l, r) -> l.username.compareTo(r.username))

    }

    public final Long id;
    public final String username;

    public Sorting_a_generic_list(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("%s:%d", username, id);
    }

    @Override
    /** The natural ordering for 'User' objects is by the 'id' field. */
    public int compareTo(Sorting_a_generic_list o) {
        return id.compareTo(o.id);
    }

    /*
     * (Selain itu: banyak kelas Java standar seperti String, Long, Integer
     * mengimplementasikan Comparable interface. Hal ini membuat
     * daftar elemen-elemen yang dapat diurutkan secara default, dan menyederhanakan
     * implementasi compare atau compareTo di kelas lain.)
     * 
     * Dengan modifikasi di atas, kita dapat dengan mudah mengurutkan daftar objek
     * Pengguna berdasarkan urutan alami kelasnya. (Dalam hal ini, kami telah
     * mendefinisikannya sebagai pengurutan berdasarkan nilai id). Misalnya:
     */

}
