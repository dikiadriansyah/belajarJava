public class Method_overriding {
    // Method Overriding/Penggantian Metode

    // Metode overriding adalah kemampuan subtipe untuk mendefinisikan ulang
    // (mengesampingkan) perilaku supertipenya.

    /*
     * Di Java, ini diterjemahkan menjadi subkelas yang menggantikan metode yang
     * ditentukan di kelas super. Di Java, semua variabel non-primitif sebenarnya
     * adalah references, yang mirip dengan penunjuk ke lokasi objek sebenarnya di
     * memori. references hanya memiliki satu tipe, yaitu tipe yang digunakan untuk
     * mendeklarasikannya. Namun, mereka dapat menunjuk pada suatu objek
     * baik tipe yang dideklarasikan atau subtipe apa pun.
     */

    // Ketika suatu metode dipanggil pada reference, metode yang sesuai dengan objek
    // sebenarnya yang ditunjuk akan dipanggil.

    /*
     * class SuperType {
     * public void sayHello(){
     * System.out.println("Hello from SuperType");
     * }
     * public void sayBye(){
     * System.out.println("Bye from SuperType");
     * }
     * }
     * class SubType extends SuperType {
     * // override the superclass method
     * public void sayHello(){
     * System.out.println("Hello from SubType");
     * }
     * }
     * class Test {
     * public static void main(String... args){
     * SuperType superType = new SuperType();
     * superType.sayHello(); // -> Hello from SuperType
     * // make the reference point to an object of the subclass
     * superType = new SubType();
     * // behaviour is governed by the object, not by the reference
     * superType.sayHello(); // -> Hello from SubType
     * // non-overridden method is simply inherited
     * superType.sayBye(); // -> Bye from SuperType
     * }
     * }
     */

    // Aturan yang perlu diingat
    /*
     * Untuk mengganti metode di subkelas, metode utama (yaitu metode yang ada di
     * subkelas) HARUS MEMILIKI:
     * 1. nama yang sama
     * 2. tipe pengembalian yang sama dalam kasus primitif (subkelas diperbolehkan
     * untuk kelas, ini juga dikenal sebagai tipe pengembalian kovarian).
     * 3. jenis dan urutan parameter yang sama
     * 4. ia hanya dapat memunculkan pengecualian-pengecualian yang dideklarasikan
     * dalam klausa throws dari metode superkelas atau
     * pengecualian yang merupakan subkelas dari pengecualian yang dideklarasikan.
     * Ia juga dapat memilih untuk TIDAK memberikan pengecualian apa pun.
     * Nama tipe parameter tidak menjadi masalah. Misalnya, void methodX(int i) sama
     * dengan void metodeX(int k)
     * 5. Kami tidak dapat Mengganti metode final atau Statis. Satu-satunya hal yang
     * dapat kita lakukan hanyalah mengubah metode tubuh.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------
        SuperType superType = new SuperType();
        superType.sayHello(); // -> output: Hello from SuperType

        // make the reference point to an object of the subclass
        // superType = new SubType();
        // behaviour is governed by the object, not by the reference
        superType.sayHello(); // -> output: Hello from SubType

        // non-overridden method is simply inherited
        superType.sayBye(); // -> output: Bye from SuperType
    }
}
