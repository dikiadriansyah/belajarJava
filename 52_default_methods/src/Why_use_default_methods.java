public class Why_use_default_methods implements Swim {
    // Why use Default Methods? / Mengapa menggunakan Metode Default?

    /*
     * Jawaban sederhananya adalah memungkinkan Anda mengembangkan antarmuka yang
     * sudah ada tanpa merusak implementasi yang sudah ada.
     * 
     * Misalnya, Anda memiliki antarmuka Swim yang Anda terbitkan 20 tahun lalu.
     * 
     * public interface Swim {
     * void backStroke();
     * }
     */

    /*
     * Kami melakukan pekerjaan dengan baik, antarmuka kami sangat populer, ada
     * banyak implementasi di seluruh dunia dan Anda tidak memiliki kendali atas
     * kode sumbernya.
     */

    /*
     * public class FooSwimmer implements Swim {
     * public void backStroke() {
     * System.out.println("Do backstroke");
     * }
     * }
     */

    /*
     * Setelah 20 tahun, Anda memutuskan untuk menambahkan fungsionalitas baru ke
     * antarmuka, namun sepertinya antarmuka kami dibekukan karena akan merusak
     * implementasi yang sudah ada.
     * 
     * Untungnya Java 8 memperkenalkan fitur baru yang disebut metode Default.
     */

    // Kami sekarang dapat menambahkan metode baru ke interface Swim.
    /*
     * public interface Swim {
     * void backStroke();
     * default void sideStroke() {
     * System.out.println("Default sidestroke implementation. Can be overridden");
     * }
     * }
     */

    /*
     * Sekarang semua implementasi antarmuka kami yang ada masih dapat berfungsi.
     * Namun yang terpenting, mereka dapat menerapkan metode yang baru ditambahkan
     * dalam waktu mereka sendiri.
     * 
     * Salah satu alasan terbesar perubahan ini, dan salah satu kegunaan
     * terbesarnya, adalah pada framework Java Collections. Oracle tidak dapat
     * menambahkan metode foreach ke antarmuka Iterable yang ada tanpa merusak semua
     * kode yang mengimplementasikan Iterable. Dengan menambahkan metode default,
     * implementasi Iterable yang ada akan mewarisi implementasi default.
     */

    public static void main(String[] args) {
        Why_use_default_methods fooSwimmer = new Why_use_default_methods();
        fooSwimmer.backStroke(); // Memanggil metode backStroke dari FooSwimmer
        /*
         * output:
         * Do backstroke
         */

        fooSwimmer.sideStroke(); // Memanggil metode sideStroke dari antarmuka Swim
        /*
         * output:
         * Default sidestroke implementation. Can be overridden
         */
    }

    @Override
    public void backStroke() {
        System.out.println("Do backstroke");
    }

}
