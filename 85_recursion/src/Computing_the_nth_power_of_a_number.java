public class Computing_the_nth_power_of_a_number {
    // Computing the Nth power of a number/Menghitung pangkat ke-N suatu bilangan

    /*
     * Metode berikut menghitung nilai num yang dipangkatkan exp menggunakan
     * rekursi:
     * 
     * public long power(final int num, final int exp) {
     * if (exp == 0) {
     * return 1;
     * }
     * if (exp == 1) {
     * return num;
     * }
     * return num * power(num, exp - 1);
     * }
     */

    /*
     * Ini menggambarkan prinsip-prinsip yang disebutkan di atas: metode rekursif
     * mengimplementasikan kasus dasar (dua kasus, n = 0 dan
     * n = 1) yang menghentikan rekursi, dan kasus rekursif yang memanggil metode
     * tersebut lagi. Metode ini O(N) dan bisa
     * direduksi menjadi loop sederhana menggunakan optimasi tail-call.
     */

    public static void main(String[] args) {
        Computing_the_nth_power_of_a_number box = new Computing_the_nth_power_of_a_number();
        int bilangan1 = 4;
        int bilangan2 = 2;
        long result = box.power(bilangan1, bilangan2);
        System.out.println("pangkat: " + bilangan1 + " menghasilkan " + result);
        /*
         * output:
         * pangkat: 4 menghasilkan 16
         */
    }

    public long power(final int num, final int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return num;
        }
        return num * power(num, exp - 1);
    }
}
