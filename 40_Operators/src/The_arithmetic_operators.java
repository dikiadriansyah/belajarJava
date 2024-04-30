public class The_arithmetic_operators {
    // The Arithmetic Operators (+, -, *, /, %) / Operator Aritmatika (+, -, *, /,
    // %)

    /*
     * Bahasa Java menyediakan 7 operator yang melakukan aritmatika pada nilai
     * integer dan floating point.
     * 1. Ada dua + operator:
     * a. Operator penjumlahan biner menambahkan satu angka ke angka lainnya. (Ada
     * juga operator biner + yang melakukan penggabungan string. Hal ini dijelaskan
     * dalam contoh terpisah.)
     * b. Operator unary plus tidak melakukan apa pun selain memicu promosi numerik
     * (lihat di bawah)
     * 2. Ada dua - operator:
     * a. Operator pengurangan biner mengurangkan satu angka dari angka lainnya.
     * b. Operator minus unary setara dengan mengurangkan operannya dari nol.
     * 3. Operator perkalian biner (*) mengalikan satu bilangan dengan bilangan
     * lainnya.
     * 4. Operator pembagian biner (/) membagi suatu bilangan dengan bilangan
     * lainnya.
     * 5. Operator biner sisa1 (%) menghitung sisanya ketika suatu bilangan dibagi
     * dengan bilangan lain
     */

    /*
     * 1. Operator ini sering salah disebut sebagai operator "modulus". "remainder"
     * adalah istilah yang digunakan oleh JLS.
     * "Modulus" dan "remainder" bukanlah hal yang sama.
     */

    // Operand and result types, and numeric promotion(Operan dan tipe hasil, dan
    // promosi numerik)

    /*
     * Operator memerlukan operan numerik dan menghasilkan hasil numerik. Tipe
     * operan dapat berupa tipe numerik primitif apa pun (yaitu byte, short, char,
     * int, long, float atau double) atau tipe pembungkus numerik apa pun yang
     * ditentukan di java.lang;
     * yaitu (Byte, character, Short, Integer, Long, Float atau Double.
     */

    // Tipe hasil ditentukan berdasarkan jenis-jenis operand atau operannya, sebagai
    // berikut:
    /*
     * 1. Jika salah satu operannya adalah double atau Double, maka tipe hasilnya
     * adalah double.
     * 2. Sebaliknya, jika salah satu operannya adalah float atau Float, maka tipe
     * hasilnya adalah float.
     * 3. Sebaliknya, jika salah satu operannya long atau long, maka tipe
     * hasilnya akan long
     * 4. Jika tidak, tipe hasilnya adalah int. Ini mencakup operan byte, short dan
     * char serta `int.
     */

    // Jenis hasil operasi menentukan bagaimana operasi aritmatika dilakukan, dan
    // bagaimana operan ditangani
    /*
     * 1. Jika tipe hasilnya Double, operan dipromosikan menjadi Double, dan operasi
     * dilakukan menggunakan 64-bit (biner presisi Double) Aritmatika floating point
     * IEE 754.
     * 2. Jika tipe hasilnya adalah float, operan dipromosikan menjadi float, dan
     * operasi dilakukan menggunakan 32-bit
     * (biner presisi tunggal) Aritmatika floating point IEE 754.
     * 3. Jika tipe hasilnya panjang, operan akan dipromosikan menjadi panjang, dan
     * operasi dilakukan menggunakan 64-bit
     * aritmatika bilangan bulat biner komplemen dua bertanda tangan.
     * 4. Jika tipe hasilnya adalah int, operan dipromosikan menjadi int, dan
     * operasi dilakukan menggunakan 32-bit
     * aritmatika bilangan bulat biner komplemen dua bertanda tangan.
     */

    // Promosi dilakukan dalam dua tahap:
    /*
     * 1. Jika tipe operan adalah tipe wrapper, nilai operan akan di-unbox ke nilai
     * tipe primitif yang bersangkutan.
     * 2. Jika perlu, tipe primitif dipromosikan ke tipe yang diperlukan:
     * a. Promosi bilangan bulat ke int atau long tidak menimbulkan kerugian.
     * b. Promosi float menjadi double tidak menimbulkan kerugian.
     * c. Promosi bilangan bulat ke nilai floating point dapat menyebabkan hilangnya
     * presisi. Konversi dilakukan menggunakan semantik "round-to-nearest" IEE 768
     * 
     */

    // The meaning of division(Arti pembagian)
    /*
     * Operator / membagi operan sebelah kiri n (pembagi) dan operan sebelah kanan d
     * (pembagi) dan menghasilkan hasil q (hasil bagi).
     * 
     * Pembagian bilangan bulat Java dibulatkan menuju nol. JLS Bagian 15.17.2
     * menetapkan perilaku pembagian bilangan bulat Java sebagai berikut:
     * 
     * Hasil bagi yang dihasilkan untuk operan n dan d merupakan nilai bilangan
     * bulat q yang besarnya sebesar mungkin
     * sambil memuaskan |d ⋅ q| ≤ |n|. Apalagi q positif jika |n| ≥ |d| dan n dan d
     * bertanda sama, tetapi q negatif jika |n| ≥ |d| dan n dan d mempunyai tanda
     * berlawanan.
     */

    // Ada beberapa kasus khusus:
    /*
     * 1. Jika n adalah MIN_VALUE, dan pembaginya adalah -1, maka terjadi overflow
     * integer dan hasilnya adalah MIN_VALUE. Tidak ada pengecualian yang dilempar
     * dalam kasus ini.
     * 2. Jika d adalah 0, maka `ArithmeticException dilempar.
     */

    /*
     * Divisi floating point Java memiliki lebih banyak kasus edge untuk
     * dipertimbangkan. Namun ide dasarnya adalah hasil q adalah nilai yang paling
     * mendekati memuaskan d . q = n.
     * 
     * Pembagian floating point tidak akan pernah menghasilkan pengecualian.
     * Sebaliknya, operasi yang membagi dengan nol menghasilkan INF dan
     * nilai NaN; Lihat di bawah.
     */

    // The meaning of remainder(Arti dari sisa)
    /*
     * Tidak seperti C dan C++, operator sisanya di Java bekerja dengan operasi
     * integer dan floating point.
     * 
     * Untuk kasus integer, hasil dari a % b didefinisikan sebagai bilangan r
     * sehingga (a / b) * b + r sama dengan a, di mana
     * /, * dan + adalah operator integer Java yang sesuai. Hal ini berlaku
     * dalam semua kasus kecuali ketika b adalah nol. Kasus itu,
     * sisanya menghasilkan ArithmeticException.
     * 
     * Berdasarkan definisi di atas, a % b dapat bernilai negatif hanya jika a
     * bernilai negatif, dan menjadi positif hanya jika a bernilai positif. Terlebih
     * lagi, besarnya a % b selalu lebih kecil dari besarnya b.
     * 
     * Operasi sisa floating point adalah generalisasi dari kasus bilangan bulat.
     * Hasil dari a %b adalah sisa r adalah didefinisikan oleh hubungan matematika r
     * = a - (b ⋅ q) dimana:
     * 1. q adalah bilangan bulat,
     * 2. negatif hanya jika a/b negatif dan positif hanya jika a/b positif, dan
     * 3. besarnya sebesar mungkin tanpa melebihi besaran hasil bagi matematis
     * sebenarnya dari a dan B.
     */

    /*
     * Sisa floating point dapat menghasilkan nilai INF dan NaN dalam kasus tepi
     * seperti ketika b adalah nol; Lihat di bawah. Itu tidak akan menimbulkan
     * pengecualian.
     * 
     * Catatan penting:
     * Hasil dari operasi sisa floating-point yang dihitung oleh % tidak sama dengan
     * yang dihasilkan oleh operasi sisa yang ditentukan oleh IEEE 754. Sisa IEEE
     * 754 dapat dihitung menggunakan Metode perpustakaan Math.IEEEremainder.
     */

    // Integer Overflow (Luapan Bilangan Bulat)
    /*
     * Nilai integer Java 32 dan 64 bit ditandatangani dan menggunakan representasi
     * biner dua komplemen. Misalnya, rentang angka yang dapat direpresentasikan
     * sebagai (32 bit) int -231 hingga +231 - 1.
     * 
     * Saat Anda menambah, mengurangi, atau mengalikan dua bilangan bulat N bit (N
     * == 32 atau 64), hasil operasinya mungkin terlalu besar
     * untuk direpresentasikan sebagai bilangan bulat N bit. Dalam hal ini, operasi
     * menyebabkan integer overflow, dan hasilnya dapat dihitung
     * sebagai berikut:
     * 1. Operasi matematika dilakukan untuk memberikan representasi komplemen dua
     * perantara dari keseluruhan bilangan. Representasi ini akan lebih besar dari N
     * bit.
     * 2. 32 atau 64 bit terbawah dari representasi perantara digunakan sebagai
     * hasilnya.
     */

    // Perlu dicatat bahwa integer overflow tidak menghasilkan pengecualian dalam
    // kondisi apa pun

    // Floating point INF and NAN values(Nilai INF dan NAN titik mengambang)
    /*
     * Java menggunakan representasi floating point IEEE 754 untuk float dan double.
     * Representasi ini mempunyai beberapa nilai khusus untuk merepresentasikan
     * nilai yang berada di luar domain bilangan Riil:
     * 1. Nilai "tak terbatas" atau INF menunjukkan angka yang terlalu besar. Nilai
     * +INF menunjukkan angka yang terlalu besar dan positif. Nilai -INF menunjukkan
     * angka yang terlalu besar dan negatif.
     * 2. Kata "tidak terbatas" / "bukan angka" atau NaN menunjukkan nilai yang
     * dihasilkan dari operasi yang tidak berarti.
     */

    // Nilai INF dihasilkan oleh operasi mengambang yang menyebabkan luapan, atau
    // dengan pembagian dengan nol.

    // Nilai NaN dihasilkan dengan membagi nol dengan nol, atau menghitung nol sisa
    // nol.

    /*
     * Anehnya, dimungkinkan untuk melakukan aritmatika menggunakan operan INF dan
     * NaN tanpa memicu pengecualian. Misalnya:
     * 1. Adding +INF and a finite value gives +INF.
     * 2. Adding +INF and +INF gives +INF.
     * 3. Adding +INF and -INF gives NaN.
     * 4. Dividing by INF gives either +0.0 or -0.0.
     * 5. All operations with one or more NaN operands give NaN
     */

    /*
     * Untuk detail selengkapnya, silakan merujuk ke subbagian yang relevan di JLS
     * 15. Perhatikan bahwa ini sebagian besar bersifat "academic". Untuk
     * perhitungan umum, INF atau NaN berarti ada yang tidak beres; misalnya Anda
     * memiliki data input yang tidak lengkap atau salah,
     * atau perhitungan telah diprogram secara tidak benar.
     */

    public static void main(String[] args) {

    }
}
