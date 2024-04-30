public class Converting_other_datatypes_to_string {
    // Converting other datatypes to String / Mengubah tipe data lain menjadi String

    // Anda bisa mendapatkan nilai tipe data primitif lainnya sebagai String
    // menggunakan salah satu metode valueOf kelas String.

    /*
     * contoh:
     * int i = 42;
     * String string = String.valueOf(i);
     * //string now equals "42”.
     */

    // Metode ini juga kelebihan beban untuk tipe data lain, seperti float, double,
    // boolean, dan bahkan Object

    /*
     * Anda juga bisa mendapatkan Objek lain (contoh kelas apa pun) sebagai String
     * dengan memanggil .toString di atasnya. Agar ini memberikan keluaran yang
     * berguna, kelas harus mengganti toString(). Sebagian besar kelas perpustakaan
     * Java standar melakukannya, seperti Date dan lain-lain.
     */

    // contoh:
    /*
     * Foo foo = new Foo(); //Any class.
     * String stringifiedFoo = foo.toString().
     * 
     */

    /*
     * Di sini stringifiedFoo berisi representasi foo sebagai sebuah String.
     * 
     * Anda juga dapat mengonversi tipe angka apa pun ke String dengan notasi pendek
     * seperti di bawah ini.
     * 
     * int i = 10;
     * String str = i + "";
     */

    // Atau cara sederhananya saja
    // String str = 10 + "";

    public static void main(String[] args) {
        // int i = 42;
        // String string = String.valueOf(i);
        // System.out.println("Hasil dari " + i + " adalah " + string);
        // output: Hasil dari 42 adalah 42
        // ----------------------
        // Foo foo = new Foo(); // Any class.
        // String stringifiedFoo = foo.toString();
        // System.out.println("Hasil dari " + foo + " adalah " + stringifiedFoo);
        // output: Hasil dari Foo@2401f4c3 adalah Foo@2401f4c3
        // ----------------------
        // int i = 10;
        // String str = i + "";
        // System.out.println("Hasil dari " + i + " adalah " + str);
        // output: Hasil dari 10 adalah 10

        // ------------------------
        String str = 10 + "";
        System.out.println("Hasil " + str + " poin");
        // output: Hasil 10 poin

    }
}
