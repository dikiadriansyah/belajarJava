public class gettingTheLengthOfAString {
    public static void main(String[] args) {
        // untuk mendapatkan panjang objek string, panggil metode length() diatasnya.
        // panjangnya sama dengan jumlah UTF-16 code unit(chars) dalam string.
        // String perkenalan = "Assalamualaikum, Perkenalkan Nama saya Dhiki";
        // System.out.println(perkenalan.length());
        // output: 44
        // karena tanda koma dan spasi juga dihitung

        // char dalam sebuah String adalah nilai UTF-16. Unicode codepoint yang
        // nilainya ≥ 0x1000 (misalnya, sebagian besar emoji) menggunakan dua posisi
        // karakter. Untuk menghitung jumlah Unicode codepoints dalam sebuah String,
        // terlepas dari apakah setiap titik kode cocok dengan nilai UTF-16 char,
        // Anda dapat menggunakan metode codePointCount:
        // int panjang = perkenalan.codePointCount(0, perkenalan.length());
        // System.out.println(panjang); // output: 44

        // Anda juga dapat menggunakan Stream of codepoints, pada Java 8
        // int panjang = (int) perkenalan.codePoints().count();
        // System.out.println(panjang); // output: 44

        // --------------
        // coba menghitung panjang array
        String[] buah = { "Apel", "Jeruk", "Bluberi", "Ceri", "Duku" };
        System.out.println(buah.length);
        // output: 5

    }
}
