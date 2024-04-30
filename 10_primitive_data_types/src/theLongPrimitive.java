import java.util.Objects;

public class theLongPrimitive {
    public static void main(String[] args) {
        // Secara default, long adalah 64-bit signed integer (di Java 8, bisa signed
        // atau unsigned). Signed, dapat menyimpan nilai minimum -263, dan
        // nilai maksimum 263 - 1, dan unsigned dapat menyimpan nilai minimum 0 dan
        // nilai maksimum 264 - 1

        long bilanganTipeLong = -222222222;
        long tipeLongKu = 283243254;
        long tipeLongLain = 1444444;

        // sebuah "L" harus ditambahkan ke akhir angka, karena secara default,
        // angka diasumsikan sebagai tipe int. menambahkan "L" membuatnya panjang
        // karena 549755813888 (2 ^ 39) lebih besar dari nilai maksimum int(2^31 - 1),
        // "L" harus ditambahkan

        long bigNumber = 24242424242333434L;
        long penjumlahanTipeLong = tipeLongKu + tipeLongLain;
        // System.out.println(penjumlahanTipeLong); // 284687698

        long penguranganTipeLong = tipeLongKu - tipeLongLain;
        // System.out.println(penguranganTipeLong); // 281798810

        // Nilai Maksimum dan Minimum dengan long dapat ditemukan:
        long high = Long.MAX_VALUE;
        long low = Long.MIN_VALUE;
        // System.out.println(high); // 9223372036854775807
        // System.out.println(low); // -9223372036854775808

        // Nilai default panjang adalah 0L
        // long defaultLong; // defaultLong == 0L

        // Catatan: huruf "L" yang ditambahkan di akhir literal panjang tidak peka huruf
        // besar/kecil, namun sebaiknya gunakan huruf kapital sebagaimana adanya
        // lebih mudah dibedakan dari angka satu:
        // 2L == 2l; // true

        // Peringatan: Java meng-cache instance objek Integer dari rentang -128 hingga
        // 127. Alasannya dijelaskan di sini:
        // https://blogs.oracle.com/darcy/entry/boxing_and_caches_integer_valueof

        // Hasil berikut dapat ditemukan:
        Long val1 = 127L;
        Long val2 = 127L;
        // System.out.println(val1 == val2); // true

        Long val3 = 128L;
        Long val4 = 128L;
        // System.out.println(val3 == val4); // false

        // Untuk membandingkan 2 nilai Panjang Objek dengan benar, gunakan kode berikut
        // (Dari Java 1.7 dan seterusnya):
        System.out.println(Objects.equals(val3, val4)); // true

        // Membandingkan panjang primitif dengan panjang Objek tidak akan menghasilkan
        // negatif palsu seperti membandingkan 2 objek dengan == melakukan.

    }
}
