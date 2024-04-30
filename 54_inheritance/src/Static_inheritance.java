public class Static_inheritance {
    // Static Inheritance / pewarisan static

    /*
     * Metode statis dapat diwariskan serupa dengan metode normal, namun tidak
     * seperti metode normal, tidak mungkin membuat metode "abstrak" untuk memaksa
     * penggantian metode statis. Menulis metode dengan tanda tangan yang sama
     * dengan metode statis di kelas super tampaknya merupakan bentuk penggantian,
     * namun sebenarnya ini hanya membuat fungsi baru
     * menyembunyikan yang lain.
     */

    /*
     * public class BaseClass {
     * 
     * public static int num = 5;
     * public static void sayHello() {
     * System.out.println("Hello");
     * }
     * public static void main(String[] args) {
     * BaseClass.sayHello();
     * System.out.println("BaseClass's num: " + BaseClass.num);
     * 
     * SubClass.sayHello();
     * //This will be different than the above statement's output, since it runs
     * //A different method
     * SubClass.sayHello(true);
     * 
     * StaticOverride.sayHello();
     * System.out.println("StaticOverride's num: " + StaticOverride.num);
     * }
     * }
     * public class SubClass extends BaseClass {
     * 
     * //Inherits the sayHello function, but does not override it
     * public static void sayHello(boolean test) {
     * System.out.println("Hey");
     * }
     * }
     * public static class StaticOverride extends BaseClass {
     * //Hides the num field from BaseClass
     * //You can even change the type, since this doesn't affect the signature
     * public static String num = "test";
     * 
     * //Cannot use @Override annotation, since this is static
     * //This overrides the sayHello method from BaseClass
     * public static void sayHello() {
     * System.out.println("Static says Hi");
     * }
     * }
     * 
     */

    // Menjalankan salah satu dari kelas-kelas ini menghasilkan output:
    /*
     * Hello
     * BaseClass's num: 5
     * Hello
     * Hey
     * Static says Hi
     * StaticOverride's num: test
     * 
     */

    /*
     * Perhatikan bahwa tidak seperti warisan normal, dalam metode warisan statis
     * tidak disembunyikan. Anda selalu dapat menghubungi pangkalan
     * metode sayHello dengan menggunakan BaseClass.sayHello(). Tetapi kelas
     * mewarisi metode statis jika tidak ada metode dengan tanda tangan yang sama
     * ditemukan di subkelas. Jika tanda tangan dua metode berbeda, kedua metode
     * dapat dijalankan dari subkelas, meskipun namanya sama.
     * 
     * Bidang statis menyembunyikan satu sama lain dengan cara yang sama
     */

    public static int num = 5;

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Static_inheritance.sayHello();
        System.out.println("BaseClass's num: " + Static_inheritance.num);

        SubClass.sayHello();
        // Ini akan berbeda dari keluaran pernyataan di atas, karena ini menjalankan
        // metode yang berbeda
        SubClass.sayHello(true);

        StaticOverride.sayHello();
        System.out.println("StaticOverride's num: " + StaticOverride.num);
        /*
         * output:
         * Hello
         * BaseClass's num: 5
         * Hello
         * Hey
         * Static says Hi
         * StaticOverride's num: test
         */

    }
}
