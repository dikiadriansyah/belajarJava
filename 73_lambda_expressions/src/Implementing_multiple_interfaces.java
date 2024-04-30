import java.util.TreeSet;
import java.io.Serializable;
import java.util.Comparator;

public class Implementing_multiple_interfaces {
    // Implementing multiple interfaces/Menerapkan banyak antarmuka

    /*
     * Terkadang Anda mungkin ingin ekspresi lambda mengimplementasikan lebih dari
     * satu antarmuka. Ini sebagian besar berguna dengan antarmuka penanda (seperti
     * java.io.Serializable) karena mereka tidak menambahkan metode abstrak.
     * 
     * Misalnya, Anda ingin membuat TreeSet dengan Comparator khusus lalu membuat
     * serialisasinya dan mengirimkannya melalui jaringan. Pendekatan sepele:
     * TreeSet<Long> ts = new TreeSet<>((x, y) -> Long.compare(y, x));
     */

    /*
     * tidak berfungsi karena lambda untuk komparator tidak mengimplementasikan
     * Serializable. Anda dapat memperbaikinya dengan menggunakan tipe persimpangan
     * dan secara eksplisit menentukan bahwa lambda ini harus dapat diserialkan:
     * TreeSet<Long> ts = new TreeSet<>(
     * (Comparator<Long> & Serializable) (x, y) -> Long.compare(y, x));
     */

    /*
     * Jika Anda sering menggunakan tipe persimpangan (misalnya, jika Anda
     * menggunakan kerangka kerja seperti Apache Spark yang hampir semuanya harus
     * dapat diserialkan), Anda dapat membuat antarmuka kosong dan menggunakannya
     * dalam kode Anda:
     * public interface SerializableComparator extends Comparator<Long>,
     * Serializable {}
     * public class CustomTreeSet {
     * public CustomTreeSet(SerializableComparator comparator) {}
     * }
     */

    // Dengan cara ini Anda dijamin bahwa komparator yang diteruskan akan dapat
    // diserialkan.

    private TreeSet<Long> treeSet;

    public Implementing_multiple_interfaces(SerializableComparator comparator) {
        // Menggunakan comparator yang diberikan saat membuat TreeSet
        this.treeSet = new TreeSet<>(comparator);
    }

    public void addElement(Long element) {
        treeSet.add(element);
    }

    public void printElements() {
        System.out.println("Elements in CustomTreeSet: " + treeSet);
    }

    public static void main(String[] args) {
        // Membuat TreeSet dengan komparator kustom untuk urutan menurun
        // TreeSet<Long> ts = new TreeSet<>((x, y) -> Long.compare(y, x));

        // Menambahkan elemen ke TreeSet
        // ts.add(10L);
        // ts.add(5L);
        // ts.add(20L);
        // ts.add(15L);

        // Menampilkan elemen-elemen dalam urutan menurun
        // System.out.println("Elemen TreeSet dalam urutan menurun:");
        // for (Long element : ts) {
        // System.out.println(element);
        // }

        /*
         * output:
         * Elemen TreeSet dalam urutan menurun:
         * 20
         * 15
         * 10
         * 5
         */
        // ---------------------------------
        // Membuat instance dari SerializableComparator
        SerializableComparator serializableComparator = new SerializableComparator() {
            @Override
            public int compare(Long o1, Long o2) {
                // Implementasi pembanding khusus untuk Long
                return Long.compare(o1, o2);
            }
        };

        // Membuat instance dari CustomTreeSet dengan menggunakan SerializableComparator
        Implementing_multiple_interfaces customTreeSet = new Implementing_multiple_interfaces(serializableComparator);

        // Menambahkan elemen ke dalam CustomTreeSet
        customTreeSet.addElement(5L);
        customTreeSet.addElement(2L);
        customTreeSet.addElement(8L);

        // Menampilkan elemen-elemen dalam CustomTreeSet
        customTreeSet.printElements();
        /*
         * output:
         * Elements in CustomTreeSet: [2, 5, 8]
         */

    }
}
