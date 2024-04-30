import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Unmodifiable_collection {
    // Unmodifiable Collection

    /*
     * Terkadang mengekspos koleksi internal bukanlah praktik yang baik karena dapat
     * menyebabkan kerentanan kode berbahaya karena karakteristiknya yang bisa
     * berubah. Untuk menyediakan koleksi "read-only" Java menyediakan versi yang
     * tidak dapat dimodifikasi.
     * 
     * Koleksi yang tidak dapat dimodifikasi seringkali merupakan salinan dari
     * koleksi yang dapat dimodifikasi yang menjamin bahwa koleksi itu sendiri tidak
     * dapat diubah. Upaya untuk mengubahnya akan menghasilkan pengecualian
     * UnsupportedOperationException.
     */

    /*
     * Penting untuk diperhatikan bahwa objek yang ada di dalam koleksi masih dapat
     * diubah.
     */

    private List<Integer> intList = new ArrayList<>();

    public void addValueToIntList(Integer value) {
        intList.add(value);
    }

    public List<Integer> getIntList() {
        return Collections.unmodifiableList(intList);
    }

    /*
     * Upaya berikut untuk mengubah koleksi yang tidak dapat dimodifikasi akan
     * menimbulkan pengecualian:
     */

    public static void main(String[] args) {
        Unmodifiable_collection box1 = new Unmodifiable_collection();
        box1.addValueToIntList(42);
        List<Integer> box2 = box1.getIntList();
        box2.add(69);
        System.out.println(box2);
    }

}
