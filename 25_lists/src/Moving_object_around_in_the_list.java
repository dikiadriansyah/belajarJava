import java.util.*;

public class Moving_object_around_in_the_list {
    // Moving objects around in the list

    public static void main(String[] args) {
        /*
         * Kelas Collections memungkinkan Anda untuk memindahkan objek dalam daftar
         * menggunakan berbagai metode (ls adalah Daftar):
         * 
         * Reversing a list:
         * Collections.reverse(ls);
         */
        // Rotating positions of elements in a list
        /*
         * Metode rotasi memerlukan argumen bilangan bulat. Ini adalah berapa banyak
         * tempat untuk memindahkannya sepanjang garis. Contohnya di bawah ini:
         */
        List<String> ls = new ArrayList<String>();
        ls.add(" how");
        ls.add(" are");
        ls.add(" you?");
        ls.add("hello,");
        Collections.rotate(ls, 1);
        for (String line : ls) {
            System.out.print(line);
        }
        System.out.println();
        /*
         * output:
         * hello, how are you?
         */

        // Shuffling elements around in a list
        /*
         * Dengan menggunakan daftar yang sama di atas, kita dapat mengacak elemen dalam
         * daftar:
         */

        // Collections.shuffle(ls);
        /*
         * Kita juga bisa memberinya objek java.util.Random yang digunakan untuk
         * menempatkan objek secara acak di suatu tempat:
         */

        Random random = new Random(12);
        Collections.shuffle(ls, random);
        // Tampilkan hasil
        for (String str : ls) {
            System.out.print(str);
        }
        /*
         * output:
         * howhello, you? are
         */
    }
}
