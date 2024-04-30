public class Wrapping_expressions {
    // Wrapping Expressions/Ekspresi Pembungkus

    /*
     * 1. Jika sebuah baris mendekati batas karakter maksimum, selalu pertimbangkan
     * untuk membaginya menjadi beberapa statements / expressions alih-alih
     * membungkus baris.
     * 2. Break sebelum operator.
     * 3. Break sebelum . dalam panggilan metode berantai.
     */

    public static void main(String[] args) {
        int newMsgs = 5; // Contoh nilai untuk newMsgs

        popupMsg("Inbox notification: You have " + newMsgs + " new messages");
        // output: Inbox notification: You have 5 new messages

    }

    public static void popupMsg(String message) {
        // Implementasi popupMsg() bisa diisi di sini
        System.out.println(message);
    }
}
