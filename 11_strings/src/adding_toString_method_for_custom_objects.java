// Misalkan Anda telah mendefinisikan class Person berikut:
class Mahasiswa {
    String nama; // atribut nama
    int umur; // atribut umur

    // method constructor mahasiswa
    public Mahasiswa(int umur, String nama) {
        this.umur = umur;
        this.nama = nama;
    }

    // @Override
    // public String toString() {
    // return "Nama aku adalah " + this.nama + " dan umurku adalah " + this.umur;
    // }

}

public class adding_toString_method_for_custom_objects {

    public static void main(String[] args) {

        // jika anda membuat instance new mahasiswa object:
        Mahasiswa mahasiswa = new Mahasiswa(24, "Diki");

        // dan kemudian dalam kode Anda, Anda menggunakan pernyataan berikut untuk
        // mencetak objek:

        System.out.println(mahasiswa.toString());
        // output:
        // Mahasiswa@2a139a55

        // ini adalah hasil implementasi metode toString() yg didefinisikan dalam object
        // class, sebuah superclass dari Mahasiswa. Dokumentasi Object.toString()
        // menyatakan:

        // Metode toString untuk class Object mengembalikan sebuah string yang terdiri
        // dari nama kelas yang objek adalah sebuah instance, karakter tanda-at `@', dan
        // representasi hash heksadesimal yang tidak bertanda kode objek. Dengan kata
        // lain, metode ini mengembalikan string yang sama dengan nilai:
        // getClass().getName() + '@' +Integer.toHexString(hashCode())

        // jadi, untuk hasil yg bermakna, anda harus mengganti metode toString():
        Mahasiswa mahasiswa2 = new Mahasiswa(23, "Dhiki");
        System.out.println(mahasiswa2);
        // output:
        // Nama aku adalah Dhiki dan umurku adalah 23

        // Faktanya, println() secara implisit memanggil metode toString pada objek
    }
}
