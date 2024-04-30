import java.io.Serializable;
import java.util.Comparator;

public interface SerializableComparator extends Comparator<Long>, Serializable {
    // Mengimplementasikan metode compare dari Comparator
    @Override
    default int compare(Long o1, Long o2) {
        // Menggunakan metode compare bawaan dari Long
        return Long.compare(o1, o2);
    }
}