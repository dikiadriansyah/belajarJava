import java.util.BitSet;
import java.util.stream.IntStream;
import java.util.*;

public class java_util_bitSet_class {
    // java.util.BitSet class

    /*
     * Sejak 1.7 ada kelas java.util.BitSet yang menyediakan antarmuka manipulasi
     * dan penyimpanan bit yang sederhana dan mudah digunakan:
     */
    public static void main(String[] args) throws Exception {
        final BitSet box1 = new BitSet(8);

        IntStream.range(0, 8).filter(i -> i % 2 == 0).forEach(box1::set); // {0,2,4,6}
        box1.set(3); // {0, 2, 3, 4, 6}
        box1.set(3, false); // {0,2,4,6}

        final boolean box2 = box1.get(3); // box2 = false

        box1.flip(6); // {0,2,4}
        box1.set(100); // {0, 2, 4, 100} expands automatically

        /*
         * BitSet mengimplementasikan Clonable dan Serializable, dan di balik terpal
         * semua nilai bit disimpan dalam bidang kata-kata long[],
         * yang meluas secara otomatis.
         * 
         * Ini juga mendukung seluruh operasi logika dan, atau, xor, danNot:
         */

        // box1.and(new BitSet(8));
        // box1.or(new BitSet(8));
        box1.xor(new BitSet(8));
        // box1.andNot(new BitSet(8));

        System.out.println(box1);
    }
}
