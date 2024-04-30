public class Not_matching_a_given_string {
    // Not matching a given string/Tidak cocok dengan string tertentu

    /*
     * Untuk mencocokkan sesuatu yang tidak mengandung string tertentu, seseorang
     * dapat menggunakan pandangan ke depan negatif:
     * Regex syntax: (?!string-to-not-match)
     */

    // contoh:
    /*
     * //not matching "popcorn"
     * String regexString = "^(?!popcorn).*$";
     * System.out.println("[popcorn] " + ("popcorn".matches(regexString) ?
     * "matched!" : "nope!"));
     * System.out.println("[unicorn] " + ("unicorn".matches(regexString) ?
     * "matched!" : "nope!"));
     */

    // hasil:
    /*
     * [popcorn] nope!
     * [unicorn] matched!
     */

    public static void main(String[] args) {
        String regexString = "^(?!popcorn).*$";
        System.out.println("[popcorn] " + ("popcorn".matches(regexString) ? "matched!" : "nope!"));
        System.out.println("[unicorn] " + ("unicorn".matches(regexString) ? "matched!" : "nope!"));
        // hasil:
        /*
         * [popcorn] nope!
         * [unicorn] matched!
         */
    }
}
