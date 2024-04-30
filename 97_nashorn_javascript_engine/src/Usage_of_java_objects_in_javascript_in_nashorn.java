public class Usage_of_java_objects_in_javascript_in_nashorn {
    // Usage of Java objects in JavaScript in Nashorn/Penggunaan objek Java dalam
    // JavaScript di Nashorn

    /*
     * Objek Java dapat diteruskan ke mesin Nashorn untuk diproses dalam kode Java.
     * Pada saat yang sama, ada beberapa konstruksi khusus JavaScript (dan Nashorn),
     * dan tidak selalu jelas cara kerjanya dengan objek Java.
     * 
     * Di bawah ini terdapat tabel yang menjelaskan perilaku objek Java asli di
     * dalam konstruksi JavaScript.
     * 
     * Konstruksi yang diuji:
     * 1. Ekspresi dalam klausa if. Dalam ekspresi JS di klausa if tidak harus
     * boolean tidak seperti Java. Itu dievaluasi sebagai
     * false untuk apa yang disebut nilai falsy (null, tidak terdefinisi, 0, string
     * kosong, dll)
     * 2. untuk setiap pernyataan Nashorn memiliki jenis perulangan khusus - untuk
     * setiap pernyataan - yang dapat melakukan iterasi pada objek JS dan Java yang
     * berbeda.
     * 3. Mendapatkan ukuran objek. Di JS, objek memiliki properti panjang, yang
     * mengembalikan ukuran array atau string
     * 
     */

    // hasil:
    /*
     * Type | If | for each | .length
     * Java null | false | No iterations Exception
     * Java empty string | false | No iterations 0
     * Java string | true | Iterates over string characters Length of the string
     * Java Integer/Long | value != 0 | No iterations undefined
     * Java ArrayList | true | Iterates over elements Length of the list
     * Java HashMap | true | Iterates over values null
     * Java HashSet | true | Iterates over items undefined
     * 
     */

    // rekomendasi:
    /*
     * 1. Dianjurkan untuk menggunakan if (some_string) untuk memeriksa apakah suatu
     * string tidak null dan tidak kosong
     * 2. for each dapat digunakan dengan aman untuk mengulangi koleksi
     * mana pun, dan tidak menimbulkan pengecualian jika koleksi tersebut tidak
     * dapat diubah, nol, atau tidak terdefinisi
     * 3. Sebelum mendapatkan panjang suatu objek, objek tersebut harus diperiksa
     * apakah ada yang null atau tidak terdefinisi (hal yang sama berlaku untuk
     * setiap upaya memanggil metode atau mendapatkan properti objek Java)
     */

    public static void main(String[] args) throws Exception {

    }
}