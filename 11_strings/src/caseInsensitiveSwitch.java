public class caseInsensitiveSwitch {
    public static void main(String[] args) {
        // switch itu sendiri tidak dapat diparameterisasi menjadi case-insensitive,
        // tetapi jika benar-benar diperlukan, dapat berperilaku tidak sensitif terhadap
        // input string dengan menggunakan toLowerCase() atau toUpperCase:

        String perkenalan = "Assalamualaikum";
        switch (perkenalan.toLowerCase()) {
            case "hai":
                System.out.println("Hai teman semua");
                break;
            case "assalamualaikum":
                System.out.println("Assalamualaikum teman semua");
                break;
            default:
                System.out.println("tidak menemukan kalimat");
        }

        // output:
        // assalamualaikum teman semua

        // Awas
        // - locale dapat memengaruhi bagaimana perubahan kasus terjadi!
        // - harus berhati-hati agar tidak ada karakter huruf besar(uppercase) di labels
        // - itu
        // tidak akan pernah dieksekusi
    }
}
