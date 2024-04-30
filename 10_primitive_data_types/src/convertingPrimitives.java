public class convertingPrimitives {
    public static void main(String[] args) {
        // di java, kita dapat mengonversi antara nilai integer dan nilai
        // floating-point. juga, karena setiap karakter sesuai dengan nomor
        // dalam pengkodean Unicode, tipe char dapat dikonversi to dan from tipe integer
        // dan floating-point. boolean adalah satu-satunya tipe data primitif yg tidak
        // dapat dikonversi to atau from tipe data primitif lainnya.

        // Ada dua jenis konversi: konversi pelebaran(widening conversion) dan konversi
        // penyempitan(narrowing conversion).

        // Konversi pelebaran adalah ketika nilai dari satu tipe data dikonversi ke
        // nilai tipe data lain yang menempati lebih banyak bit daripada yang
        // sebelumnya. Tidak ada masalah kehilangan data dalam kasus ini.

        // Sejalan dengan itu, Konversi penyempitan adalah ketika nilai dari satu tipe
        // data diubah menjadi nilai tipe data lain yang menempati lebih sedikit bit
        // daripada yang sebelumnya. Kehilangan data dapat terjadi dalam kasus ini.

        // Java melakukan konversi pelebaran secara otomatis. Tetapi jika Anda ingin
        // melakukan konversi penyempitan (jika Anda yakin bahwa tidak akan terjadi
        // kehilangan data), maka Anda dapat memaksa Java untuk melakukan konversi
        // menggunakan konstruksi bahasa yang dikenal sebagai pemeran.

        // widening conversion:
        int a = 1;
        double d = a;
        System.out.println(d); // valid conversion to double, no cast needed (widening)
        // 1.0

        // narrowing conversion:
        double e = 18.96;
        // int b = e; // invalid conversion to int, will throw a compile-time error
        int b = (int) e; // valid conversion to int, but result is truncated (gets rounded down)
        // This is type-casting
        System.out.println(b); // now b = 18

    }
}
