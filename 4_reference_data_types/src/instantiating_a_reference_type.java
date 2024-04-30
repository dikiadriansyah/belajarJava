public class instantiating_a_reference_type {
    public static void main(String[] args) {
        // Instantiating a reference type / Instansiasi jenis referensi

        Object obj = new Object(); // Note the 'new' keyword

        // Di mana:
        // Object adalah tipe referensi
        // obj adalah variabel untuk menyimpan referensi baru
        // Object() adalah panggilan ke konstruktor Object

        // Apa yang terjadi:
        // ruang dalam memori dialokasikan untuk object.
        // constructor Object() dipanggil untuk menginisialisasi ruang memori tersebut.
        // alamat memori disimpan dalam obj, sehingga mereferensikan object yang baru
        // dibuat.

        // Ini berbeda dari primitif:
        // int i = 10;
        // Di mana nilai sebenarnya 10 disimpan di i
    }
}
