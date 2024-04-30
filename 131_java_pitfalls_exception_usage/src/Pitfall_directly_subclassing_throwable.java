public class Pitfall_directly_subclassing_throwable {
    // Pitfall - Directly subclassing `Throwable`/Pitfall - Mensubklasifikasikan
    // `Throwable` secara langsung

    /*
     * Throwable memiliki dua subkelas langsung, Exception dan Error. Meskipun
     * dimungkinkan untuk membuat kelas baru yang diperluas
     * Dapat dibuang secara langsung, hal ini tidak disarankan karena banyak
     * aplikasi berasumsi hanya ada Exception dan Kesalahan.
     * 
     * Lebih penting lagi, tidak ada manfaat praktis untuk mensubklasifikasikan
     * Throwable secara langsung, karena kelas yang dihasilkan, pada dasarnya,
     * hanya pengecualian yang dicentang. Subclassing Exception malah akan
     * menghasilkan perilaku yang sama, namun akan lebih jelas
     * sampaikan maksudmu.
     */

}
