import java.util.Random;

public class Pseudo_random_numbers {
    // Pseudo Random Numbers/ Bilangan Acak Semu

    /*
     * Java menyediakan, sebagai bagian dari utils package, generator bilangan
     * pseudo-acak dasar, yang diberi nama dengan tepat
     * Acak. Objek ini dapat digunakan untuk menghasilkan nilai pseudo-acak sebagai
     * salah satu tipe data numerik bawaan (int,
     * mengapung, dll). Anda juga dapat menggunakannya untuk menghasilkan nilai
     * Boolean acak, atau array byte acak. Contoh penggunaannya adalah sebagai
     * berikut:
     * 
     * import java.util.Random;
     * ...
     * Random random = new Random();
     * int randInt = random.nextInt();
     * long randLong = random.nextLong();
     * double randDouble = random.nextDouble(); //This returns a value between 0.0
     * and 1.0
     * float randFloat = random.nextFloat(); //Same as nextDouble
     * byte[] randBytes = new byte[16];
     * random.nextBytes(randBytes); //nextBytes takes a user-supplied byte array,
     * and fills it with random
     * bytes. It returns nothing
     * 
     */

    /*
     * CATATAN: Kelas ini hanya menghasilkan bilangan pseudo-acak berkualitas
     * rendah, dan tidak boleh digunakan untuk menghasilkan
     * nomor acak untuk operasi kriptografi atau situasi lain yang memerlukan
     * keacakan dengan kualitas lebih tinggi (Untuk itu, Anda ingin menggunakan
     * kelas SecureRandom, seperti disebutkan di bawah). Penjelasan tentang
     * perbedaan antara
     * Keacakan "secure" dan "insecure" berada di luar cakupan contoh ini.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Random random = new Random();
        int randInt = random.nextInt();
        long randLong = random.nextLong();
        double randDouble = random.nextDouble(); // This returns a value between 0.0 and 1.0
        float randFloat = random.nextFloat(); // Same as nextDouble
        byte[] randBytes = new byte[16];
        random.nextBytes(randBytes); // nextBytes takes a user-supplied byte array, and fills it with random
        // bytes. It returns nothing.

        System.out.print("Random Bytes: ");
        for (byte b : randBytes) {
            System.out.print(b + " ");
        }
        /*
         * output:
         * Random Bytes: 126 -55 112 78 -73 -110 2 -3 -49 91 6 124 80 -93 -64 51
         */

    }
}
