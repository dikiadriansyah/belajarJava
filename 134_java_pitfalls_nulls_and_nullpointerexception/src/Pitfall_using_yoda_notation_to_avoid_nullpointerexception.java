public class Pitfall_using_yoda_notation_to_avoid_nullpointerexception {
    // Pitfall - Using "Yoda notation" to avoid NullPointerException/Kesalahan -
    // Menggunakan "notasi Yoda" untuk menghindari NullPointerException

    /*
     * Banyak contoh kode yang diposting di StackOverflow menyertakan cuplikan
     * seperti ini:
     * 
     * if ("A".equals(someString)) {
     * // do something
     * }
     */

    /*
     * Ini "prevent" atau "avoid" kemungkinan NullPointerException jika
     * someString bernilai null. Selain itu, dapat dikatakan bahwa
     * 
     * "A".equals(someString)
     */

    // lebih baik dari:
    // someString != null && someString.equals("A")

    /*
     * (Ini lebih ringkas, dan dalam beberapa keadaan mungkin lebih efisien. Namun,
     * seperti yang kami bahas di bawah, ringkas
     * bisa jadi negatif.)
     * 
     * Namun, kendala sebenarnya adalah menggunakan tes Yoda untuk menghindari
     * NullPointerExceptions sebagai kebiasaan.
     * 
     * Saat Anda menulis "A".equals(someString) Anda sebenarnya "memperbaiki" kasus
     * di mana someString ternyata null. Namun seperti yang dijelaskan oleh contoh
     * lain (Perangkap - "Membuat baik" nulls yang tidak terduga), "membuat baik"
     * nilai null dapat berbahaya karena berbagai alasan.
     */

    /*
     * Artinya kondisi Yoda bukanlah "praktik terbaik"1. Kecuali jika nilai null
     * diharapkan, lebih baik biarkan saja
     * NullPointerException terjadi sehingga Anda bisa mendapatkan kegagalan
     * pengujian unit (atau laporan bug). Itu memungkinkan Anda menemukan dan
     * memperbaiki bug yang menyebabkan munculnya null yang tidak terduga/tidak
     * diinginkan.
     * 
     * Kondisi Yoda hanya boleh digunakan jika null diharapkan karena objek yang
     * Anda uji berasal dari API yang didokumentasikan mengembalikan null. Dan bisa
     * dibilang, akan lebih baik jika menggunakan salah satu cara yang kurang
     * menarik dalam mengekspresikan tes karena hal itu membantu menyorot tes nol
     * kepada seseorang yang sedang meninjau tes kode Anda.
     * .
     * 
     * 1 - Menurut Wikipedia: "Praktik pengkodean terbaik adalah seperangkat aturan
     * informal yang dibuat oleh komunitas pengembangan perangkat lunak
     * telah belajar dari waktu ke waktu yang dapat membantu meningkatkan kualitas
     * perangkat lunak.". Menggunakan notasi Yoda tidak mencapai hal ini. Dalam
     * banyak situasi, hal ini memperburuk kode.
     */

    public static void main(String[] args) throws Exception {
        String someString = "A";

        if ("A".equals(someString)) {
            System.out.println("Nilai dari someString adalah A");
            // output: Nilai dari someString adalah A
        }
    }

}
