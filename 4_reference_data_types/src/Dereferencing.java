public class Dereferencing {

    // 4.1 Dereferencing / Dereferensi
    // deferensi terjadi dengan . operator

    public String toString() {
        return "Perkenalkan Saya Diki ";
    }

    public static void main(String[] args) {

        Dereferencing obj = new Dereferencing();
        String text = obj.toString(); // 'obj' is dereferenced

        System.out.println("Hello, World! " + text);

        // Deferencing mengikuti alamat memori yang disimpan dalam referensi, ke tempat
        // di memori tempat objek sebenarnya tinggal. ketika objek ditemukan, metode
        // yang diminta dipanggil (toString dalam kasus ini).
        // ketika referensi memiliki nilai null, dereferencing menghasilkan
        // NullPointerException.

        // Object obj = null;
        // obj.toString(); // Throws a NullpointerException when this statement is
        // executed

        // null menunjukkan tidak adanya nilai, yaitu mengikuti alamat memori tidak
        // membawa hasil. jadi tidak ada objek dimana metode yang diminta dapat
        // dipanggil

        // hasil:
        // Hello, World! Perkenalkan Saya Diki

        // penjelasan:
        // awalnya membuat file dereferencing.java
        // selanjutnya membuat isian nya yaitu public class Deferencing{},
        // selanjutnya dalam kelas terdapat metode yg ditulis public String toString()
        // {...}
        // selanjutnya dalam main method berisi Dereferencing obj yang memiliki nilai
        // keyword new Dereferencing(); buat lagi variabel bernama text yg berisi
        // obj.toString();
        // selanjutnya tampilkan menggunakan system.out.println("");
        // sehingga hasil Hello, World! Perkenalkan Saya Diki
    }
}
