import java.util.Locale;
import java.util.Scanner;

public class ChangingTheCaseOfCharactersWithinAString {
    public static void main(String[] args) {
        // Tipe String menyediakan dua metode untuk mengonversi string antara uppercase
        // dan lower case:
        // toUpperCase untuk mengubah semua karakter menjadi huruf besar
        // toLowerCase untuk mengubah semua karakter menjadi huruf kecil

        // kedua metode ini mengembalikan string yg dikonversi sebagai new String
        // instances: objek String asli tidak dimodifikasi karena String tidak dapat
        // diubah di java. Lihat ini untuk informasi lebih lanjut tentang
        // kekekalan(immutability) : Immutability of Strings in
        // Java(http://stackoverflow.com/questions/1552301/immutability-of-strings-in-java)
        String perkenalan = "Assalamualaikum Perkenalkan Teman Semua ";
        String besar = perkenalan.toUpperCase();
        String kecil = perkenalan.toLowerCase();
        // System.out.println(perkenalan); // Assalamualaikum Perkenalkan Teman Semua
        // System.out.println(besar); // ASSALAMUALAIKUM PERKENALKAN TEMAN SEMUA
        // System.out.println(kecil); // assalamualaikum perkenalkan teman semua

        // Karakter non-abjad, seperti angka(digits) dan tanda baca(punctuation marks),
        // tidak terpengaruh oleh metode ini. Perhatikan bahwa metode ini mungkin juga
        // salah menangani karakter Unicode tertentu dalam kondisi tertentu.

        // catatan:
        // Metode ini sensitif terhadap lokal, dan dapat menghasilkan hasil yang tidak
        // diharapkan jika digunakan pada string yang dimaksudkan untuk ditafsirkan
        // independen dari lokal. Contohnya adalah pengidentifikasi bahasa pemrograman,
        // protocol keys, dan tag HTML.

        // misalnya, "TITLE".toLowerCase() dalam bahasa turki mengembalikan "tItle",
        // dengan ı (\u0131) is the LATIN SMALL
        // LETTER DOTLESS I character.

        // Untuk mendapatkan hasil yang benar untuk string yang tidak sensitif lokal,
        // berikan Locale.ROOT sebagai parameter ke metode konversi kasus yang sesuai
        // (mis. toLowerCase(Locale.ROOT) atau toUpperCase(Locale.ROOT)).

        // Meskipun menggunakan Locale.ENGLISH juga benar untuk sebagian besar kasus,
        // cara invarian bahasa adalah Locale.ROOT.

        // Daftar detail Unicode Characters yang memerlukan casing khusus dapat
        // ditemukan di situs web Unicode Consortium.

        // Mengubah kasus karakter tertentu dalam string ASCII(Changing case of a
        // specific character within an ASCII string):
        // Untuk mengubah kasus karakter tertentu dari string ASCII, algoritma berikut
        // dapat digunakan:
        // langkah:
        // 1. Declare a string
        // 2. Input the string
        // 3. Convert the string into a character array.
        // 4. Input the character that is to be searched.
        // 5. Search for the character into the character array.
        // 6. If found,check if the character is lowercase or uppercase.
        // - If Uppercase, add 32 to the ASCII code of the character.
        // - If Lowercase, subtract 32 from the ASCII code of the character.
        // 7. Change the original character from the Character array.
        // 8. Convert the character array back into the string

        // Voila, Kasus karakter diubah.
        // Contoh kode untuk algoritma adalah:
        Scanner scan = new Scanner(System.in);
        System.out.println("masukan string");
        String nx = scan.next();
        char[] a = nx.toCharArray();
        System.out.println("Masukan karakter yg anda cari");
        System.out.println(nx);
        String c = scan.next();
        char d = c.charAt(0);

        for (int i = 0; i <= nx.length(); i++) {
            if (a[i] == d) {

                if (d >= 'a' && d <= 'z') {
                    d -= 32;
                } else if (d >= 'A' && d <= 'Z') {
                    d += 32;
                }
                a[i] = d;
                break;
            }
        }

        nx = String.valueOf(a);
        System.out.println(nx);
        // output: aYam
    }
}
