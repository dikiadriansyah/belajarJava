import java.math.BigInteger;

public class initialization {
    // Kelas BigInteger digunakan untuk operasi matematika yang melibatkan bilangan
    // bulat besar dengan besaran yang terlalu besar tipe data primitif. Misalnya
    // 100-faktorial adalah 158 digit - jauh lebih besar dari yang bisa diwakili
    // oleh panjang. Bilangan Bulat Besar menyediakan analog ke semua operator
    // integer primitif Java, dan semua metode yang relevan dari java.lang.Math
    // serta beberapa operasi lainnya.

    public static void main(String[] args) throws Exception {
        // Kelas java.math.BigInteger menyediakan operasi analog ke semua operator
        // integer primitif Java dan untuk semua metode yang relevan dari
        // java.lang.Math. Karena paket java.math tidak tersedia secara otomatis, Anda
        // dapat melakukannya harus mengimpor java.math.BigInteger sebelum Anda dapat
        // menggunakan nama kelas yang sederhana.

        // Untuk mengonversi nilai long atau int ke penggunaan BigInteger
        // long lv = Long.MAX_VALUE;
        // BigInteger valueFromLong = BigInteger.valueOf(lv);
        // System.out.println(lv); // 9223372036854775807

        // atau for integers

        // int value = Integer.MIN_VALUE; // -2147483648
        // BigInteger valueFromInt = BigInteger.valueOf(value);
        // System.out.println(valueFromInt); // 2147483648

        // yang akan memperlebar bilangan bulat intValue menjadi panjang, menggunakan
        // ekstensi bit tanda untuk nilai negatif, sehingga nilai negatif akan tetap
        // negatif.

        // Untuk mengonversi String numerik ke penggunaan BigInteger:
        // String ds = "-1";
        // BigInteger valueFromDecimalString = new BigInteger(ds);
        // System.out.println(valueFromDecimalString); // -1

        // Konstruktor berikut digunakan untuk menerjemahkan representasi String dari
        // BigInteger dalam radix yang ditentukan menjadi BigInteger.
        // String bs = "10";
        // int br = 2;
        // BigInteger valueFromBinaryString = new BigInteger(bs, br);
        // System.out.println(valueFromBinaryString); // 2

        // Java juga mendukung konversi byte langsung ke instance BigInteger. Saat ini
        // hanya enkode bigendian yang ditandatangani dan tidak ditandatangani yang
        // dapat digunakan:
        byte[] b = new byte[] { (byte) 0x80 };
        BigInteger valueFromBytes = new BigInteger(b);
        // System.out.println(valueFromBytes); // 128

        // Ini akan menghasilkan instance BigInteger dengan nilai -128 karena bit
        // pertama ditafsirkan sebagai bit tanda.
        byte[] unsignedBytes = new byte[] { (byte) 0x80 };
        int s = 1; // positif
        BigInteger valueFromUsignedBytes = new BigInteger(s, unsignedBytes);
        // System.out.println(valueFromUsignedBytes); // 128

        // Ini akan menghasilkan instance BigInteger dengan nilai 128 karena byte
        // ditafsirkan sebagai angka yang tidak ditandatangani, dan
        // tanda secara eksplisit diatur ke 1, angka positif.

        // Ada konstanta yang telah ditentukan sebelumnya untuk nilai umum:
        // BigInteger.ZERO — value of "0".
        // BigInteger.ONE — value of "1".
        // BigInteger.TEN — value of "10".

        // Ada juga BigInteger.TWO (nilai "2"), tetapi Anda tidak dapat menggunakannya
        // dalam kode karena bersifat pribadi.
    }
}
