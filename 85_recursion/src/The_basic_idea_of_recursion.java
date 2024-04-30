public class The_basic_idea_of_recursion {
    // The basic idea of recursion/Ide dasar rekursi

    /*
     * Apa itu rekursi:
     * Secara umum, rekursi adalah ketika suatu fungsi memanggil dirinya sendiri,
     * baik secara langsung maupun tidak langsung. Misalnya:
     * 
     * // This method calls itself "infinitely"
     * public void useless() {
     * useless(); // method calls itself (directly)
     * }
     */

    /*
     * Kondisi untuk menerapkan rekursi pada suatu masalah:
     * Ada dua prasyarat untuk menggunakan fungsi rekursif untuk menyelesaikan
     * masalah tertentu:
     * 1. Harus ada kondisi dasar untuk masalah tersebut, yang akan menjadi titik
     * akhir rekursi. Ketika fungsi rekursif mencapai kondisi dasar, fungsi tersebut
     * tidak melakukan pemanggilan rekursif lebih lanjut (lebih dalam).
     * 2. Setiap tingkat rekursi harus mencoba masalah yang lebih kecil. Fungsi
     * rekursif dengan demikian membagi
     * masalah menjadi bagian-bagian yang lebih kecil dan lebih kecil. Dengan asumsi
     * bahwa masalahnya terbatas, hal ini akan memastikan bahwa rekursi berakhir.
     */

    /*
     * Di Java, terdapat prasyarat ketiga: tidak perlu melakukan perulangan terlalu
     * dalam untuk menyelesaikan masalah; lihat Rekursi mendalam bermasalah di Java
     * 
     * contoh
     * Fungsi berikut menghitung faktorial menggunakan rekursi. Perhatikan bagaimana
     * metode faktorial memanggil dirinya sendiri di dalam fungsi tersebut. Setiap
     * kali ia memanggil dirinya sendiri, ia mengurangi parameter n sebesar 1.
     * Ketika n mencapai 1 (kondisi dasar), fungsi tersebut tidak akan terulang
     * lebih dalam lagi.
     * public int factorial(int n) {
     * if (n <= 1) { // the base condition
     * return 1;
     * } else {
     * return n * factorial(n - 1);
     * }
     * }
     */

    /*
     * Ini bukan cara praktis menghitung faktorial di Java, karena tidak
     * memperhitungkan integer overflow, atau memanggil stack overflow (yaitu
     * pengecualian StackOverflowError) untuk nilai n yang besar.
     */

    public int factorial(int n) {
        if (n <= 1) { // the base condition
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        The_basic_idea_of_recursion box = new The_basic_idea_of_recursion();
        int n = 5;
        int result = box.factorial(n);
        System.out.println("Faktorial dari " + n + "adalah: " + result);
        /*
         * output:
         * Faktorial dari 5adalah: 120
         */
    }
}
