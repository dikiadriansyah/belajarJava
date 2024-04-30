public class gettingTheNthCharacterInAString {
    public static void main(String[] args) {
        String perkenalan = "Assalamualaikum, Perkenalan nama saya adalah Dhiki Adriansyah";
        // System.out.println(perkenalan.charAt(0)); // A
        // System.out.println(perkenalan.charAt(16)); // ""
        System.out.println(perkenalan.charAt(perkenalan.length() - 1)); // h

        // Untuk mendapatkan character ke-n dalam sebuah string, cukup panggil charAt(n)
        // pada sebuah String, di mana n adalah indeks dari character yang Anda
        // ingin mengambil kembali

        // Catatan:
        // index n dimulai dari 0, jadi elemen pertama adalah pada n = 0
    }
}
