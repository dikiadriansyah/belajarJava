public class What_is_the_advantage_of_immutability {
    // What is the advantage of immutability? / Apa keuntungan dari kekekalan?

    /*
     * Keuntungan dari kekekalan hadir dengan konkurensi. Sulit untuk mempertahankan
     * kebenaran pada objek yang bisa berubah, seperti
     * beberapa thread mungkin mencoba mengubah status objek yang sama, menyebabkan
     * beberapa thread melihat status berbeda dari objek yang sama, bergantung pada
     * waktu pembacaan dan penulisan objek tersebut.
     * 
     * Dengan memiliki objek yang tidak dapat diubah, seseorang dapat memastikan
     * bahwa semua thread yang melihat objek tersebut akan melihat keadaan yang
     * sama, karena keadaan objek yang tidak dapat diubah tidak akan berubah.
     */

    public static void main(String[] args) {
    }
}
