public class Overriding_in_inheritance {
    // Overriding in Inheritance / Mengesampingkan Warisan

    /*
     * Overriding di Inheritance digunakan ketika Anda menggunakan metode yang sudah
     * ditentukan dari kelas super di subkelas, namun dengan cara yang berbeda dari
     * cara metode awalnya dirancang di kelas super. Overriding memungkinkan
     * pengguna untuk menggunakan kembali kode dengan menggunakan materi yang ada
     * dan memodifikasinya agar lebih sesuai dengan kebutuhan pengguna.
     * 
     * Contoh berikut menunjukkan bagaimana ClassB mengesampingkan fungsionalitas
     * ClassA dengan mengubah apa yang dikirim melalui metode pencetakan:
     */

    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassA b = new ClassB();

        a.printing(); // A
        b.printing(); // B
    }
}
