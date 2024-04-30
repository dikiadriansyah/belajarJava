import java.util.*;

public class Equals_method {
    // equals() method

    // TL;DR
    // == menguji kesetaraan referensi (apakah objeknya sama)
    // .equals() menguji kesetaraan nilai (apakah secara logis "sama")

    /*
     * equals() adalah metode yang digunakan untuk membandingkan dua objek
     * untuk kesetaraan. Implementasi default dari metode equals() di kelas
     * Object mengembalikan nilai true jika dan hanya jika kedua referensi menunjuk
     * ke instance yang sama. Oleh karena itu berperilaku sama dengan perbandingan
     * dengan ==.
     */

    // int field1, field2;
    // String field3;

    // public Equals_method(int i, int j, String k) {
    // field1 = i;
    // field2 = j;
    // field3 = k;
    // }

    /*
     * Meskipun foo1 dan foo2 dibuat dengan bidang yang sama, keduanya menunjuk ke
     * dua objek berbeda di memori.
     * Oleh karena itu, implementasi default equals() bernilai false.
     * 
     * Untuk membandingkan isi suatu objek demi kesetaraan, equals() harus
     * ditimpa.
     */

    int field1, field2;
    String field3;

    public Equals_method(int i, int j, String k) {
        field1 = i;
        field2 = j;
        field3 = k;
    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj) {
    // return true;
    // }
    // if (obj == null || getClass() != obj.getClass()) {
    // return false;
    // }
    // Equals_method f = (Equals_method) obj;
    // return field1 == f.field1 &&
    // field2 == f.field2 &&
    // (field3 == null ? f.field3 == null : field3.equals(f.field3));
    // }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + this.field1;
        hash = 31 * hash + this.field2;
        hash = 31 * hash + (field3 == null ? 0 : field3.hashCode());
        return hash;
    }

    /*
     * Di sini metode equals() yang diganti memutuskan bahwa objeknya sama jika
     * bidangnya sama.
     * 
     * Perhatikan bahwa metode hashCode() juga ditimpa. Kontrak untuk metode
     * tersebut menyatakan bahwa jika dua objek sama, nilai hashnya juga harus sama.
     * Itu sebabnya seseorang hampir selalu harus mengesampingkan
     * hashcode() dan equals() bersama-sama.
     * 
     * Berikan perhatian khusus pada tipe argumen dari metode sama dengan. Ini
     * adalah objek Obj, bukan objek Foo. Jika Anda memasukkan yang terakhir ke
     * dalam metode Anda, itu bukan merupakan penggantian dari metode yang sama.
     * 
     * Saat menulis kelas Anda sendiri, Anda harus menulis logika serupa saat
     * mengganti sama dengan() dan kode hash(). Kebanyakan IDE dapat secara otomatis
     * menghasilkan ini untuk Anda.
     * 
     * Contoh implementasi sama dengan() dapat ditemukan di kelas String, yang
     * merupakan bagian dari inti Java API.
     * Daripada membandingkan pointer, kelas String membandingkan konten String.
     * 
     * versi > java se 7
     * Java 1.7 memperkenalkan kelas java.util.Objects yang menyediakan metode
     * praktis, sama dengan, yang membandingkan dua referensi yang berpotensi null,
     * sehingga dapat digunakan untuk menyederhanakan implementasi metode equals.
     * 
     */

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj) {
    // return true;
    // }
    // if (obj == null || getClass() != obj.getClass()) {
    // return false;
    // }
    // Equals_method f = (Equals_method) obj;
    // return field1 == f.field1 && field2 == f.field2 && Objects.equals(field3,
    // f.field3);
    // }

    // Class Comparison(Perbandingan Kelas)
    /*
     * Karena metode yang sama dapat dijalankan terhadap objek apa pun, salah satu
     * hal pertama yang sering dilakukan metode ini (setelah memeriksa
     * untuk null) adalah untuk memeriksa apakah kelas objek yang dibandingkan cocok
     * dengan kelas saat ini.
     * 
     * @Override
     * public boolean equals(Object obj) {
     * // ...check for null
     * if (getClass() != obj.getClass()) {
     * return false;
     * }
     * // ...compare fields
     * }
     * 
     * 
     * Hal ini biasanya dilakukan seperti di atas dengan membandingkan objek kelas.
     * Namun, hal ini bisa gagal dalam beberapa kasus khusus yang mungkin tidak
     * terlihat jelas. Misalnya, beberapa kerangka kerja menghasilkan proxy kelas
     * yang dinamis dan proxy dinamis ini sebenarnya adalah kelas yang berbeda.
     * Berikut adalah contoh penggunaan JPA.
     * 
     * Foo detachedInstance = ...
     * Foo mergedInstance = entityManager.merge(detachedInstance);
     * if (mergedInstance.equals(detachedInstance)) {
     * //Can never get here if equality is tested with getClass()
     * //as mergedInstance is a proxy (subclass) of Foo
     * }
     * 
     * Salah satu mekanisme untuk mengatasi keterbatasan tersebut adalah dengan
     * membandingkan kelas menggunakan instanceof
     * 
     * @Override
     * public final boolean equals(Object obj) {
     * if (!(obj instanceof Equals_method)) {
     * return false;
     * }
     * // ...compare fields
     * }
     * 
     * Namun, ada beberapa kendala yang harus dihindari saat menggunakan instanceof.
     * Karena Foo berpotensi memilikinya
     * subkelas lain dan subkelas tersebut mungkin menimpa sama dengan() Anda bisa
     * mengalami kasus di mana Foo sama dengan FooSubkelas tetapi FooSubkelas tidak
     * sama dengan Foo.
     * 
     * Foo foo = new Foo(7);
     * FooSubclass fooSubclass = new FooSubclass(7, false);
     * foo.equals(fooSubclass) //true
     * fooSubclass.equals(foo) //false
     * 
     * Hal ini melanggar sifat simetri dan transitivitas sehingga merupakan
     * implementasi metode equal() yang tidak valid. Oleh karena itu, saat
     * menggunakan instanceof, praktik yang baik adalah menjadikan metode equals()
     * menjadi final (seperti pada contoh di atas). Hal ini akan memastikan
     * bahwa tidak ada subkelas yang menggantikan equals() dan melanggar asumsi
     * utama.
     * 
     */

    public static void main(String[] args) {
        Equals_method foo1 = new Equals_method(0, 0, "bar");
        Equals_method foo2 = new Equals_method(0, 0, "bar");
        System.out.println(foo1.equals(foo2)); // prints false
        // ---------------------

    }
}
