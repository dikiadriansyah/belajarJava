public class Comparing_floating_point_values {
    // Comparing floating point values/Membandingkan nilai floating point

    /*
     * Anda harus berhati-hati saat membandingkan nilai floating-point (float atau
     * double) menggunakan operator relasional: ==, !=, <
     * dan seterusnya. Operator ini memberikan hasil sesuai dengan representasi
     * biner dari nilai floating point. Misalnya:
     * 
     * public class CompareTest {
     * public static void main(String[] args) {
     * double oneThird = 1.0 / 3.0;
     * double one = oneThird * 3;
     * System.out.println(one == 1.0); // prints "false"
     * }
     * }
     */

    /*
     * Perhitungan oneThird menimbulkan kesalahan pembulatan kecil, dan saat kita
     * mengalikan oneThird dengan 3, kita mendapatkan hasil yang sedikit berbeda
     * dengan 1,0.
     * Masalah representasi yang tidak tepat ini menjadi lebih parah ketika kita
     * mencoba menggabungkan double dan float dalam perhitungan.
     * Misalnya:
     * 
     * public class CompareTest2 {
     * public static void main(String[] args) {
     * float floatVal = 0.1f;
     * double doubleVal = 0.1;
     * double doubleValCopy = floatVal;
     * System.out.println(floatVal); // 0.1
     * System.out.println(doubleVal); // 0.1
     * System.out.println(doubleValCopy); // 0.10000000149011612
     * 
     * System.out.println(floatVal == doubleVal); // false
     * System.out.println(doubleVal == doubleValCopy); // false
     * }
     * }
     * 
     */

    /*
     * Representasi floating point yang digunakan di Java untuk tipe float dan
     * double memiliki jumlah digit presisi yang terbatas. Untuk tipe float,
     * presisinya adalah 23 digit biner atau sekitar 8 digit desimal. Untuk tipe
     * double adalah 52 bit atau sekitar 15 angka desimal. Selain itu, beberapa
     * operasi aritmatika akan menimbulkan kesalahan pembulatan.
     * Oleh karena itu, ketika sebuah program membandingkan nilai floating point,
     * praktik standarnya adalah menentukan delta yang dapat diterima untuk
     * perbandingan tersebut. Jika selisih kedua bilangan tersebut lebih kecil dari
     * delta, maka keduanya dianggap sama. Misalnya
     * 
     * if (Math.abs(v1 - v2) < delta)
     */

    // Delta compare example:
    /*
     * public class DeltaCompareExample {
     * private static boolean deltaCompare(double v1, double v2, double delta) {
     * // return true iff the difference between v1 and v2 is less than delta
     * return Math.abs(v1 - v2) < delta;
     * }
     * 
     * public static void main(String[] args) {
     * double[] doubles = {1.0, 1.0001, 1.0000001, 1.000000001, 1.0000000000001};
     * double[] deltas = {0.01, 0.00001, 0.0000001, 0.0000000001, 0};
     * // loop through all of deltas initialized above
     * for (int j = 0; j < deltas.length; j++) {
     * double delta = deltas[j];
     * System.out.println("delta: " + delta);
     * // loop through all of the doubles initialized above
     * for (int i = 0; i < doubles.length - 1; i++) {
     * double d1 = doubles[i];
     * double d2 = doubles[i + 1];
     * boolean result = deltaCompare(d1, d2, delta);
     * System.out.println("" + d1 + " == " + d2 + " ? " + result);
     * 
     * }
     * System.out.println();
     * }
     * }
     * }
     * 
     */

    // hasil:
    /*
     * delta: 0.01
     * 1.0 == 1.0001 ? true
     * 1.0001 == 1.0000001 ? true
     * 1.0000001 == 1.000000001 ? true
     * 1.000000001 == 1.0000000000001 ? true
     * delta: 1.0E-5
     * 1.0 == 1.0001 ? false
     * 1.0001 == 1.0000001 ? false
     * 1.0000001 == 1.000000001 ? true
     * 1.000000001 == 1.0000000000001 ? true
     * delta: 1.0E-7
     * 1.0 == 1.0001 ? false
     * 1.0001 == 1.0000001 ? false
     * 1.0000001 == 1.000000001 ? true
     * 1.000000001 == 1.0000000000001 ? true
     * delta: 1.0E-10
     * 1.0 == 1.0001 ? false
     * 1.0001 == 1.0000001 ? false
     * 1.0000001 == 1.000000001 ? false
     * 1.000000001 == 1.0000000000001 ? false
     * delta: 0.0
     * 1.0 == 1.0001 ? false
     * 1.0001 == 1.0000001 ? false
     * 1.0000001 == 1.000000001 ? false
     * 1.000000001 == 1.0000000000001 ? false
     */

    /*
     * Juga untuk perbandingan metode perbandingan statis tipe primitif double dan
     * float dari tipe boxing yang sesuai dapat digunakan. Misalnya:
     * 
     * double a = 1.0;
     * double b = 1.0001;
     * System.out.println(Double.compare(a, b));//-1
     * System.out.println(Double.compare(b, a));//1
     * 
     */

    /*
     * Terakhir, menentukan delta mana yang paling tepat untuk perbandingan bisa
     * jadi rumit. Pendekatan yang umum digunakan
     * adalah memilih nilai delta yang menurut intuisi kita benar. Namun, jika Anda
     * mengetahui skala dan akurasi (true).
     * nilai masukan, dan perhitungan yang dilakukan, dimungkinkan untuk
     * menghasilkan batasan yang masuk akal secara matematis
     * pada keakuratan hasil, dan karenanya untuk delta. (Ada cabang formal
     * Matematika yang dikenal sebagai
     * Analisis Numerik yang dulu diajarkan kepada ilmuwan komputasi yang
     * mempelajari analisis semacam ini.)
     */

    private static boolean deltaCompare(double v1, double v2, double delta) {
        // return true iff the difference between v1 and v2 is less than delta
        return Math.abs(v1 - v2) < delta;
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        // double oneThird = 1.0 / 3.0;
        // double one = oneThird * 3;
        // System.out.println(one == 1.0); // prints "true"
        // -----------------
        // float floatVal = 0.1f;
        // double doubleVal = 0.1;
        // double doubleValCopy = floatVal;

        // System.out.println(floatVal); // 0.1
        // System.out.println(doubleVal); // 0.1
        // System.out.println(doubleValCopy); // 0.10000000149011612
        // System.out.println(floatVal == doubleVal); // false
        // System.out.println(doubleVal == doubleValCopy); // false
        // -------------------------------
        double[] doubles = { 1.0, 1.0001, 1.0000001, 1.000000001, 1.0000000000001 };
        double[] deltas = { 0.01, 0.00001, 0.0000001, 0.0000000001, 0 };
        // loop through all of deltas initialized above
        for (int j = 0; j < deltas.length; j++) {
            double delta = deltas[j];
            System.out.println("delta: " + delta);
            // loop through all of the doubles initialized above
            for (int i = 0; i < doubles.length - 1; i++) {
                double d1 = doubles[i];
                double d2 = doubles[i + 1];
                boolean result = deltaCompare(d1, d2, delta);
                System.out.println("" + d1 + " == " + d2 + " ? " + result);

            }
            System.out.println();
        }

        /*
         * delta: 0.01
         * 1.0 == 1.0001 ? true
         * 1.0001 == 1.0000001 ? true
         * 1.0000001 == 1.000000001 ? true
         * 1.000000001 == 1.0000000000001 ? true
         * 
         * delta: 1.0E-5
         * 1.0 == 1.0001 ? false
         * 1.0001 == 1.0000001 ? false
         * 1.0000001 == 1.000000001 ? true
         * 1.000000001 == 1.0000000000001 ? true
         * 
         * delta: 1.0E-7
         * 1.0 == 1.0001 ? false
         * 1.0001 == 1.0000001 ? false
         * 1.0000001 == 1.000000001 ? true
         * 1.000000001 == 1.0000000000001 ? true
         * 
         * delta: 1.0E-10
         * 1.0 == 1.0001 ? false
         * 1.0001 == 1.0000001 ? false
         * 1.0000001 == 1.000000001 ? false
         * 1.000000001 == 1.0000000000001 ? false
         * 
         * delta: 0.0
         * 1.0 == 1.0001 ? false
         * 1.0001 == 1.0000001 ? false
         * 1.0000001 == 1.000000001 ? false
         * 1.000000001 == 1.0000000000001 ? false
         */

    }
}
