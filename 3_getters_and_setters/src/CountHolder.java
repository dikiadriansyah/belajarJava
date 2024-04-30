public class CountHolder {
    // why use getter and setter? mengapa menggunakan pengambil dan penyetel?
    // pertimbangkan kelas dasar yang berisi objek dengan getter dan setter di java:

    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int c) {
        count = c;
    }

    // kami tidak dapat mengakses variabel hitungan(count) karena bersifat
    // peribadi(private). tapi kita bisa mengakses getCount() dan SetCount(int c)
    // metode karena mereka publik/public.
    // bagi sebagian orang, ini mungkin menimbulkan pertanyaan; mengapa
    // memperkenalkan perantara? mengapa tidak membuat mereka diperhitungkan secara
    // publik saja?
    // public class CountHolder {
    // public int count = 0;
    // }

    // untuk semua maksud dan tujuan, kedunaya persis sama, dari segi
    // fungsionalitas. perbedaan antara mereka adalah kemungkinan diperpanjang.
    // pertimbangkan apa yang dikatakan setiap kelas:
    // first: "saya punya metode yang akan memberi anda nilai int, dan metode yang
    // akan menetapkan nilai itu ke int lain"
    // second: "Aku punya int yang bisa kamu atur dan dapatkan sesukamu"

    // ini mungkin terdengar serupa, tapi yang pertama sebenernya lebih dijaga
    // sifatnya; itu hanya memungkinkan anda berinteraksi dengan sifat internalnya
    // seperti yang ditentukan.
    // ini meninggalkan bola di lapangannya; ia dapat memilih bagaimana interaksi
    // internal terjadi.
    // yang kedua telah mengekspos implementasi internal secara eksternal, dan
    // sekarang tidak hanya rentan terhadap pengguna eksternal, tapi dalam kasus
    // API, berkomitmen untuk mempertahankan implementasi tersebut(atau merilis API
    // yang tidak kompatibel dengan versi sebelumnya).
    // mari pertimbangkan jika kita ingin menyinkronkan akses untuk mengubah dan
    // mengakses hitungan. yang pertama, ini sederhana:
    // public class CountHolder {
    // private int count = 0;
    // public synchronized int getCount() { return count; }
    // public synchronized void setCount(int c) { count = c; }
    // }

    // tetapi dalam contoh kedua, ini sekarang hampir tidak mungkin tanpa melalui
    // dan memodifikasi setiap tempat variabel hitungan di referensikan.
    // lebih buruk lagi, jika ini adalah item yang anda sediakan di perpustakaan
    // untuk dikonsumsi oleh orang lain, anda tidak memiliki cara untuk melakukan
    // modifikasi tersebut dan terpaksa membuat pilihan sulit yang disebutkan
    // diatas.

    // Jadi itu menimbulkan pertanyaan; apakah variabel publik pernah menjadi hal
    // yang baik (atau, setidaknya, tidak jahat)?
    // Saya tidak yakin. Di satu sisi, Anda dapat melihat contoh variabel publik
    // yang telah teruji oleh waktu (IE: variabel keluar yang dirujuk di
    // System.out).
    // disisi lain, menyediakan variabel publik tidak memberikan manfaat di luar
    // biaya overhead yang sangat minim dan potensi pengurangan kata-kata. panduan
    // saya disini adalah, jika anda berencana membuat variabel menjadi publik, anda
    // harus menilainya berdasarkan kriteria ini dengan prasangka ekstrim:
    // 1. variabel seharusnya tidak memiliki alasa untuk berubah dalam
    // implementasinya. ini adalah sesuatu yang sangat mudah untuk dikacaukan (dan,
    // bahkan jika anda melakukan dengan benar, persyaratan dapat berubah), itulah
    // sebabnya getter/setter adalah pendekatan umum. jika anda akan memiliki
    // variabel publik, ini benar-benar perlu dipikirkan matang-matang, terutama
    // jika dirilis di library/framework/API

    // 2. variabel perlu direferensikan cukup sering sehingga keuntungan minimal
    // dari mengurangi verbositas menjaminnya. saya bahkan tidak berpikir biaya
    // overhead untuk menggunakan metode versus referensi langsung seharusnya
    // dipertimbangkan disini. itu terlalu diabaikan untuk apa yang saya perkirakan
    // secara konservatif menjadi 99,9% dari aplikasi.

    // Mungkin ada lebih dari yang belum saya pertimbangkan di atas kepala saya.
    // Jika Anda ragu, selalu gunakan getter/setter.

}
