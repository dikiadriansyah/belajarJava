public class Enum_with_properties {
    // Enum with properties (fields)/ Enum dengan properti (bidang)

    /*
     * Jika kita ingin menggunakan enum dengan lebih banyak informasi dan bukan
     * hanya sebagai nilai konstan, dan kita ingin dapat membandingkan dua enum.
     * 
     * Perhatikan contoh berikut:
     */

    public enum Coin {
        PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

        private final int value;

        Coin(int value) {
            this.value = value;
        }

        public boolean isGreaterThan(Coin other) {
            return this.value > other.value;
        }
    }

    /*
     * Di sini kami mendefinisikan Enum yang disebut Koin yang mewakili nilainya.
     * Dengan metode isGreaterThan kita dapat membandingkan dua enum:
     */

    public static void main(String[] args) {
        Coin penny = Coin.PENNY;
        Coin dime = Coin.DIME;
        System.out.println(penny.isGreaterThan(dime)); // prints: false
        System.out.println(dime.isGreaterThan(penny)); // prints: true
    }
}
