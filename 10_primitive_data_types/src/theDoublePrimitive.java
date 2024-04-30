public class theDoublePrimitive {
    public static void main(String[] args) {
        // Double adalah double-precision 64 bit IEEE 754 floating point number
        double bilanganNegatif = -7612.37; // bilangan desimal
        double bilanganPositif = 974.21;
        double bilanganLain = 658.7;

        double penjumlahanBilangan = bilanganPositif + bilanganLain;
        // System.out.println(penjumlahanBilangan); // 1632.91

        double penguranganBilangan = bilanganPositif - bilanganLain;
        // System.out.println(penguranganBilangan); // 315.51

        double bilanganNotasiSains = 1.2e-3;
        // System.out.println(bilanganNotasiSains); // 0.0012

        // Karena cara penyimpanan angka floating point, banyak angka tidak memiliki
        // representasi yang tepat

        double notExact = 1.32 - 0.42;
        // System.out.println(notExact); // 0.9000001

        // Meskipun menggunakan double baik untuk sebagian besar aplikasi, baik float
        // maupun double tidak boleh digunakan untuk menyimpan angka yang tepat
        // seperti mata uang. Sebaliknya, kelas BigDecimal harus digunakan

        // Nilai default dari double adalah 0,0d
        // public double defaultDouble; // defaultDouble == 0.0

        // Catatan:
        // Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN adalah nilai
        // double. NaN adalah singkatan dari hasil operasi yang tidak dapat ditentukan,
        // seperti membagi 2 nilai infinite. Selanjutnya 0d dan -0d adalah
        // berbeda, tetapi == yield true:

        double bil1 = 0d;
        double bil2 = -0;
        // System.out.println(bil1 == bil2); // true
        // System.out.println(1bil / bil1); // infinity
        // System.out.println(1bil / bil2); // -infinity
        System.out.println(Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY); // NaN

    }
}
