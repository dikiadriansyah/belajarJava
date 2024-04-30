public class Floatingpoint_literals {
    public static void main(String args[]) {
        // Literal floating point memberikan nilai yang dapat digunakan di mana Anda
        // membutuhkan instance float atau double. Ada tiga jenis floating point
        // literal.

        // Simple decimal forms
        // Scaled decimal forms
        // Hexadecimal forms

        // (Aturan sintaks JLS menggabungkan dua bentuk desimal menjadi satu bentuk.
        // Kami memperlakukannya secara terpisah untuk kemudahan penjelasan.)

        // Ada tipe literal yang berbeda untuk float dan double literal, yang
        // diekspresikan menggunakan suffixes. Berbagai bentuk menggunakan huruf
        // untuk mengungkapkan hal yang berbeda. Huruf-huruf ini tidak peka huruf
        // besar-kecil.

        // Simple decimal forms
        // Bentuk paling sederhana dari floating point literal terdiri dari satu atau
        // lebih angka desimal dan titik desimal (.) dan akhiran opsional (f, F, d atau
        // D). optional suffix memungkinkan Anda untuk menentukan bahwa literal adalah
        // float (f atau F) atau double (d atau D) nilai. Standarnya (ketika tidak ada
        // akhiran yang ditentukan) adalah ganda.

        // misalnya
        // 0.0 // this denotes zero
        // .0 // this also denotes zero
        // 0. // this also denotes zero
        // 3.14159 // this denotes Pi, accurate to (approximately!) 5 decimal places.
        // 1.0F // a `float` literal
        // 1.0D // a `double` literal. (`double` is the default if no suffix is given)

        // Faktanya, angka desimal yang diikuti dengan akhiran juga merupakan literal
        // floating point.

        // 1F // means the same thing as 1.0F

        // Arti literal desimal adalah angka floating point IEEE yang paling dekat
        // dengan presisi tak terbatas
        // bilangan Real matematis yang dilambangkan dengan bentuk floating point
        // desimal. Nilai konseptual ini diubah menjadi IEEE
        // representasi floating point biner menggunakan putaran ke terdekat. (Semantik
        // konversi desimal yang tepat ditentukan dalam javadocs untuk
        // Double.valueOf(String) dan Float.valueOf(String), dengan mengingat bahwa ada
        // perbedaan dalam sintaks angka.)

        // Scaled decimal forms
        // Bentuk desimal berskala terdiri dari desimal sederhana dengan bagian eksponen
        // yang diperkenalkan oleh E atau e, dan diikuti oleh bilangan bulat bertanda.
        // Bagian eksponen adalah kependekan dari mengalikan bentuk desimal dengan
        // pangkat sepuluh, seperti yang ditunjukkan pada contoh di bawah ini. Ada juga
        // sufiks opsional untuk membedakan float dan double literal. Berikut beberapa
        // contohnya:
        // 1.0E1 // this means 1.0 x 10^1 ... or 10.0 (double)
        // 1E-1D // this means 1.0 x 10^(-1) ... or 0.1 (double)
        // 1.0e10f // this means 1.0 x 10^(10) ... or 10000000000.0 (float)

        // Ukuran literal dibatasi oleh representasi (float atau double). Merupakan
        // kesalahan kompilasi jika faktor skala menghasilkan nilai yang terlalu besar
        // atau terlalu kecil.

        // Hexadecimal forms
        // Dimulai dengan Java 6, dimungkinkan untuk mengekspresikan literal floating
        // point dalam heksadesimal. Bentuk heksadesimal memiliki sintaks analog dengan
        // bentuk desimal sederhana dan berskala dengan perbedaan berikut:
        // 1. Every hexadecimal floating point literal starts with a zero (0) and then
        // an x or X. / Setiap literal floating point heksadesimal dimulai dengan nol
        // (0) dan kemudian x atau X
        // 2. The digits of the number (but not the exponent part!) also include the
        // hexadecimal digits a through f and their uppercase equivalents. / Digit angka
        // (tetapi bukan bagian eksponen!) juga menyertakan digit heksadesimal a hingga
        // f dan setara huruf besar mereka.
        // 3. The exponent is mandatory, and is introduced by the letter p (or P)
        // instead of an e or E. The exponent represents a scaling factor that is a
        // power of 2 instead of a power of 10. / Eksponen adalah wajib, dan
        // diperkenalkan dengan huruf p (atau P) bukan e atau E. Eksponen mewakili
        // faktor penskalaan yang merupakan pangkat 2, bukan pangkat 10.

        // Berikut beberapa contohnya:
        // 0x0.0p0f // this is zero expressed in hexadecimal form (`float`)
        // 0xff.0p19 // this is 255.0 x 2^19 (`double`)

        // Saran: karena bentuk titik-mengambang heksadesimal tidak dikenal oleh
        // sebagian besar pemrogram Java, disarankan untuk menggunakannya dengan hemat.

        // Underscores
        // Dimulai dengan Java 7, garis bawah diizinkan di dalam string digit dalam
        // ketiga bentuk literal floating point. Ini juga berlaku untuk bagian
        // "exponen". Lihat Menggunakan garis bawah untuk meningkatkan keterbacaan

        // Special cases
        // Ini adalah kesalahan kompilasi jika literal floating point menunjukkan angka
        // yang terlalu besar atau terlalu kecil untuk direpresentasikan dalam
        // representasi yang dipilih; yaitu jika angka akan meluap ke +INF atau -INF,
        // atau mengalir ke bawah menjadi 0,0. Namun, legal untuk literal untuk mewakili
        // angka denormalisasi bukan nol.

        // Sintaks literal floating point tidak menyediakan representasi literal untuk
        // nilai khusus IEEE 754 seperti INF dan nilai NaN. Jika Anda perlu
        // mengekspresikannya dalam kode sumber, cara yang disarankan adalah menggunakan
        // konstanta yang ditentukan oleh java.lang.Float dan java.lang.Double; misalnya
        // Float.NaN,
        // Float.NEGATIVE_INFINITY dan
        // Float.POSITIVE_INFINITY.
    }
}
