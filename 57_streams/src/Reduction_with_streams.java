import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.List;

public class Reduction_with_streams {
    // Reduction with Streams / Pengurangan dengan Aliran

    /*
     * Reduksi adalah proses penerapan operator biner ke setiap elemen aliran untuk
     * menghasilkan satu nilai.
     * 
     * Metode sum() dari IntStream adalah contoh pengurangan; itu menerapkan
     * penambahan pada setiap ketentuan Aliran, sehingga menghasilkan satu nilai
     * akhir:
     * 
     * 
     * Ini setara dengan (((1+2)+3)+4)
     * Metode pengurangan pada Aliran memungkinkan seseorang membuat pengurangan
     * khusus. Dimungkinkan untuk menggunakan metode pengurangan menjadi
     * mengimplementasikan metode sum():
     * 
     * IntStream istr;
     * 
     * //Initialize istr
     * OptionalInt istr.reduce((a,b)->a+b);
     * 
     * 
     */

    /*
     * Versi Optional dikembalikan sehingga Streams kosong dapat ditangani dengan
     * tepat.
     * 
     * Contoh pengurangan lainnya adalah menggabungkan Stream<LinkedList<T>> menjadi
     * satu LinkedList<T>:
     * 
     * Stream<LinkedList<T>> listStream;
     * //Create a Stream<LinkedList<T>>
     * Optional<LinkedList<T>> bigList = listStream.reduce((LinkedList<T> list1,
     * LinkedList<T> list2)->{
     * LinkedList<T> retList = new LinkedList<T>();
     * retList.addAll(list1);
     * retList.addAll(list2);
     * return retList;
     * });
     * 
     * Anda juga dapat memberikan elemen identitas. Misalnya, elemen identitas
     * penjumlahan adalah 0, seperti x+0==x. Untuk
     * perkalian, unsur identitasnya adalah 1, karena x*1==x. Dalam kasus di atas,
     * elemen identitasnya kosong
     * LinkedList<T>, karena jika Anda menambahkan daftar kosong ke daftar lain,
     * daftar yang Anda "adding" tidak berubah:
     * 
     * Stream<LinkedList<T>> listStream;
     * //Create a Stream<LinkedList<T>>
     * LinkedList<T> bigList = listStream.reduce(new LinkedList<T>(), (LinkedList<T>
     * list1, LinkedList<T>
     * list2)->{
     * LinkedList<T> retList = new LinkedList<T>();
     * retList.addAll(list1);
     * retList.addAll(list2);
     * return retList;
     * });
     * 
     * 
     */

    /*
     * Perhatikan bahwa ketika elemen identitas disediakan, nilai yang dikembalikan
     * tidak dibungkus dalam Opsional—jika dipanggil pada
     * aliran kosong, reduce() akan mengembalikan elemen identitas.
     * 
     * Operator binernya juga harus associative, artinya (a+b)+c==a+(b+c). Hal ini
     * karena unsur-unsurnya dapat direduksi dalam urutan apa pun. Misalnya,
     * pengurangan penjumlahan di atas dapat dilakukan seperti ini:
     * 
     */

    /*
     * Pengurangan ini setara dengan penulisan ((1+2)+(3+4)). Properti asosiatif
     * juga memungkinkan Java untuk mengurangi Streaming secara paralel—sebagian
     * Streaming dapat dikurangi oleh masing-masing prosesor, dengan pengurangan
     * yang menggabungkan hasil dari masing-masing prosesor di bagian akhir.
     */

    public static void main(String[] args) {

        // Contoh penggunaan reduce untuk menggabungkan LinkedList
        Stream<LinkedList<Integer>> listStream = Stream.of(
                new LinkedList<>(List.of(1, 2, 3)),
                new LinkedList<>(List.of(4, 5, 6)),
                new LinkedList<>(List.of(7, 8, 9)));

        Optional<LinkedList<Integer>> bigList = listStream.reduce((list1, list2) -> {
            LinkedList<Integer> retList = new LinkedList<>();
            retList.addAll(list1);
            retList.addAll(list2);
            return retList;
        });

        bigList.ifPresent(System.out::println); // output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
