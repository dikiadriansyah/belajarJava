public class Types_of_recursion {
    // Types of Recursion/Jenis Rekursi

    /*
     * Rekursi dapat dikategorikan sebagai Rekursi Kepala(Head Recursion) atau
     * Rekursi Ekor(Tail Recursion),
     * bergantung pada tempat pemanggilan metode rekursif dilakukan.
     * 
     * Dalam rekursi head(head Recursion), pemanggilan rekursif, ketika terjadi,
     * terjadi sebelum
     * pemrosesan lain dalam fungsi tersebut (anggap saja terjadi di bagian atas,
     * atau head, fungsi).
     * 
     * Dalam rekursi ekor(tail recursion), kebalikannya—pemrosesan terjadi sebelum
     * pemanggilan
     * rekursif. Memilih antara dua gaya rekursif mungkin tampak sewenang-wenang,
     * tetapi pilihan tersebut dapat membuat perbedaan besar.
     * 
     * Fungsi dengan jalur dengan satu panggilan rekursif di awal jalur menggunakan
     * apa yang disebut rekursi head.
     * Fungsi faktorial dari pameran sebelumnya menggunakan rekursi head. Hal
     * pertama yang dilakukan setelah menentukan bahwa rekursi diperlukan adalah
     * memanggil dirinya sendiri dengan parameter yang dikurangi. Fungsi dengan satu
     * panggilan rekursif di akhir jalur menggunakan rekursi ekor.
     */

    /*
     * public void tail(int n){
     * if(n == 1){
     * return;
     * }else{
     * System.out.println(n)
     * tail(n-1);
     * }
     * }
     * 
     * public void head(int n){
     * if(n == 0){
     * return;
     * }else{
     * head(n-1);
     * System.out.println(n);
     * }
     * }
     * 
     */

    /*
     * Jika pemanggilan rekursif terjadi di akhir suatu metode, maka disebut rekursi
     * ekor. Rekursi ekor mirip dengan loop. Metode ini mengeksekusi semua
     * pernyataan sebelum beralih ke panggilan rekursif berikutnya.
     * 
     * Jika pemanggilan rekursif terjadi pada awal suatu metode, maka disebut
     * rekursi head. Metode ini menyimpan status sebelum beralih ke panggilan
     * rekursif berikutnya.
     */

    public static void main(String[] args) {
        Types_of_recursion box = new Types_of_recursion();
        // box.tail(5);
        /*
         * output:
         * 5
         * 4
         * 3
         * 2
         */
        // ------------
        box.head(5);
        /*
         * output:
         * 1
         * 2
         * 3
         * 4
         * 5
         */
    }

    // public void tail(int n) {
    // if (n == 1) {
    // return;
    // } else {
    // System.out.println(n);
    // tail(n - 1);
    // }
    // }
    // -----------------------
    public void head(int n) {
        if (n == 0) {
            return;
        } else {
            head(n - 1);
            System.out.println(n);
        }
    }

}
