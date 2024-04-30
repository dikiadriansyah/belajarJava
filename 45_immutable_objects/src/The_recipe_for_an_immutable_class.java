public final class The_recipe_for_an_immutable_class {
    // The recipe for an immutable class / Resep untuk kelas yang tidak dapat diubah

    /*
     * Objek yang tidak dapat diubah adalah objek yang keadaannya tidak dapat
     * diubah. Kelas yang tidak dapat diubah adalah kelas yang instance-nya tidak
     * dapat diubah berdasarkan desain dan implementasi. Kelas Java yang paling
     * sering disajikan sebagai contoh kekekalan adalah java.lang.String.
     */

    // Berikut ini adalah contoh stereotip:
    /*
     * public final class Person {
     * private final String name;
     * private final String ssn; // (SSN == social security number)
     * public Person(String name, String ssn) {
     * this.name = name;
     * this.ssn = ssn;
     * }
     * public String getName() {
     * return name;
     * }
     * 
     * public String getSSN() {
     * return ssn;
     * }
     * }
     */

    /*
     * Variasinya adalah dengan mendeklarasikan konstruktor sebagai pribadi dan
     * sebagai gantinya menyediakan metode pabrik statis publik.
     * 
     * Resep standar untuk kelas abadi adalah sebagai berikut:
     * 1. Semua properti harus disetel dalam konstruktor atau metode pabrik
     * 2. Seharusnya tidak ada setter.
     * 3. Jika perlu menyertakan penyetel karena alasan kompatibilitas antarmuka,
     * mereka tidak boleh melakukan apa pun atau memberikan pengecualian.
     * 4. Semua properti harus dinyatakan sebagai private dan final.
     * 5. Untuk semua properti yang merupakan referensi ke tipe yang bisa berubah:
     * 6. Kelas tersebut harus dideklarasikan sebagai final untuk mencegah seseorang
     * membuat subkelas yang dapat diubah dari kelas yang tidak dapat diubah.
     * 
     */

    // Beberapa hal lain yang perlu diperhatikan:
    /*
     * 1. Kekekalan tidak mencegah objek menjadi tidak dapat dibatalkan; misalnya
     * null dapat ditugaskan ke variabel String
     * 2. Jika properti kelas yang tidak dapat diubah dideklarasikan sebagai final,
     * instance pada dasarnya aman untuk thread. Ini membuat
     * kelas yang tidak dapat diubah merupakan blok bangunan yang baik untuk
     * mengimplementasikan aplikasi multi-thread.
     */

    private final String name;
    private final String ssn; // (SSN == social security number)

    public The_recipe_for_an_immutable_class(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSSN() {
        return ssn;
    }

    public static void main(String[] args) {
        // Contoh penggunaan kelas Person
        The_recipe_for_an_immutable_class person = new The_recipe_for_an_immutable_class("John Doe", "123-45-6789");

        // Mengambil nilai nama dan SSN dari objek Person
        String name = person.getName();
        String ssn = person.getSSN();

        // Menampilkan informasi
        System.out.println("Name: " + name); // Name: John Doe
        System.out.println("SSN: " + ssn); // SSN: 123-45-6789
    }
}
