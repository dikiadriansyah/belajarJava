import java.util.*;

public class hashcode_method {
    // hashCode() method

    /*
     * Ketika kelas Java mengganti metode sama dengan, kelas tersebut juga harus
     * mengganti metode kode hash. Sebagaimana didefinisikan dalam kontrak metode:
     * 
     * 1. Setiap kali dipanggil pada objek yang sama lebih dari sekali selama
     * eksekusi
     * aplikasi Java, metode hashCode harus secara konsisten mengembalikan bilangan
     * bulat yang sama, asalkan tidak ada informasi yang digunakan dalam
     * perbandingan yang sama pada objek yang diubah. Bilangan bulat ini tidak harus
     * tetap konsisten dari satu eksekusi aplikasi ke eksekusi lain dari aplikasi
     * yang sama.
     * 
     * 2. Jika dua objek sama menurut metode sama dengan(Objek), maka pemanggilan
     * metode kode hash pada masing-masing dua objek harus menghasilkan hasil
     * bilangan bulat yang sama.
     * 
     * 3. Tidak diperlukan jika dua objek tidak sama menurut metode sama
     * dengan(Objek),
     * maka pemanggilan metode kode hash pada masing-masing dua objek harus
     * menghasilkan hasil bilangan bulat yang berbeda.
     * Namun, pemrogram harus menyadari bahwa menghasilkan hasil bilangan bulat yang
     * berbeda untuk objek yang tidak sama dapat meningkatkan kinerja tabel hash.
     */

    /*
     * Kode hash digunakan dalam implementasi hash seperti HashMap, HashTable, dan
     * HashSet. Hasil dari Kode hash fungsi menentukan keranjang di mana suatu objek
     * akan ditempatkan.
     * Implementasi hash ini lebih efisien jika asalkan implementasi kode hash
     * bagus. Properti penting dari implementasi kode hash yang baik adalah
     * distribusi nilai kode hash seragam. Dengan kata lain,
     * kecil kemungkinannya terjadi banyak kejadian akan disimpan dalam ember yang
     * sama.
     */

    // Algoritme untuk menghitung nilai kode hash mungkin serupa dengan yang
    // berikut:

    private int field1, field2;
    private String field3;

    public hashcode_method(int field1, int field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj) {
    // return true;
    // }
    // if (obj == null || getClass() != obj.getClass()) {
    // return false;
    // }
    // hashcode_method f = (hashcode_method) obj;
    // return field1 == f.field1 &&
    // field2 == f.field2 &&
    // (field3 == null ? f.field3 == null : field3.equals(f.field3));
    // }

    // @Override
    // public int hashCode() {
    // int hash = 1;
    // hash = 31 * hash + field1;
    // hash = 31 * hash + field2;
    // hash = 31 * hash + (field3 == null ? 0 : field3.hashCode());
    // return hash;
    // }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Creating objects of class hashcode_method
        hashcode_method foo1 = new hashcode_method(1, 2, "Hello");
        hashcode_method foo2 = new hashcode_method(1, 2, "Hello");
        hashcode_method foo3 = new hashcode_method(3, 4, "World");

        // Testing the equals method
        System.out.println("foo1 equals foo2: " + foo1.equals(foo2)); // true
        /*
         * output:
         * foo1 equals foo2: true
         */

        System.out.println("foo1 equals foo3: " + foo1.equals(foo3)); // false
        /*
         * output:
         * foo1 equals foo3: false
         */

        // Testing the hashCode method
        System.out.println("HashCode foo1: " + foo1.hashCode()); // HashCode foo1: 69640464
        System.out.println("HashCode foo2: " + foo2.hashCode()); // HashCode foo2: 69640464
        System.out.println("HashCode foo3: " + foo3.hashCode()); // HashCode foo3: 83798928

        // Using Arrays.hashCode() as a short cut
        // versi > java se 1.2
        /*
         * Di Java 1.2 dan yang lebih baru, alih-alih mengembangkan algoritme untuk
         * menghitung kode hash, algoritme dapat dibuat menggunakan
         * java.util.Arrays#hashCode dengan menyediakan array Object atau primitif yang
         * berisi nilai bidang:
         */

    }

    // @Override
    // public int hashCode() {
    // return Arrays.hashCode(new Object[] { field1, field2, field3 });
    // }

    // versi > java se 7
    /*
     * Java 1.7 memperkenalkan kelas java.util.Objects yang menyediakan metode
     * praktis, hash(Object...
     * objek), yang menghitung kode hash berdasarkan nilai objek yang diberikan
     * padanya. Metode ini bekerja dengan cara yang sama
     * java.util.Array#hashCode.
     */

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }

    /*
     * Catatan: pendekatan ini tidak efisien, dan menghasilkan objek sampah setiap
     * kali metode hashCode() khusus Anda dipanggil:
     * 1. Object[] sementara dibuat. (Dalam versi Objects.hash(), array dibuat oleh
     * mekanisme "varargs".)
     * 
     * 2. Jika salah satu bidang adalah tipe primitif, bidang tersebut harus
     * dikotakkan
     * dan itu dapat membuat lebih banyak objek sementara.
     * 
     * 3. Array harus diisi.
     * 
     * 4. Array harus diiterasi dengan metode Arrays.hashCode atau Objects.hash.
     * 
     * 5. Panggilan ke Object.hashCode() yang harus dilakukan oleh Arrays.hashCode
     * atau
     * Objects.hash (mungkin) tidak dapat dilakukan
     * sebaris.
     */

    // Internal caching of hash codes(Caching internal kode hash)
    /*
     * Karena penghitungan kode hash suatu objek bisa mahal, maka menarik untuk
     * menyimpan nilai kode hash dalam cache
     * dalam objek saat pertama kali dihitung. Misalnya
     */
    // public final class ImmutableArray {
    // private int[] array;
    // private volatile int hash = 0;

    // public ImmutableArray(int[] initial) {
    // array = initial.clone();
    // }

    // // Other methods
    // @Override
    // public boolean equals(Object obj) {
    // // ...
    // }

    // @Override
    // public int hashCode() {
    // int h = hash;
    // if (h == 0) {
    // h = Arrays.hashCode(array);
    // hash = h;
    // }
    // return h;
    // }
    // }

    /*
     * Pendekatan ini mengorbankan biaya (berulang kali) penghitungan kode hash
     * dengan overhead bidang tambahan untuk menyimpan kode hash dalam cache. Apakah
     * ini membuahkan hasil sebagai pengoptimalan kinerja akan bergantung pada
     * seberapa sering objek tertentu di-hash (dicari) dan faktor lainnya.
     * 
     * Anda juga akan melihat bahwa jika kode hash sebenarnya dari ImmutableArray
     * ternyata nol (satu peluang dalam 232), cache tidak efektif.
     * 
     * Terakhir, pendekatan ini jauh lebih sulit untuk diterapkan dengan benar jika
     * objek yang kita hashing dapat diubah. Namun,
     * ada kekhawatiran yang lebih besar jika kode hash berubah; lihat kontrak di
     * atas.
     */

}
