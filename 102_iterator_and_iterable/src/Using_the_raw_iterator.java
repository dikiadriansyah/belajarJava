import java.util.List;
import java.util.Iterator;

public class Using_the_raw_iterator {
    // Using the raw iterator/Menggunakan iterator mentah

    /*
     * Meskipun menggunakan perulangan foreach (atau
     * "extended for loop") itu sederhana, terkadang ada gunanya
     * menggunakan iterator secara langsung.
     * Misalnya, jika Anda ingin mengeluarkan sekumpulan nilai yang dipisahkan koma,
     * namun tidak ingin item terakhir memiliki koma:
     * 
     * List<String> yourData = //...
     * Iterator<String> iterator = yourData.iterator();
     * while (iterator.hasNext()){
     * // next() "moves" the iterator to the next entry and returns it's value.
     * String entry = iterator.next();
     * System.out.print(entry);
     * if (iterator.hasNext()){
     * // If the iterator has another element after the current one:
     * System.out.print(",");
     * }
     * }
     */

    // Ini jauh lebih mudah dan jelas daripada memiliki variabel isLastEntry atau
    // melakukan perhitungan dengan indeks loop.

    public static void main(String[] args) throws Exception {
        List<String> yourData = List.of("Data1", "Data2", "Data3", "Data4", "Data5");
        Iterator<String> iterator = yourData.iterator();
        while (iterator.hasNext()) {
            // next() "moves" the iterator to the next entry and returns it's value.
            String entry = iterator.next();
            System.out.print(entry);
            if (iterator.hasNext()) {
                // If the iterator has another element after the current one:
                System.out.print(",");
            }
            /*
             * Data1,Data2,Data3,Data4,Data5
             */

        }

    }
}