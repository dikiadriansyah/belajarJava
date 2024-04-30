public class The_increment_decrement_operators {
    // The Increment/Decrement Operators (++/--)

    /*
     * Variabel dapat ditambah atau dikurangi 1 masing-masing menggunakan operator
     * ++ dan --.
     * 
     * Ketika operator ++ dan -- mengikuti variabel, mereka masing-masing disebut
     * pasca kenaikan dan pasca penurunan
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        int a = 10;
        a++; // a now equals 11
        a--; // a now equals 10 again

        /*
         * Ketika operator ++ dan -- mendahului variabel, operasinya masing-masing
         * disebut pra-kenaikan dan pra-penurunan.
         */

        // int x = 10;
        // --x; // x now equals 9
        // ++x; // x now equals 10

        /*
         * Jika operator mendahului variabel, nilai ekspresi adalah nilai variabel
         * setelah ditambah atau dikurangi. Jika operator mengikuti variabel, nilai
         * ekspresi adalah nilai variabel sebelum ditambah atau dikurangi.
         */
        // int x = 10;
        // System.out.println("x=" + x + " x=" + x++ + " x=" + x); // outputs x=10 x=10
        // x=11

        // System.out.println("x=" + x + " x=" + ++x + " x=" + x); // outputs x=11 x=12
        // x=12

        // System.out.println("x=" + x + " x=" + x-- + " x=" + x); // outputs x=12 x=12
        // x=11

        // System.out.println("x=" + x + " x=" + --x + " x=" + x); // outputs x=11 x=10
        // x=10

        /*
         * Berhati-hatilah untuk tidak menimpa kenaikan atau penurunan pasca. Hal ini
         * terjadi jika Anda menggunakan operator pasca-masuk/pengurangan di akhir
         * ekspresi yang ditugaskan kembali ke variabel masuk/pengurangan itu sendiri.
         * Kenaikan/penurunan tidak akan berpengaruh. Meskipun variabel di sisi kiri
         * bertambah dengan benar, nilainya akan segera ditimpa dengan hasil evaluasi
         * sebelumnya dari ekspresi di sisi kanan:
         */

        // int x = 0;
        // x = x++ + 1 + x++; // x = 0 + 1 + 1
        // do not do this - the last increment has no effect (bug!)
        // System.out.println(x); // prints 2 (not 3!)

        // Benar:
        int x = 0;
        x = x++ + 1 + x; // evaluates to x = 0 + 1 + 1
        x++; // adds 1
        System.out.println(x);
        /*
         * output:
         * 3
         */
    }
}
