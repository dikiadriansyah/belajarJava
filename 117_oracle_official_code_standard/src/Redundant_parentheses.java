public class Redundant_parentheses {
    // Redundant Parentheses/Tanda Kurung Berlebihan

    /*
     * return flag ? "yes" : "no";
     * String cmp = (flag1 != flag2) ? "not equal" : "equal";
     * // Don't do this
     * return (flag ? "yes" : "no");
     */

    /*
     * 1. Tanda kurung pengelompokan yang berlebihan (yaitu tanda kurung yang tidak
     * mempengaruhi evaluasi) dapat digunakan jika tanda kurung tersebut
     * meningkatkan keterbacaan.
     * 2. Tanda kurung pengelompokan yang berlebihan biasanya tidak disertakan dalam
     * ekspresi pendek yang melibatkan operator umum namun disertakan dalam ekspresi
     * yang lebih panjang atau ekspresi yang melibatkan operator yang prioritas dan
     * asosiatifnya tidak jelas tanpa tanda kurung. Ekspresi ternary dengan kondisi
     * nontrivial termasuk dalam ekspresi terner.
     * 3. Seluruh ekspresi setelah kata kunci return tidak boleh diapit tanda
     * kurung.
     */

    public static void main(String[] args) throws Exception {
        boolean flag = true; // Ganti nilai sesuai kebutuhan Anda
        boolean flag1 = true; // Ganti nilai sesuai kebutuhan Anda
        boolean flag2 = false; // Ganti nilai sesuai kebutuhan Anda

        // Pernyataan kondisional pertama
        String result1 = flag ? "yes" : "no";
        System.out.println("Result 1: " + result1); // Output: yes jika flag bernilai true, no jika flag bernilai false

        // Pernyataan kondisional kedua
        String cmp = (flag1 != flag2) ? "not equal" : "equal";
        System.out.println("Result 2: " + cmp); // Output: not equal jika flag1 dan flag2 tidak sama, equal jika flag1
                                                // dan flag2 sama
    }
}
