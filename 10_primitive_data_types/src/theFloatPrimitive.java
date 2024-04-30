public class theFloatPrimitive {

    public static void main(String[] args) throws Exception {

        // Float adalah nomor floating point IEEE 754 32-bit presisi tunggal. Secara
        // default, desimal ditafsirkan sebagai ganda.
        // Untuk membuat float, cukup tambahkan f ke literal desimal.
        double angkaDouble = 0.6; // tanpa 'f' setelah angka = double
        float angkaFloat = 0.6f; // dengan 'f' setelah angka = float

        float floatKu = 92.8f; // ini adalah float
        float positiveFloat = 89.3f; // ini bisa positif
        float negativeFloat = -89.3f; // atau negatif
        float integerFloat = 43.0f; // ini bisa menjadi bilangan bulat
        float underZeroFloat = 0.0549f; // ini bisa menjadi nilai pecahan kurang dari 0

        // Float menangani lima operasi aritmatika umum: Addition, Subtraction,
        // Multiplication, division dan modulus.

        // Catatan: Berikut ini mungkin sedikit berbeda akibat kesalahan floating point.
        // Beberapa hasil telah dibulatkan untuk kejelasan dan tujuan keterbacaan (yaitu
        // hasil cetak dari contoh penambahan sebenarnya 34.600002).

        // addtion
        float result = 32.4f + -2.6f;

        // subtraction
        float result2 = 45.1f - 20.3f;

        // multiplication
        float result3 = 41.5f * 5.7f;

        // division
        float result4 = 40.3f / 4.7f;

        // modulus
        float result5 = 37.4f % 2.5f;

        // Karena cara penyimpanan angka floating point (yaitu dalam bentuk biner),
        // banyak angka tidak memiliki representasi yang tepat.

        float notExact = 3.1415926f;
        // System.out.println(notExact); // 3.1415925

        // Meskipun menggunakan float baik untuk sebagian besar aplikasi, baik float
        // maupun double tidak boleh digunakan untuk menyimpan representasi yang tepat
        // dari angka desimal (seperti jumlah uang), atau angka yang memerlukan presisi
        // lebih tinggi.
        // Sebaliknya, kelas BigDecimal harus digunakan.

        // Nilai default float adalah 0,0f.
        float defaultFloat; // defaultFloat == 0.0f

        // float tepat untuk kira-kira kesalahan 1 dalam 10 juta

        // Catatan:
        // Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN adalah nilai
        // float. NaN adalah singkatan dari hasil operasi yang tidak dapat ditentukan,
        // seperti membagi 2 nilai tak terhingga.
        // Selanjutnya 0f dan -0f berbeda, tapi == yield true:
        float f1 = 0f;
        float f2 = -0f;
        System.out.println(f1 == f2); // true
        System.out.println(1f / f1); // Infinity
        System.out.println(1f / f2);// -infinity
        System.out.println(Float.POSITIVE_INFINITY / Float.POSITIVE_INFINITY); // NaN

    }
}