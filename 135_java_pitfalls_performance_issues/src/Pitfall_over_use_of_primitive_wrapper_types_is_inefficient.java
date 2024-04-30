public class Pitfall_over_use_of_primitive_wrapper_types_is_inefficient {
    // Pitfall - Over-use of primitive wrapper types is inefficient/Kesalahan -
    // Penggunaan jenis pembungkus primitif secara berlebihan tidak efisien

    // Pertimbangkan dua potong kode ini:
    /*
     * int a = 1000;
     * int b = a + 1;
     */

    // dan
    /*
     * Integer a = 1000;
     * Integer b = a + 1;
     */

    /*
     * Pertanyaan: Versi mana yang lebih efisien?
     * Jawaban: Kedua versi tersebut terlihat hampir sama, namun versi pertama jauh
     * lebih efisien dibandingkan versi kedua.
     * 
     * Versi kedua menggunakan representasi angka yang menggunakan lebih banyak
     * ruang, dan mengandalkan auto-boxing dan auto-unboxing di belakang layar.
     * Sebenarnya versi kedua secara langsung setara dengan kode berikut:
     * 
     * Integer a = Integer.valueOf(1000); // box 1000
     * Integer b = Integer.valueOf(a.intValue() + 1); // unbox 1000, add 1, box 1001
     */

    /*
     * Dibandingkan dengan versi lain yang menggunakan int, jelas ada tiga
     * pemanggilan metode tambahan saat Integer digunakan.
     * Dalam kasus valueOf, masing-masing panggilan akan membuat dan
     * menginisialisasi objek new Integer. Semua pekerjaan tinju dan unboxing
     * ekstra ini kemungkinan besar akan membuat versi kedua lebih lambat dari versi
     * pertama.
     * 
     * Selain itu, versi kedua mengalokasikan objek di heap di setiap panggilan
     * valueOf. Meskipun pemanfaatan ruang bersifat spesifik platform, kemungkinan
     * besar berada di kisaran 16 byte untuk setiap objek Integer. Sebaliknya, versi
     * int tidak memerlukan ruang heap tambahan, dengan asumsi bahwa a dan b adalah
     * variabel lokal.
     * 
     * Alasan besar lainnya mengapa primitif lebih cepat daripada yang setara dalam
     * kotaknya adalah bagaimana tipe arraynya masing-masing diletakkan di memori.
     * 
     * Jika Anda mengambil int[] dan Integer[] sebagai contoh, dalam kasus int[]
     * nilai int diletakkan secara berdekatan di memori. Namun dalam kasus
     * Integer[], bukan nilai yang ditampilkan, melainkan referensi (pointer) ke
     * objek Integer, yang pada gilirannya berisi nilai int sebenarnya.
     * 
     * Selain sebagai tingkat tipuan ekstra, ini bisa menjadi kendala besar dalam
     * hal lokalitas cache saat melakukan iterasi pada nilai. Dalam kasus int[] CPU
     * dapat mengambil semua nilai dalam array, ke dalam cache sekaligus, karena
     * nilai-nilai tersebut bersebelahan dalam memori. Namun dalam kasus Integer[]
     * CPU berpotensi harus melakukan tindakan tambahan
     * pengambilan memori untuk setiap elemen, karena array hanya berisi referensi
     * ke nilai sebenarnya.
     * 
     * Singkatnya, menggunakan tipe wrapper primitif relatif mahal baik pada sumber
     * daya CPU maupun memori. Menggunakannya secara tidak perlu adalah cara yang
     * efisien.
     */

    public static void main(String[] args) throws Exception {
        // Integer a = 1000;
        // Integer b = a + 1;
        // System.out.println(b);// output: 1001
        // -------------------
        Integer a = Integer.valueOf(1000); // box 1000
        Integer b = Integer.valueOf(a.intValue() + 1); // unbox 1000, add 1, box 1001
        System.out.println(b); // output: 1001
    }
}
