import java.util.*;

public class Creating_your_own_iterable {
    // Creating your own Iterable/Membuat Iterable Anda sendiri

    /*
     * Untuk membuat Iterable Anda sendiri seperti halnya antarmuka apa pun, Anda
     * cukup mengimplementasikan metode abstrak di antarmuka. Untuk Iterable hanya
     * ada satu yang disebut iterator(). Tapi tipe pengembaliannya Iterator sendiri
     * merupakan antarmuka dengan tiga metode abstrak. Anda dapat mengembalikan
     * iterator yang terkait dengan beberapa koleksi atau membuat implementasi
     * kustom Anda sendiri:
     * 
     * public static class Alphabet implements Iterable<Character> {
     * 
     * @Override
     * public Iterator<Character> iterator() {
     * return new Iterator<Character>() {
     * char letter = 'a';
     * 
     * @Override
     * public boolean hasNext() {
     * return letter <= 'z';
     * }
     * 
     * @Override
     * public Character next() {
     * return letter++;
     * }
     * 
     * @Override
     * public void remove() {
     * throw new
     * UnsupportedOperationException("Doesn't make sense to remove a letter");
     * }
     * };
     * }
     * }
     */

    // untuk digunakan:
    /*
     * public static void main(String[] args) {
     * for(char c : new Alphabet()) {
     * System.out.println("c = " + c);
     * }
     * }
     */

    /*
     * new Iterator harus datang dengan status yang menunjuk ke item pertama,
     * setiap panggilan ke berikutnya memperbarui statusnya untuk menunjuk ke item
     * berikutnya. hasNext() memeriksa apakah iterator berada di akhir. Jika
     * iterator terhubung ke koleksi yang dapat dimodifikasi, maka metode remove()
     * opsional dari iterator mungkin diterapkan untuk menghapus item yang saat ini
     * ditunjuk dari koleksi yang mendasarinya.
     */

    public static class Alphabet implements Iterable<Character> {
        @Override
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                char letter = 'a';

                @Override
                public boolean hasNext() {
                    return letter <= 'z';
                }

                @Override
                public Character next() {
                    return letter++;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Doesn't make sense to remove a letter");
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        for (char c : new Alphabet()) {
            System.out.println("c = " + c);
        }
        /*
         * output:
         * c = a
         * c = b
         * c = c
         * c = d
         * c = e
         * c = f
         * c = g
         * c = h
         * c = i
         * c = j
         * c = k
         * c = l
         * c = m
         * c = n
         * c = o
         * c = p
         * c = q
         * c = r
         * c = s
         * c = t
         * c = u
         * c = v
         * c = w
         * c = x
         * c = y
         * c = z
         */
    }
}
