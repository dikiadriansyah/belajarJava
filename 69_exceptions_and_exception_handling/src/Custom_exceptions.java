public class Custom_exceptions {
    // Custom Exceptions/Pengecualian Khusus

    /*
     * Dalam sebagian besar situasi, lebih mudah dari sudut pandang desain kode
     * untuk menggunakan kelas Exception generik yang ada
     * saat melempar pengecualian. Hal ini terutama berlaku jika Anda hanya
     * memerlukan pengecualian untuk membawa pesan kesalahan sederhana. Dalam hal
     * ini, RuntimeException biasanya lebih disukai, karena ini bukan Pengecualian
     * yang dicentang. Kelas pengecualian lainnya ada untuk kelas kesalahan umum:
     */

    /*
     * 1. UnsupportedOperationException - operasi tertentu tidak didukung
     * 2. IllegalArgumentException - nilai parameter yang tidak valid diteruskan ke
     * suatu metode
     * 3. IllegalStateException - API Anda secara internal telah mencapai kondisi
     * yang tidak boleh terjadi, atau yang terjadi akibat penggunaan API Anda dengan
     * cara yang tidak valid
     */

    // Kasus di mana Anda ingin menggunakan kelas pengecualian khusus mencakup hal
    // berikut:
    /*
     * 1. Anda sedang menulis API atau pustaka untuk digunakan oleh orang lain, dan
     * Anda ingin mengizinkan pengguna API Anda untuk dapat secara khusus menangkap
     * dan menangani pengecualian dari API Anda, dan dapat membedakan pengecualian
     * tersebut dari yang lain, pengecualian yang lebih umum.
     * 
     * 2. Anda memberikan pengecualian untuk jenis kesalahan tertentu di satu bagian
     * program Anda, yang ingin Anda tangkap dan tangani di bagian lain program
     * Anda, dan Anda ingin dapat membedakan kesalahan ini dari kesalahan lain yang
     * lebih umum.
     */

    /*
     * Anda dapat membuat pengecualian khusus Anda sendiri dengan memperluas
     * RuntimeException untuk pengecualian yang tidak dicentang, atau memeriksa
     * pengecualian dengan memperluas exception apa pun yang juga bukan subkelas
     * RuntimeException, karena:
     * Subkelas Exception yang bukan juga merupakan subkelas RuntimeException akan
     * dicentang sebagai pengecualian
     */

    /*
     * public class StringTooLongException extends RuntimeException {
     * // Exceptions can have methods and fields like other classes
     * // those can be useful to communicate information to pieces of code catching
     * // such an exception
     * public final String value;
     * public final int maximumLength;
     * public StringTooLongException(String value, int maximumLength){
     * super(String.format("String exceeds maximum Length of %s: %s", maximumLength,
     * value));
     * this.value = value;
     * this.maximumLength = maximumLength;
     * }
     * }
     */

    // Itu dapat digunakan seperti pengecualian yang telah ditentukan sebelumnya:

    /*
     * void validasiString(Nilai string){
     * if (nilai.panjang() > 30){
     * melempar StringTooLongException baru (nilai, 30);
     * }
     * }
     */

    // Dan bidang tersebut dapat digunakan di mana pengecualian ditangkap dan
    // ditangani:
    /*
     * void anotherMethod(String value){
     * try {
     * validateString(value);
     * } catch(StringTooLongException e){
     * System.out.println("The string '" + e.value +
     * "' was longer than the max of " + e.maximumLength );
     * }
     * }
     */

    // Ingatlah bahwa, menurut Dokumentasi Java Oracle :
    /*
     * [...] Jika klien dapat diharapkan untuk pulih dari pengecualian, jadikan itu
     * sebagai pengecualian yang dicentang. Jika sebuah
     * klien tidak dapat melakukan apa pun untuk memulihkan pengecualian, jadikan
     * pengecualian tersebut tidak dicentang.
     */

    // lagi:
    // http://stackoverflow.com/a/14995225/3502776

    public static void validateString(String value) {
        if (value.length() > 30) {
            throw new StringTooLongException(value, 30);
        }
    }

    public static void anotherMethod(String value) {
        try {
            validateString(value);
        } catch (StringTooLongException e) {
            System.out.println("The string '" + e.value +
                    "' was longer than the max of " + e.maximumLength);
        }
    }

    public static void main(String[] args) {
        // Example usage
        anotherMethod("This is a very long string that exceeds the maximum length");
        /*
         * output:
         * The string 'This is a very long string that exceeds the maximum length' was
         * longer than the max of 30
         */
    }
}
