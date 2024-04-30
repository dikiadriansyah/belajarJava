import java.util.concurrent.ConcurrentHashMap;

public class Insertion_into_concurrentHashMap {
    // Insertion into ConcurrentHashMap/Penyisipan ke ConcurrentHashMap
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, SomeObject> concurrentHashMap = new ConcurrentHashMap<>();
        SomeObject value = new SomeObject();
        Integer key = 1;
        SomeObject previousValue = concurrentHashMap.putIfAbsent(1, value);
        if (previousValue != null) {
            // Then some other value was mapped to key = 1. 'value' that was passed to
            // putIfAbsent method is NOT inserted, hence, any other thread which calls
            // concurrentHashMap.get(1) would NOT receive a reference to the 'value'
            // that your thread attempted to insert. Decide how you wish to handle
            // this situation.
            System.out.println("Nilai sebelumnya sudah ada untuk kunci = " + key);
        } else {
            // 'value' reference is mapped to key = 1.
            System.out.println("Nilai baru ditetapkan untuk kunci = " + key);
        }

        /*
         * output:
         * Nilai baru ditetapkan untuk kunci = 1
         */

    }
}
