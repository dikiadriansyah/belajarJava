public class Enum_singleton {
    // Enum Singleton/Misalnya Singleton

    /*
     * Version ≥ Java SE 5
     * public enum Singleton {
     * INSTANCE;
     * public void execute (String arg) {
     * // Perform operation here
     * }
     * }
     */

    /*
     * Enum memiliki konstruktor swasta, bersifat final dan menyediakan mesin
     * serialisasi yang tepat. Mereka juga sangat ringkas
     * dan dengan malas diinisialisasi dengan cara thread yang aman.
     * 
     * JVM memberikan jaminan bahwa nilai enum tidak akan dipakai lebih dari satu
     * kali, yang memberikan pola enum singleton pertahanan yang sangat kuat
     * terhadap serangan refleksi.
     * 
     * Yang tidak dilindungi oleh pola enum adalah pengembang lain secara fisik
     * menambahkan lebih banyak elemen ke sumbernya
     * kode. Oleh karena itu, jika Anda memilih gaya penerapan ini untuk lajang
     * Anda, Anda harus melakukannya dengan sangat jelas
     * dokumen bahwa tidak ada nilai baru yang harus ditambahkan ke enum tersebut.
     */

    // Ini adalah cara yang disarankan untuk mengimplementasikan pola tunggal,
    // seperti yang dijelaskan oleh Joshua Bloch di Java Efektif.

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Singleton.INSTANCE.execute("Hello World");
        /*
         * output:
         * Executing with argument: Hello World
         */
    }
}
