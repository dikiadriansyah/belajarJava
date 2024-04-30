public class for_loops {
    // for loops

    /*
     * for (int i = 0; i < 10; i++) {
     * System.out.println(i);
     * }
     */

    /*
     * Tiga komponen perulangan for (dipisahkan dengan ;) adalah
     * deklarasi/inisialisasi variabel (di sini int i = 0), kondisi (di sini i <
     * 100), dan pernyataan increment (di sini i++). Deklarasi variabel dilakukan
     * satu kali seolah-olah ditempatkan tepat di dalam { saat pertama kali
     * dijalankan. Kemudian kondisi dicek, jika true maka badan perulangan akan
     * dijalankan, jika false maka perulangan akan berhenti. Dengan asumsi
     * perulangan berlanjut, isi akan dieksekusi dan akhirnya ketika } tercapai
     * pernyataan increment akan dieksekusi tepat sebelum kondisi diperiksa kembali.
     */

    /*
     * Tanda kurung kurawal bersifat opsional (Anda dapat menggunakan satu baris
     * dengan titik koma) jika perulangan hanya berisi satu pernyataan. Namun,
     * selalu disarankan untuk menggunakan kawat gigi untuk menghindari
     * kesalahpahaman dan bug.
     * 
     * Komponen loop for bersifat opsional. Jika logika bisnis Anda berisi salah
     * satu bagian ini, Anda dapat menghilangkan komponen terkait dari perulangan
     * for Anda.
     * 
     * int i = obj.getLastestValue(); // i value is fetched from a method
     * 
     * for (; i < 100; i++) { // here initialization is not done
     * System.out.println(i);
     * }
     */

    /*
     * Struktur for (;;) { function-body } sama dengan perulangan while (true).
     * 
     * Bersarang for Loop
     * 
     * Setiap pernyataan perulangan yang memiliki pernyataan perulangan lain di
     * dalamnya disebut perulangan bersarang. Cara yang sama untuk perulangan yang
     * memiliki lebih banyak perulangan bagian dalam disebut 'perulangan for
     * bersarang'.
     * 
     * for(;;){
     * //Outer Loop Statements
     * for(;;){
     * //Inner Loop Statements
     * }
     * //Outer Loop Statements
     * }
     */

    // Perulangan for bersarang dapat didemonstrasikan untuk mencetak angka
    // berbentuk segitiga.

    /*
     * for(int i=9;i>0;i--){//Outer Loop
     * System.out.println();
     * for(int k=i;k>0;k--){//Inner Loop -1
     * System.out.print(" ");
     * }
     * for(int j=i;j<=9;j++){//Inner Loop -2
     * System.out.print(" "+j);
     * }
     * }
     */

    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        // System.out.println(i);
        // }
        /*
         * output:
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         */
        // --------------------------------
        // Fetch the latest value from the method
        // SomeClass obj = new SomeClass();
        // int i = obj.getLastestValue();

        // Assuming the loop should continue until i reaches 100
        // for (; i < 100; i++) {
        // System.out.println(i);
        // }

        /*
         * *output:
         * 80
         * 81
         * 82
         * 83
         * 84
         * 85
         * 86
         * 87
         * 88
         * 89
         * 90
         * 91
         * 92
         * 93
         * 94
         * 95
         * 96
         * 97
         * 98
         * 99
         */

        // -------------------------
        // for (int i = 9; i > 0; i--) {// Outer Loop
        // System.out.println();
        // for (int k = i; k > 0; k--) {// Inner Loop -1
        // System.out.print(" ");
        // }
        // for (int j = i; j <= 9; j++) {// Inner Loop -2
        // System.out.print(" " + j);
        // }
        // }

        /*
         * output:
         * 9
         * 8 9
         * 7 8 9
         * 6 7 8 9
         * 5 6 7 8 9
         * 4 5 6 7 8 9
         * 3 4 5 6 7 8 9
         * 2 3 4 5 6 7 8 9
         */

    }
}
