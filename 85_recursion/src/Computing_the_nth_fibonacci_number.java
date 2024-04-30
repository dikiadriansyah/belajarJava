public class Computing_the_nth_fibonacci_number {
    // Computing the Nth Fibonacci Number/Menghitung Angka Fibonacci ke-N

    // Metode berikut menghitung bilangan Fibonacci ke-N menggunakan rekursi.

    /*
     * public int fib(final int n) {
     * if (n > 2) {
     * return fib(n - 2) + fib(n - 1);
     * }
     * return 1;
     * }
     * 
     */

    /*
     * Metode ini mengimplementasikan kasus dasar (n <= 2) dan kasus rekursif (n>2).
     * Ini menggambarkan penggunaan rekursi untuk menghitung relasi rekursif.
     * 
     * Namun, meskipun contoh ini hanya bersifat ilustratif, namun juga tidak
     * efisien: setiap contoh metode akan memanggil
     * fungsi itu sendiri dua kali, menyebabkan pertumbuhan eksponensial dalam
     * berapa kali fungsi tersebut dipanggil ketika N bertambah.
     * Fungsi di atas adalah O(2N), tetapi solusi iteratif yang setara memiliki
     * kompleksitas O(N). Selain itu, ada yang "tertutup
     * bentuk" ekspresi yang dapat dievaluasi dalam perkalian floating-point O(N).
     */

    public static void main(String[] args) {
        Computing_the_nth_fibonacci_number box1 = new Computing_the_nth_fibonacci_number();
        int n = 10;
        int result = box1.fib(n);
        System.out.println("Fibonacci dari " + n + " adalah: " + result);
        // output:
        // Fibonacci dari 10 adalah: 55
    }

    public int fib(final int n) {
        if (n > 2) {
            return fib(n - 2) + fib(n - 1);
        }
        return 1;
    }
}
