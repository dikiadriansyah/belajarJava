public class Pitfall_using_to_test_a_boolean {
    // Pitfall - Using '==' to test a boolean/Kesalahan - Menggunakan '==' untuk
    // menguji boolean

    /*
     * Terkadang seorang programmer Java baru akan menulis kode seperti ini:
     * 
     * public void check(boolean ok) {
     * if (ok == true) { // Note 'ok == true'
     * System.out.println("It is OK");
     * }
     * }
     */

    // Seorang programmer berpengalaman akan menganggapnya kikuk dan ingin menulis
    // ulang sebagai:

    /*
     * public void check(boolean ok) {
     * if (ok) {
     * System.out.println("It is OK");
     * }
     * }
     */

    /*
     * Namun, ada yang lebih salah dengan ok == true daripada kecanggungan
     * sederhana. Pertimbangkan variasi ini:
     * 
     * public void check(boolean ok) {
     * if (ok = true) { // Oooops!
     * System.out.println("It is OK");
     * }
     * }
     * 
     */

    /*
     * Di sini pemrogram salah mengetik == sebagai = ... dan sekarang kode tersebut
     * memiliki bug halus. Ekspresi x = true
     * tanpa syarat menetapkan nilai true pada x dan kemudian mengevaluasinya
     * menjadi true. Dengan kata lain, metode pemeriksaan sekarang akan mencetak
     * "Tidak apa-apa" apa pun parameternya.
     * 
     * Pelajaran di sini adalah untuk menghilangkan kebiasaan menggunakan == false
     * dan == true. Selain bertele-tele, mereka membuat pengkodean Anda lebih rentan
     * terhadap kesalahan.
     */

    /*
     * Catatan: Alternatif yang mungkin untuk ok == true yang menghindari jebakan
     * adalah dengan menggunakan kondisi Yoda; yaitu meletakkan literal di sisi kiri
     * operator relasional, seperti pada true == ok. Ini berhasil, tetapi sebagian
     * besar pemrogram mungkin setuju bahwa kondisi Yoda terlihat aneh. Tentu saja
     * ok (atau !ok) lebih ringkas dan natural.
     */

    public static void main(String[] args) throws Exception {
        Pitfall_using_to_test_a_boolean box = new Pitfall_using_to_test_a_boolean();

        // Memanggil metode check dengan argumen true
        box.check(true);
        /*
         * output:
         * It is OK
         */

    }

    public void check(boolean ok) {
        if (ok) {
            System.out.println("It is OK");
        }
    }

}
