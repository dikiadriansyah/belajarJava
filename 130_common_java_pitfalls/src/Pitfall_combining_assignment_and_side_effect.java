public class Pitfall_combining_assignment_and_side_effect {
    // Pitfall: combining assignment and side-effects/Jebakan: menggabungkan
    // penugasan dan efek samping

    /*
     * Kadang-kadang kita melihat pertanyaan StackOverflow Java (dan pertanyaan C
     * atau C++) yang menanyakan sesuatu seperti ini:
     * i += a[i++] + b[i--];
     */

    // mengevaluasi ke ... untuk beberapa keadaan awal yang diketahui dari i, a dan
    // b

    /*
     * Secara umum:
     * untuk Java jawabannya selalu ditentukan1, namun tidak jelas, dan sering kali
     * sulit untuk diketahui
     * untuk C dan C++ jawabannya seringkali tidak ditentukan.
     */

    /*
     * Contoh seperti ini sering digunakan dalam ujian atau wawancara kerja sebagai
     * upaya untuk melihat apakah siswa atau orang yang diwawancarai memahami cara
     * kerja evaluasi ekspresi dalam bahasa pemrograman Java. Hal ini bisa dibilang
     * sah-sah saja
     * sebagai "ujian pengetahuan", tetapi itu tidak berarti Anda harus melakukan
     * ini dalam program nyata.
     * 
     * Sebagai ilustrasi, contoh sederhana berikut ini telah muncul beberapa kali
     * dalam pertanyaan StackOverflow (seperti ini
     * satu). Dalam beberapa kasus, ini tampak sebagai kesalahan nyata dalam kode
     * seseorang.
     */

    /*
     * int a = 1;
     * a = a++;
     * System.out.println(a); // What does this print.
     */

    /*
     * Kebanyakan pemrogram (termasuk pakar Java) yang membaca pernyataan tersebut
     * dengan cepat akan mengatakan bahwa hasilnya adalah 2. Faktanya, hasilnya
     * adalah 1. Untuk penjelasan mendetail tentang alasannya, silakan baca Jawaban
     * ini.
     * 
     * Namun kesimpulan sebenarnya dari contoh ini dan contoh serupa adalah bahwa
     * setiap pernyataan Java yang menetapkan dan memberikan efek samping pada
     * variabel yang sama akan sulit untuk dipahami, dan paling buruk benar-benar
     * menyesatkan. Anda sebaiknya menghindari menulis kode seperti ini.
     */

    /*
     * 1 - potensi masalah modulo dengan Model Memori Java jika variabel atau objek
     * terlihat oleh thread lain.
     */

    public static void main(String[] args) {
        int a = 1;
        a = a++;
        System.out.println(a); // output: 1
    }
}
