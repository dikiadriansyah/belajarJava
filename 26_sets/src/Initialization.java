public class Initialization {
    // Initialization
    /*
     * Set adalah Koleksi yang tidak boleh berisi elemen duplikat. Ini memodelkan
     * abstraksi himpunan matematika.
     * 
     * Set memiliki implementasinya di berbagai kelas seperti HashSet, TreeSet,
     * LinkedHashSet.
     * 
     * Contoh:
     * 
     * 
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        /*
         * HashSet:
         * Set<T> set = new HashSet<T>();
         * 
         * Di sini T dapat berupa String, Integer, atau objek lainnya. HashSet
         * memungkinkan pencarian cepat O(1) tetapi tidak mengurutkan data yang
         * ditambahkan ke dalamnya dan kehilangan urutan penyisipan item.
         * 
         * TreeSet:
         * Ini menyimpan data dengan cara yang diurutkan dengan mengorbankan beberapa
         * kecepatan untuk operasi dasar yang membutuhkan O(lg(n)). Itu tidak
         * mempertahankan urutan penyisipan item.
         * TreeSet<T> sortedSet = new TreeSet<T>();
         * 
         * LinkedHashSet:
         * Ini adalah implementasi daftar tertaut dari HashSet Once yang dapat
         * mengulangi item sesuai urutan penambahannya. Penyortiran tidak disediakan
         * untuk isinya. O(1) operasi dasar disediakan, namun ada biaya yang lebih
         * tinggi daripada HashSet dalam memelihara daftar tertaut pendukung.
         * LinkedHashSet<T> linkedhashset = new LinkedHashSet<T>();
         */
    }
}
