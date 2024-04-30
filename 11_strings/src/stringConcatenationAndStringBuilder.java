import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class stringConcatenationAndStringBuilder {
    public static void main(String[] args) {
        // Penggabungan string dapat dilakukan dengan menggunakan operator +. Misalnya:
        // String Firstname = "Dhiki";
        // String Midlename = "Adriansyah";
        // String Lastname = "ST";
        // String res = Firstname + Midlename + Lastname;
        // System.out.println(res); // DhikiAdriansyahST

        // Biasanya implementasi compiler akan melakukan penggabungan di atas
        // menggunakan metode yang melibatkan StringBuilder di bawah tenda.
        // Ketika dikompilasi, kode akan terlihat seperti di bawah ini:
        // StringBuilder txt = new StringBuilder("Merah");
        // String r = txt.append("kuning").append("biru").toString();
        // System.out.println(r); // merahkuningbiru

        // -----------------------------
        // StringBuilder memiliki beberapa metode kelebihan beban untuk menambahkan tipe
        // yang berbeda, misalnya, untuk menambahkan int bukannya sebuah String.
        // Misalnya, implementasi dapat mengonversi:
        // String result = Firstname + Midlename + 14;
        // System.out.println(result); // DhikiAdriansyah14

        // untuk mengikuti:
        // StringBuilder nama = new StringBuilder("Dhiki");
        // String hasil = nama.append("Adriansyah").append(14).toString();
        // System.out.println(hasil); // DhikiAdriansyah14

        // Contoh di atas mengilustrasikan operasi penggabungan sederhana yang secara
        // efektif dilakukan di satu tempat dalam kode.
        // Penggabungan melibatkan satu instance dari StringBuilder. Dalam beberapa
        // kasus, penggabungan dilakukan di cara kumulatif seperti dalam satu lingkaran:
        // String[] arr = { "Apel", "Jeruk", "Bluberi" };
        // String re = "";
        // for (int i = 0; i < arr.length; i++) {
        // re += extractElement(arr[i]);
        // }
        // System.out.println(re);
        // Dalam kasus seperti itu, pengoptimalan kompiler biasanya tidak diterapkan,
        // dan setiap iterasi akan membuat new StringBuilder
        // obyek. Ini dapat dioptimalkan dengan mengubah kode secara eksplisit untuk
        // menggunakan StringBuilder tunggal:
        String[] arr = { "Apel", "Jeruk", "Bluberi" };

        StringBuilder result2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result2.append(extractElement(arr[i]));
        }
        // System.out.println(result2);

        // StringBuilder akan diinisialisasi dengan ruang kosong yang hanya terdiri dari
        // 16 karakter. Jika Anda tahu sebelumnya bahwa Anda akan melakukannya
        // membangun string yang lebih besar, akan bermanfaat untuk menginisialisasi
        // dengan ukuran yang cukup terlebih dahulu, sehingga buffer internal
        // tidak perlu diubah ukurannya:

        // StringBuilder buf = new StringBuilder(30); // default adalah 16 characters
        // buf.append("0123456789");
        // buf.append("0123456789"); // Akan menyebabkan realokasi buffer internal jika
        // tidak
        // String result3 = buf.toString(); // Menghasilkan salinan string sebanyak 20
        // karakter
        // System.out.println(result3); // 01234567890123456789

        // Jika Anda menghasilkan banyak string, disarankan untuk menggunakan kembali
        // StringBuilders:
        // StringBuilder buf = new StringBuilder(100);
        // try (FileWriter outputfile = new FileWriter("output.txt")) {
        // for (int i = 0; i < 100; i++) {
        // buf.setLength(0); // empty buffer
        // buf.append("Ini adalah baris ").append(i).append('\n');
        // outputfile.write(buf.toString());
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // ---------------------------------
        // Jika (dan hanya jika) banyak utas menulis ke buffer yang sama, gunakan
        // StringBuffer, yang merupakan versi tersinkronisasi dari
        // StringBuilder. Tetapi karena biasanya hanya satu utas yang menulis ke buffer,
        // biasanya lebih cepat menggunakan StringBuilder
        // tanpa sinkronisasi

        // menggunakan contact() method:
        // String kalimatSatu = "Hai";
        // String kalimatDua = "Dunia";
        // String hasil3 = kalimatSatu.concat(kalimatDua);
        // System.out.println(hasil3); // hai dunia

        // Ini mengembalikan string baru yaitu kalimatSatu dengan kalimatDua ditambahkan
        // di akhir. Anda juga dapat menggunakan metode concat()
        // dengan string literal, seperti pada:
        System.out.println("Nama saya adalah ".concat("Dhiki")); // nama saya adalah dhiki
    }

    public static String extractElement(String element) {
        return element + " ";
    }

    // output: Apel Jeruk Bluberi

}
