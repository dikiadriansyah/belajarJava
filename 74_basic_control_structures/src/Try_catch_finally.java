public class Try_catch_finally {
    // Try ... Catch ... Finally

    /*
     * Struktur kontrol try { ... } catch ( ... ) { ... } digunakan untuk menangani
     * Pengecualian.
     */

    /*
     * String age_input = "abc";
     * try {
     * int age = Integer.parseInt(age_input);
     * if (age >= 18) {
     * System.out.println("You can vote!");
     * } else {
     * System.out.println("Sorry, you can't vote yet.");
     * }
     * } catch (NumberFormatException ex) {
     * System.err.println("Invalid input. '" + age_input +
     * "' is not a valid integer.");
     * }
     */

    /*
     * Ini akan mencetak:
     * Invalid input. 'abc' is not a valid integer.
     */

    /*
     * Klausa finally dapat ditambahkan setelah catch. Klausa finally akan
     * selalu dieksekusi, terlepas dari apakah ada pengecualian yang diberikan.
     */

    /*
     * try { ... } catch ( ... ) { ... } finally { ... }
     * String age_input = "abc";
     * try {
     * int age = Integer.parseInt(age_input);
     * if (age >= 18) {
     * System.out.println("You can vote!");
     * } else {
     * System.out.println("Sorry, you can't vote yet.");
     * }
     * } catch (NumberFormatException ex) {
     * System.err.println("Invalid input. '" + age_input +
     * "' is not a valid integer.");
     * } finally {
     * System.out.
     * println("This code will always be run, even if an exception is thrown");
     * }
     * 
     */

    /*
     * Ini akan mencetak:
     * Invalid input. 'abc' is not a valid integer.
     * This code will always be run, even if an exception is thrown
     */

    public static void main(String[] args) {
        // String age_input = "abc";
        // try {
        // int age = Integer.parseInt(age_input);
        // if (age >= 18) {
        // System.out.println("You can vote!");
        // } else {
        // System.out.println("Sorry, you can't vote yet.");
        // }
        // } catch (NumberFormatException ex) {
        // System.err.println("Invalid input. '" + age_input + "' is not a valid
        // integer.");
        // }
        /*
         * output:
         * Invalid input. 'abc' is not a valid integer.
         */
        // ------------------
        String age_input = "abc";
        try {
            int age = Integer.parseInt(age_input);
            if (age >= 18) {
                System.out.println("You can vote!");
            } else {
                System.out.println("Sorry, you can't vote yet.");
            }
        } catch (NumberFormatException ex) {
            System.err.println("Invalid input. '" + age_input + "' is not a valid integer.");
        } finally {
            System.out.println("This code will always be run, even if an exception is thrown");
        }
        /*
         * output:
         * Invalid input. 'abc' is not a valid integer.
         * This code will always be run, even if an exception is thrown
         */

    }
}
