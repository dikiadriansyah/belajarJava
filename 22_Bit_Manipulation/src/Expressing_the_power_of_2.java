public class Expressing_the_power_of_2 {
    // Expressing the power of 2

    /*
     * Untuk menyatakan pangkat 2 (2^n) bilangan bulat, seseorang dapat menggunakan
     * operasi bitshift yang memungkinkan untuk menentukan n secara eksplisit.
     * 
     * Sintaksnya pada dasarnya adalah:
     * int pow2 = 1<<n;
     */

    public static void main(String[] args) throws Exception {
        int twoExp4 = 1 << 4; // 2^4
        int twoExp5 = 1 << 5; // 2^5
        int twoExp6 = 1 << 6; // 2^6
        // System.out.println(twoExp4); // 16

        int twoExp31 = 1 << 31; // 2^31

        /*
         * Hal ini sangat berguna ketika menentukan nilai konstanta yang akan
         * memperjelas bahwa pangkat 2 digunakan, alih-alih menggunakan nilai
         * heksadesimal atau desimal.
         */

        int twoExp7 = 0x10; // hexadecimal
        int twoExp8 = 0x20; // hexadecimal
        int twoExp9 = 64; // decimal
        // ...
        int twoExp10 = -2147483648; // is that a power of 2?
        System.out.println(twoExp7); // 16

        // Metode sederhana untuk menghitung pangkat int dari 2 adalah
        // int pow2(int exp){
        // return 1<<exp;
        // }

    }
}
