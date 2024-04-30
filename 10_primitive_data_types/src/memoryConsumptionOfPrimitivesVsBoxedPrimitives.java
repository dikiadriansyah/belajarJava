public class memoryConsumptionOfPrimitivesVsBoxedPrimitives {
    public static void main(String[] args) {
        // Primitive | Boxed Type | Memory Size of primitive / boxed
        // boolean | Boolean | 1 byte / 16 bytes
        // byte | Byte | 1 byte / 16 bytes
        // short | Short | 2 bytes / 16 bytes
        // char | Char | 2 bytes / 16 bytes
        // int | Integer | 4 bytes / 16 bytes
        // long | Long | 8 bytes / 16 bytes
        // float | Float | 4 bytes / 16 bytes
        // double | Double | 8 bytes / 16 bytes

        // Object kotak selalu membutuhkan 8 byte untuk tipe dan manajemen memori, dan
        // karena ukuran objek selalu kelipatan 8, tipe kotak semuanya membutuhkan total
        // 16 byte. Selain itu, setiap penggunaan objek kotak memerlukan penyimpanan
        // referensi yang menyumbang 4 atau 8 byte lainnya, tergantung pada opsi JVM dan
        // JVM.

        // Dalam operasi intensif data, konsumsi memori dapat berdampak besar pada
        // performa. Konsumsi memori semakin meningkat saat menggunakan array: array
        // float[5] hanya akan membutuhkan 32 byte; sedangkan Float[5] menyimpan 5 nilai
        // non-null yang berbeda akan membutuhkan total 112 byte (pada 64 bit tanpa
        // pointer terkompresi, ini meningkat hingga 152 byte).

        // Boxed value caches
        // Overhead ruang dari tipe kotak dapat dikurangi sampai tingkat tertentu oleh
        // cache nilai kotak. Beberapa dari tipe kotak mengimplementasikan cache
        // instance. Misalnya, secara default, kelas Integer akan meng-cache instans
        // untuk merepresentasikan angka dalam kisaran -128 hingga +127. Namun, hal ini
        // tidak mengurangi biaya tambahan yang timbul dari tipuan memori tambahan

        // Jika Anda membuat instance dari tipe kotak baik dengan autoboxing atau dengan
        // memanggil metode static valueOf(primitive),
        // sistem runtime akan mencoba menggunakan nilai yang di-cache. Jika aplikasi
        // Anda menggunakan banyak nilai dalam rentang tersebut
        // di-cache, maka ini secara substansial dapat mengurangi hukuman memori
        // menggunakan tipe kotak. Tentu saja, jika Anda membuat
        // contoh nilai kotak "by hand", lebih baik menggunakan valueOf daripada
        // yang baru. (new operation selalu membuat new instance.) Namun, jika sebagian
        // besar nilai Anda tidak berada dalam rentang cache, akan lebih cepat untuk
        // memanggil yang baru dan menyimpan pencarian cache.
    }
}
