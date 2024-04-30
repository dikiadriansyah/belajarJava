public class Documenting_enums {
    // Documenting enums / Mendokumentasikan enum

    // Nama enum tidak selalu cukup jelas untuk dipahami. Untuk mendokumentasikan
    // enum, gunakan javadoc standar:

    /**
     * United States coins
     */
    public enum Coins {

        /**
         * One-cent coin, commonly known as a penny,
         * is a unit of currency equaling one-hundredth
         * of a United States dollar
         */
        PENNY(1),
        /**
         * A nickel is a five-cent coin equaling
         * five-hundredth of a United States dollar
         */
        NICKEL(5),
        /**
         * The dime is a ten-cent coin refers to
         * one tenth of a United States dollar
         */
        DIME(10),
        /**
         * The quarter is a US coin worth 25 cents,
         * one-fourth of a United States dollar
         */
        QUARTER(25);

        private int value;

        Coins(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Contoh penggunaan enum Coins
        Coins penny = Coins.PENNY;
        Coins nickel = Coins.NICKEL;
        Coins dime = Coins.DIME;
        Coins quarter = Coins.QUARTER;

        // Mendapatkan nilai dari setiap koin
        int pennyValue = penny.getValue();
        int nickelValue = nickel.getValue();
        int dimeValue = dime.getValue();
        int quarterValue = quarter.getValue();

        // Menampilkan informasi
        System.out.println("Penny: " + pennyValue + " cents");
        System.out.println("Nickel: " + nickelValue + " cents");
        System.out.println("Dime: " + dimeValue + " cents");
        System.out.println("Quarter: " + quarterValue + " cents");
        /*
         * output:
         * Penny: 1 cents
         * Nickel: 5 cents
         * Dime: 10 cents
         * Quarter: 25 cents
         */
    }
}
