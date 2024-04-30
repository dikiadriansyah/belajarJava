public class findingAStringWithinAnotherString {
    public static void main(String[] args) {
        // Untuk memeriksa apakah String a tertentu terkandung dalam String b atau
        // tidak, kita dapat menggunakan metode ini String.contains() dengan sintaks
        // berikut:
        // b.contains(a); // Return true if a is contained in b, false otherwise

        // Metode String.contains() dapat digunakan untuk memverifikasi apakah
        // CharSequence dapat ditemukan di dalam String. Metode mencari String a di
        // String b dengan cara yang peka terhadap huruf besar-kecil(case sensitive).

        String perkenalan = "Selamat pagi teman semua";
        String perkenalan2 = "Selamat pagi teman semua";
        String perkenalan3 = "sElamAt Pagi Teman semua";
        // System.out.println(perkenalan.contains(perkenalan2)); // true
        // System.out.println(perkenalan.contains(perkenalan3)); // false

        // -------------------------
        // Untuk menemukan posisi yang tepat di mana sebuah String dimulai di dalam
        // String lain, gunakan String.indexOf():
        int l = perkenalan.indexOf('l');
        int mua = perkenalan.indexOf("mua");
        int o = perkenalan.indexOf('o');
        int pagi = perkenalan.indexOf("PaGi");
        // System.out.println(l); // 2
        // System.out.println(mua); // 21
        // System.out.println(o); // o is -1 because 'o' was not found in string
        // perkenalan
        // System.out.println(pagi); // pagi is -1 because 'PaGi' was not found in
        // string perkenalan

        // Metode String.indexOf() mengembalikan indeks pertama dari sebuah char atau
        // String di String lain. Method return -1 jika tidak ditemukan.

        // catatan: String.indexOf() adalah metode peka huruf besar kecil(case
        // sensitive)

        // Contoh pencarian yang mengabaikan kasus:
        String str1 = "Hello World";
        String str2 = "wOr";
        str1.indexOf(str2); // -1
        str1.toLowerCase().contains(str2.toLowerCase()); // true
        str1.toLowerCase().indexOf(str2.toLowerCase()); // 6
    }
}
