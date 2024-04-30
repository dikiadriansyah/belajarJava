public class The_throws_clause_in_a_method_declaration {
    // The 'throws' clause in a method declaration/Klausa 'melempar' dalam deklarasi
    // metode

    /*
     * Mekanisme pengecualian yang dicentang di Java mengharuskan pemrogram untuk
     * mendeklarasikan bahwa metode tertentu dapat memunculkan pengecualian yang
     * dicentang tertentu. Hal ini dilakukan dengan menggunakan klausa throws.
     * Misalnya:
     */

    /*
     * public class OddNumberException extends Exception { // a checked exception
     * }
     * public void checkEven(int number) throws OddNumberException {
     * if (number % 2 != 0) {
     * throw new OddNumberException();
     * }
     * }
     */

    /*
     * Throws OddNumberException mendeklarasikan bahwa panggilan ke checkEven dapat
     * memunculkan pengecualian bertipe
     * OddNumberException.
     * 
     * Klausa throws dapat mendeklarasikan daftar tipe, dan dapat menyertakan
     * pengecualian yang tidak dicentang serta pengecualian yang dicentang.
     */

    /*
     * public void checkEven(Double number)
     * throws OddNumberException, ArithmeticException {
     * if (!Double.isFinite(number)) {
     * throw new ArithmeticException("INF or NaN");
     * } else if (number % 2 != 0) {
     * throw new OddNumberException();
     * }
     * }
     */

    /*
     * Apa gunanya mendeklarasikan pengecualian yang tidak dicentang sebagai
     * pengecualian?
     */

    /*
     * Klausa throws dalam deklarasi metode memiliki dua tujuan:
     * 1. Ini memberi tahu kompiler pengecualian mana yang diberikan sehingga
     * kompiler dapat melaporkan tidak tertangkap (dicentang)
     * pengecualian sebagai kesalahan.
     * 2. Ia memberi tahu programmer yang sedang menulis kode yang memanggil metode
     * pengecualian apa yang diharapkan. Untuk tujuan ini,
     * sering kali masuk akal untuk memasukkan pengecualian yang tidak dicentang ke
     * dalam daftar throws.
     */

    /*
     * Catatan: bahwa daftar lemparan juga digunakan oleh alat javadoc saat membuat
     * dokumentasi API, dan dengan tip metode "hover text" IDE pada umumnya.
     */

    // Throws and method overriding/Lemparan dan penggantian metode
    /*
     * Klausa throws merupakan bagian dari tanda tangan metode untuk tujuan
     * penggantian metode. Metode penggantian
     * dapat dideklarasikan dengan kumpulan pengecualian yang dicentang sama seperti
     * yang diberikan oleh metode yang diganti, atau dengan subset.
     * Namun metode override tidak dapat menambahkan pengecualian tambahan yang
     * dicentang. Misalnya:
     * 
     * @Override
     * public void checkEven(int number) throws NullPointerException //
     * OK—NullPointerException is an
     * unchecked exception
     * 
     * @Override
     * public void checkEven(Double number) throws OddNumberException //
     * OK—identical to the superclass
     * ...
     * class PrimeNumberException extends OddNumberException {}
     * class NonEvenNumberException extends OddNumberException {}
     * 
     * @Override
     * public void checkEven(int number) throws PrimeNumberException,
     * NonEvenNumberException // OK—these
     * are both subclasses
     * 
     * @Override
     * public void checkEven(Double number) throws IOExcepion // ERROR
     */

    /*
     * Alasan aturan ini adalah jika metode yang ditimpa dapat memunculkan
     * pengecualian yang dicentang yang tidak dapat dilempar oleh metode yang
     * ditimpa, hal itu akan merusak kemampuan substitusi tipe.
     */

    public static void main(String[] args) {
        try {
            // Contoh pemanggilan metode checkEven
            // checkEven(4.0); // Ini akan berhasil karena 4.0 adalah bilangan genap
            checkEven(3.0); // Ini akan melemparkan OddNumberException karena 3.0 adalah
            // bilangan ganjil
            // checkEven(Double.NaN); // Ini akan melemparkan ArithmeticException karena NaN
            // tidak valid
        } catch (OddNumberException e) {
            System.out.println("Caught OddNumberException: The number is odd.");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        /*
         * output:
         * Caught OddNumberException: The number is odd.
         */

    }

    public static void checkEven(Double number) throws OddNumberException, ArithmeticException {
        if (!Double.isFinite(number)) {
            throw new ArithmeticException("INF or NaN");
        } else if (number % 2 != 0) {
            throw new OddNumberException();
        }
    }

}

// Definisi kelas OddNumberException
class OddNumberException extends Exception {
    public OddNumberException() {
        super("OddNumberException: The number is odd.");
    }
}
