import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class String_comparison {
    // String Comparison/perbandingan String

    // Bandingkan dua kasus String yang mengabaikan:
    // "School".equalsIgnoreCase("school"); // true

    // jangan gunakan
    // text1.toLowerCase().equals(text2.toLowerCase());

    /*
     * Bahasa memiliki aturan berbeda untuk mengubah huruf besar dan kecil. Kata 'I'
     * akan diubah menjadi 'i' dalam bahasa Inggris. Tapi di
     * Bahasa Turki 'aku' menjadi 'ı'. Jika Anda harus menggunakan toLowerCase()
     * gunakan kelebihan yang mengharapkan Locale:
     * String.toLowerCase(Locale).
     */

    // Membandingkan dua String dengan mengabaikan perbedaan kecil:
    /*
     * Collator collator = Collator.getInstance(Locale.GERMAN);
     * collator.setStrength(Collator.PRIMARY);
     * collator.equals("Gärten", "gaerten"); // return true
     * 
     */

    // Urutkan String dengan mengikuti urutan bahasa alami, abaikan huruf
    // besar/kecil (gunakan kunci susunan untuk:
    /*
     * String[] texts = new String[] {"Birne", "äther", "Apfel"};
     * Collator collator = Collator.getInstance(Locale.GERMAN);
     * collator.setStrength(Collator.SECONDARY); // ignore case
     * Arrays.sort(texts, collator::compare); // will return {"Apfel", "äther",
     * "Birne"}
     */

    public static void main(String[] args) throws Exception {
        // Membandingkan "School" dan "school" dengan mengabaikan perbedaan huruf
        // besar-kecil
        // boolean result = "School".equalsIgnoreCase("school");

        // Menampilkan hasil
        // System.out.println("Hasil perbandingan: " + result); // Hasil Perbandingan:
        // "true"
        // -----------------------------
        // Collator collator = Collator.getInstance(Locale.GERMAN);
        // collator.setStrength(Collator.PRIMARY);

        // boolean isEqual = collator.equals("Gärten", "gaerten");
        // System.out.println("Are 'Gärten' and 'gaerten' equal? " + isEqual);
        /*
         * output:
         * Are 'Gärten' and 'gaerten' equal? false
         */
        // -----------------------------
        String[] texts = new String[] { "Birne", "äther", "Apfel" };
        Collator collator = Collator.getInstance(Locale.GERMAN);
        collator.setStrength(Collator.SECONDARY); // ignore case
        Arrays.sort(texts, collator::compare); // will return {"Apfel", "äther", "Birne"}

        // Menampilkan hasil pengurutan
        System.out.println("Hasil pengurutan:");
        for (String text : texts) {
            System.out.println(text);
        }

        /*
         * output:
         * Hasil pengurutan:
         * Apfel
         * äther
         * Birne
         */
    }
}
