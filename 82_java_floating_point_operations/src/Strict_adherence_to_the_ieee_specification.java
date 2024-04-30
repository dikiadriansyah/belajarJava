public class Strict_adherence_to_the_ieee_specification {
    // Strict Adherence to the IEEE Specification/Kepatuhan Ketat terhadap
    // Spesifikasi IEEE

    /*
     * Secara default, operasi floating point pada float dan double tidak sepenuhnya
     * mematuhi aturan spesifikasi IEEE 754. Sebuah ekspresi diperbolehkan untuk
     * menggunakan ekstensi spesifik implementasi pada rentang nilai-nilai ini;
     * pada dasarnya memungkinkan mereka menjadi lebih akurat dari yang dibutuhkan.
     * 
     * strictfp menonaktifkan perilaku ini. Ini diterapkan pada kelas, antarmuka,
     * atau metode, dan berlaku untuk semua yang ada di dalamnya, seperti kelas,
     * antarmuka, metode, konstruktor, penginisialisasi variabel, dll. Dengan
     * strictfp, nilai perantara dari ekspresi floating-point harus berada dalam
     * kumpulan nilai float atau kumpulan nilai ganda. Hal ini menyebabkan
     * hasil ekspresi tersebut persis seperti yang diprediksi oleh spesifikasi IEEE
     * 754.
     * 
     * Semua ekspresi konstanta secara implisit ketat, meskipun ekspresi tersebut
     * tidak berada dalam cakupan strictfp.
     * 
     * 
     * Oleh karena itu, strictfp memiliki efek akhir yang terkadang membuat
     * perhitungan kasus sudut tertentu menjadi kurang akurat, dan juga dapat
     * membuat operasi floating point lebih lambat (karena CPU sekarang melakukan
     * lebih banyak pekerjaan untuk memastikan presisi ekstra asli tidak
     * mempengaruhi hasilnya). Namun hal itu juga menyebabkan hasilnya sama persis
     * di semua platform. Oleh karena itu, hal ini berguna dalam hal-hal seperti
     * program ilmiah, di mana reproduktifitas lebih penting daripada kecepatan.
     * 
     * public class StrictFP { // No strictfp -> default lenient
     * public strictfp float strict(float input) {
     * return input * input / 3.4f; // Strictly adheres to the spec.
     * // May be less accurate and may be slower.
     * }
     * public float lenient(float input) {
     * return input * input / 3.4f; // Can sometimes be more accurate and faster,
     * // but results may not be reproducable.
     * }
     * public static final strictfp class Ops { // strictfp affects all enclosed
     * entities
     * private StrictOps() {}
     * public static div(double dividend, double divisor) { // implicitly strictfp
     * return dividend / divisor;
     * }
     * }
     * }
     * 
     */

    public static void main(String[] args) {
        StrictFP strictFP = new StrictFP();
        System.out.println("Strict Result: " + strictFP.strict(5.0f));
        System.out.println("Lenient Result: " + strictFP.lenient(5.0f));
        /*
         * output:
         * Strict Result: 7.352941
         * Lenient Result: 7.352941
         */

    }
}
