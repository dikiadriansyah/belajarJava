import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.sound.midi.Patch;

public class splittingStrings {
    public static void main(String[] args) {
        // Anda dapat memisahkan String pada karakter pembatas tertentu atau Regular
        // Expression, Anda dapat menggunakan String.split() metode yang memiliki
        // signature berikut:
        // public String[] split(String regex)

        // Perhatikan bahwa karakter pembatas atau ekspresi reguler akan dihapus dari
        // String Array yang dihasilkan

        // Contoh menggunakan karakter pembatas:
        String lineFromCsvFile = "Diki;Jakarta;12640;12642";
        String[] dataCells = lineFromCsvFile.split(";");
        // System.out.println(Arrays.toString(dataCells));
        // Output: [Diki, Jakarta, 12640, 12642]

        // contoh menggunakan regular expression:
        String lineFromInput = "Apa  yang anda    butuhkan       dari saya?";
        String[] words = lineFromInput.split("\\s+"); // 1 atau lebih space chars
        // System.out.println(Arrays.toString(words));
        // output: [Apa, yang, anda, butuhkan, dari, saya?]

        // Anda bahkan dapat langsung membagi sebuah String literal:
        String[] firstname = "Dhiki, Nia, Farah, Alisia".split(", ");
        // System.out.println(Arrays.toString(firstname));
        // [Dhiki, Nia, Farah, Alisia]

        // Peringatan:
        // Jangan lupa bahwa parameter selalu diperlakukan sebagai ekspresi reguler.
        // "aaa.bbb".split("."); // This returns an empty array

        // Pada contoh sebelumnya. diperlakukan sebagai karakter pengganti ekspresi
        // reguler yang cocok dengan karakter apa pun, dan karena setiap
        // karakter adalah pembatas, hasilnya adalah array kosong.

        // Splitting based on a delimiter which is a regex meta-character
        // Karakter berikut dianggap khusus (alias meta-karakter) di regex
        // < > - = ! ( ) [ ] { } \ ^ $ | ? * + .

        // Untuk memisahkan string berdasarkan salah satu pembatas di atas, Anda harus
        // menghindarinya menggunakan \\ atau menggunakan Pattern.quote():

        // - gunakan Pattern.quote()
        String huruf = "a|b|c|d";
        String regex = Pattern.quote("|");
        String[] arr = huruf.split(regex);
        // System.out.println(Arrays.toString(arr)); // [a,b,c,d]

        // Escaping the special characters:

        String[] arr2 = huruf.split("\\|");
        // System.out.println(Arrays.toString(arr2)); // [a,b,c,d]

        // Split removes empty values
        // split(delimiter) secara default menghapus string kosong yang tertinggal dari
        // larik hasil. Untuk mematikan mekanisme ini kita perlu untuk menggunakan versi
        // split (delimiter, limit) yang kelebihan beban dengan batas yang disetel ke
        // nilai negatif seperti.
        // String[] split = data.split("\\|", -1);

        // split(regex) internally returns result of split(regex, 0).

        // Parameter limit mengontrol berapa kali pola diterapkan dan karena itu
        // memengaruhi panjang array yang dihasilkan.
        // Jika limit n lebih besar dari nol maka pola akan diterapkan paling banyak n -
        // 1 kali, panjang array tidak lebih besar dari n, dan entri terakhir array akan
        // berisi semua input di luar pembatas terakhir yang cocok.
        // Jika n negatif, maka pola akan diterapkan sebanyak mungkin dan array dapat
        // memiliki panjang berapa pun.
        // Jika n adalah nol maka pola akan diterapkan sebanyak mungkin, array dapat
        // memiliki panjang berapa pun, dan mengekor string kosong akan dibuang.

        // Splitting with a StringTokenizer
        // Selain metode split(), String juga dapat dipisah menggunakan StringTokenizer.

        // StringTokenizer bahkan lebih ketat daripada String.split(), dan juga sedikit
        // lebih sulit untuk digunakan. Ini pada dasarnya dirancang untuk mengeluarkan
        // token yang dibatasi oleh sekumpulan karakter tetap (diberikan sebagai
        // String). Setiap karakter akan bertindak sebagai pemisah. Karena pembatasan
        // ini, ini dua kali lebih cepat dari String.split().

        // Kumpulan karakter default adalah spasi kosong (\t\n\r\f). Contoh berikut akan
        // mencetak setiap kata secara terpisah.

        String str = "pada siang hari memiliki suhu sangat panas";
        StringTokenizer tkn = new StringTokenizer(str);
        // while (tkn.hasMoreTokens()) {
        // System.out.println(tkn.nextToken());
        // }
        // output:
        // pada
        // siang
        // hari
        // memiliki
        // suhu
        // sangat
        // panas

        // Anda dapat menggunakan set karakter yang berbeda untuk pemisahan
        String str2 = "malam hari";

        // In this case character `l` and `r` will be used as delimiters
        StringTokenizer tokenizer = new StringTokenizer(str2, "lr");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        // output:
        // ma
        // am ha
        // i
    }
}
