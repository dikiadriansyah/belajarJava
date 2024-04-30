import java.util.HashMap;
import java.util.Map;

public class Using_generics_to_autocast {
    // Using Generics to auto-cast / Menggunakan Generik untuk melakukan transmisi
    // otomatis

    // Dengan obat generik, dimungkinkan untuk mengembalikan apa pun yang diharapkan
    // oleh penelepon:

    /*
     * private Map<String, Object> data;
     * public <T> T get(String key) {
     * return (T) data.get(key);
     * }
     */

    /*
     * Metode ini akan dikompilasi dengan peringatan. Kode ini sebenarnya lebih aman
     * daripada yang terlihat karena runtime Java akan melakukan cast ketika Anda
     * menggunakannya:
     * Bar bar = foo.get("bar");
     */

    // Kurang aman bila Anda menggunakan tipe generik:
    // List<Bar> bars = foo.get("bars");

    /*
     * Di sini, pemeran akan berfungsi ketika tipe yang dikembalikan adalah Daftar
     * apa pun (yaitu mengembalikan List<String> tidak akan memicu
     * ClassCastException; pada akhirnya Anda akan mendapatkannya saat mengeluarkan
     * elemen dari list).
     * 
     * Untuk mengatasi masalah ini, Anda dapat membuat API yang menggunakan kunci
     * yang diketik:
     * public final static Key<List<Bar>> BARS = new Key<>("BARS");
     */

    // bersama dengan metode put() ini:
    // public <T> T put(Key<T> key, T value);

    /*
     * Dengan pendekatan ini, Anda tidak dapat memasukkan tipe yang salah ke dalam
     * peta, sehingga hasilnya akan selalu benar (kecuali jika Anda secara tidak
     * sengaja membuat dua kunci dengan nama yang sama tetapi tipenya berbeda).
     */

    private Map<String, Object> data;

    public <T> T get(String key) {
        return (T) data.get(key);
    }

    public static void main(String[] args) {
        Using_generics_to_autocast box1 = new Using_generics_to_autocast();

        // Inisialisasi data, misalnya dengan sebuah objek Bar
        Map<String, Object> initData = new HashMap<>();
        Bar barObj = new Bar();
        initData.put("bar", barObj);

        // Set data ke objek box1
        box1.setData(initData);

        // Menggunakan method get untuk mendapatkan objek Bar
        Bar bar = box1.get("bar");

        // Sekarang, Anda dapat menggunakan objek Bar
        System.out.println(bar);
        /*
         * output:
         * Bar{name='Default Bar'}
         */
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
