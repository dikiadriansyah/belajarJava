public class Interface_members {
    // Interface members / Anggota antarmuka

    /*
     * public interface MyInterface {
     * public void foo();
     * int bar();
     * public String TEXT = "Hello";
     * int ANSWER = 42;
     * public class X {
     * }
     * class Y {
     * }
     * }
     */

    /*
     * Anggota antarmuka selalu memiliki visibilitas publik, meskipun kata kunci
     * publik dihilangkan. Jadi keduanya foo(), bar(), TEXT,
     * ANSWER, X, dan Y mempunyai visibilitas publik. Namun, akses mungkin masih
     * dibatasi oleh antarmuka yang memuatnya - sejak itu
     * MyInterface memiliki visibilitas publik, anggotanya dapat diakses dari mana
     * saja, tetapi jika MyInterface punya
     * visibilitas paket, anggotanya hanya dapat diakses dari dalam paket yang sama.
     */

    public static void main(String[] args) {
        // Menggunakan konstanta dari antarmuka
        System.out.println("Text: " + MyInterface.TEXT);
        System.out.println("Answer: " + MyInterface.ANSWER);
        /*
         * output:
         * Text: Hello
         * Answer: 42
         */

        // Membuat objek dari kelas X dan Y
        MyInterface.X objX = new MyInterface.X();
        MyInterface.Y objY = new MyInterface.Y();

        // Memanggil metode dari kelas X dan Y
        objX.displayX();
        objY.displayY();
        /*
         * output:
         * Inside class X
         * Inside class Y
         */
    }
}
