public class The_relational_operators {
    // The Relational Operators (<, <=, >, >=)

    /*
     * Operator <, <=, > dan >= adalah operator biner untuk membandingkan tipe
     * numerik. Arti dari operator adalah seperti yang Anda harapkan. Misalnya, jika
     * a dan b dideklarasikan sebagai salah satu tipe byte, short, char, int, long,
     * float, double atau kotak yang sesuai:
     * - `a < b` tests if the value of `a` is less than the value of `b`.
     * - `a <= b` tests if the value of `a` is less than or equal to the value of
     * `b`.
     * - `a > b` tests if the value of `a` is greater than the value of `b`.
     * - `a >= b` tests if the value of `a` is greater than or equal to the value of
     * `b`.
     */

    public static void main(String[] args) {
        // Tipe hasil untuk operator ini adalah boolean pada semua kasus.
        // Operator relasional dapat digunakan untuk membandingkan bilangan dengan tipe
        // yang berbeda. Misalnya:
        // int i = 1;
        // long l = 2;
        // if (i < l) {
        // System.out.println("i is smaller");
        // }
        /*
         * output:
         * i is smaller
         */
        // ---------------------
        // Operator relasional dapat digunakan ketika salah satu atau kedua angka
        // merupakan turunan dari tipe numerik kotak. Misalnya:
        Integer i = 1; // 1 is autoboxed to an Integer
        Integer j = 2; // 2 is autoboxed to an Integer
        if (i < j) {
            System.out.println("i is smaller");
        }
        /*
         * output:
         * i is smaller
         */

        // Perilaku tepatnya dirangkum sebagai berikut:
        /*
         * 1. Jika salah satu operan bertipe kotak, maka operan tersebut tidak
         * dikotakkan.
         * 2. Jika salah satu operan sekarang berupa byte, short, atau char, maka akan
         * dipromosikan menjadi int.
         * 3. Jika tipe operannya tidak sama, maka operan dengan tipe "lebih kecil"
         * dipromosikan ke tipe "lebih besar".
         * 4. Perbandingan dilakukan terhadap nilai int, long, float atau double yang
         * dihasilkan.
         * 
         */

        /*
         * Anda harus berhati-hati dengan perbandingan relasional yang melibatkan angka
         * floating point:
         * 1. Ekspresi yang menghitung bilangan floating point sering kali menimbulkan
         * kesalahan pembulatan karena fakta bahwa representasi floating point komputer
         * memiliki presisi yang terbatas.
         * 2. Saat membandingkan tipe integer dan tipe floating point, konversi integer
         * ke floating point juga dapat menyebabkan kesalahan pembulatan.
         * 
         * Terakhir, Java sedikit mendukung penggunaan operator relasional dengan tipe
         * apa pun selain yang tercantum di atas. Misalnya, Anda tidak dapat menggunakan
         * operator ini untuk membandingkan string, array angka, dan sebagainya.
         * 
         */
    }
}
