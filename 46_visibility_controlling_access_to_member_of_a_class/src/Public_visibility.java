public class Public_visibility {
    // Public Visibility / Visibilitas Publik

    // Terlihat oleh class, package, dan subclass
    // Mari kita lihat contoh dengan kelas Test.

    public static void main(String[] args) {
        // Sekarang mari kita coba membuat sebuah instance dari kelas tersebut. Dalam
        // contoh ini, kita dapat mengakses nomor karena bersifat public.
        Test t = new Test();
        // System.out.println(t.number); // 2

    }
}
