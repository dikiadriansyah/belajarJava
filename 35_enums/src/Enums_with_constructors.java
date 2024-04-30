import java.io.Serializable;

public class Enums_with_constructors {
    // Enums with constructors / Enum dengan konstruktor

    /*
     * Enum tidak boleh memiliki konstruktor publik; namun, konstruktor swasta dapat
     * diterima (konstruktor untuk enums adalah paket-pribadi secara default):
     */

    public enum Coin {
        PENNY(1), NICKEL(5), DIME(10), QUARTER(25); // usual names for US coins
        // note that the above parentheses and the constructor arguments match

        private int value;

        Coin(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    // int p = Coin.NICKEL.getValue(); // the int value will be 5

    /*
     * Disarankan agar Anda menjaga semua bidang tetap pribadi dan menyediakan
     * metode pengambil, karena ada jumlah instance yang terbatas untuk sebuah enum.
     * Jika Anda mengimplementasikan Enum sebagai kelas, tampilannya akan seperti
     * ini:
     */

    // public class Coin<T extends Coin<T>> implements Comparable<T>, Serializable {
    // public static final Coin PENNY = new Coin(1);
    // public static final Coin NICKEL = new Coin(5);
    // public static final Coin DIME = new Coin(10);
    // public static final Coin QUARTER = new Coin(25);
    // private int value;

    // private Coin(int value) {
    // this.value = value;
    // }

    // public int getValue() {
    // return value;
    // }
    // }

    // int p = Coin.NICKEL.getValue(); // the int value will be 5

    /*
     * Konstanta enum secara teknis dapat berubah, sehingga penyetel dapat
     * ditambahkan untuk mengubah struktur internal konstanta enum. Namun, hal ini
     * dianggap praktik yang sangat buruk dan harus dihindari.
     * 
     * Praktik terbaiknya adalah menjadikan bidang Enum tidak dapat diubah, dengan
     * final:
     */

    // public enum Coin {
    // PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    // private final int value;

    // Coin(int value) {
    // this.value = value;
    // }
    // // ...
    // }

    /*
     * Anda dapat mendefinisikan beberapa konstruktor dalam enum yang sama. Ketika
     * Anda melakukannya, argumen yang Anda sampaikan dalam deklarasi enum
     * menentukan konstruktor mana yang dipanggil:
     */

    // public enum Coin {
    // PENNY(1, true), NICKEL(5, false), DIME(10), QUARTER(25);

    // private final int value;
    // private final boolean isCopperColored;

    // Coin(int value) {
    // this(value, false);
    // }

    // Coin(int value, boolean isCopperColored) {
    // this.value = value;
    // this.isCopperColored = isCopperColored;
    // }
    // // ...
    // }

    /*
     * Catatan: Semua bidang enum non-primitif harus mengimplementasikan
     * Serializable karena kelas Enum menerapkannya
     */

    public static void main(String[] args) {

    }
}
