public class Escape_characters {
    // Escape Characters/Karakter Pelarian

    // Umum
    /*
     * Untuk menggunakan karakter khusus ekspresi reguler (?+| dll.) dalam arti
     * literalnya, karakter tersebut harus di-escape. Dalam ekspresi reguler umum
     * hal ini dilakukan dengan garis miring terbalik \. Namun, karena memiliki arti
     * khusus dalam Java Strings, Anda harus menggunakan garis miring terbalik ganda
     * \\.
     * 
     * Kedua contoh ini tidak akan berfungsi:
     * "???".replaceAll ("?", "!"); //java.util.regex.PatternSyntaxException
     * "???".replaceAll ("\?", "!"); //Invalid escape sequence
     */

    // Contoh ini berhasil
    // "???".replaceAll ("\\?", "!"); //"!!!"

    // Splitting a Pipe Delimited String/Memisahkan String yang Dibatasi Pipa
    // Ini tidak mengembalikan hasil yang diharapkan:
    // "a|b".split ("|"); // [a, |, b]

    // Ini mengembalikan hasil yang diharapkan:
    // a|b".split ("\\|"); // [a, b]

    // Escaping backslash \Menghindari garis miring terbalik \
    // Ini akan memberikan kesalahan:
    // "\\".matches("\\"); // PatternSyntaxException
    // "\\".matches("\\\"); // Syntax Error

    // Ini bekerja:
    // "\\".matches("\\\\"); // true

    public static void main(String[] args) {
        // String result = "???".replaceAll("\\?", "!");
        // System.out.println(result); // Output: "!!!"
        // -----------------------------------
        // String input = "a|b";
        // String[] hasil = input.split("\\|");

        // System.out.print("[");
        // for (int i = 0; i < hasil.length; i++) {
        // System.out.print(hasil[i]);
        // if (i < hasil.length - 1) {
        // System.out.print(", ");
        // }
        // }
        // System.out.println("]");
        // output: [a,b]

        // ---------------------
        String input = "\\\\";
        boolean result = input.matches("\\\\");
        System.out.println(result); // Output: false
    }
}
