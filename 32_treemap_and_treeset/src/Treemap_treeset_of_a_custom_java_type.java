import java.util.*;

public class Treemap_treeset_of_a_custom_java_type {
    // TreeMap/TreeSet of a custom Java type

    /*
     * Karena TreeMaps dan TreeSets memelihara kunci/elemen sesuai dengan urutan
     * alaminya. Oleh karena itu kunci TreeMap dan elemen TreeSet harus sebanding
     * satu sama lain.
     */

    // Katakanlah kita memiliki Person class khusus:

    // private int id;
    // private String firstName, lastName;
    // private Date birthday;

    // Jika kita menyimpannya apa adanya di TreeSet (atau Kunci di TreeMap):
    /*
     * TreeSet<Person2> set = ...
     * set.add(new Person(1,"first","last",Date.from(Instant.now())));
     */

    // Lalu kita akan menemui Pengecualian seperti ini:
    /*
     * Exception in thread "main" java.lang.ClassCastException: Person cannot be
     * cast to
     * java.lang.Comparable
     * at java.util.TreeMap.compare(TreeMap.java:1294)
     * at java.util.TreeMap.put(TreeMap.java:538)
     * at java.util.TreeSet.add(TreeSet.java:255)
     */

    /*
     * Untuk memperbaikinya, anggap saja kita ingin mengurutkan instance Person
     * berdasarkan urutan idnya (id int pribadi). Kita dapat melakukannya dengan
     * salah satu dari dua cara berikut:
     * 1. Salah satu solusinya adalah dengan memodifikasi Person sehingga akan
     * mengimplementasikan Comparable interface:
     * 
     * 2.Solusi lain adalah dengan menyediakan Komparator pada TreeSet:
     */
    public static void main(String[] args) {
        // Version ≥ Java SE 8
        // TreeSet<Person2> treeSet = new TreeSet<>(
        // (personA, personB) -> Integer.compare(personA.getId(),
        // personB.getId()));

        // TreeSet<Person2> treeSet2 = new TreeSet<>(
        // new Comparator<Person2>() {
        // @Override
        // public int compare(Person2 personA,
        // Person2 personB) {
        // return Integer.compare(personA.getId(), personB.getId());
        // }
        // });

        /*
         * Namun, ada dua peringatan untuk kedua pendekatan tersebut:
         * 1. Sangat penting untuk tidak mengubah bidang apa pun yang digunakan untuk
         * pemesanan setelah sebuah instance dimasukkan ke dalam TreeSet/TreeMap. Dalam
         * contoh di atas, jika kita mengubah id seseorang yang sudah dimasukkan ke
         * dalam koleksi, kita mungkin mengalami perilaku yang tidak diharapkan.
         * 2. Penting untuk menerapkan perbandingan dengan benar dan konsisten. Sesuai
         * Javadoc:
         * The implementor must ensure sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for
         * all x and y. (This implies that x.compareTo(y) must throw an exception iff
         * y.compareTo(x) throws an exception.)
         * The implementor must also ensure that the relation is transitive:
         * (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
         * Finally, the implementor must ensure that x.compareTo(y)==0 implies that
         * sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
         */

        // Menambahkan beberapa objek Person ke TreeSet
        // treeSet.add(new Person2(3));
        // treeSet.add(new Person2(1));
        // treeSet.add(new Person2(2));

        // treeSet2.add(new Person2(3));
        // treeSet2.add(new Person2(1));
        // treeSet2.add(new Person2(2));

        // // Menampilkan elemen TreeSet pertama
        // Person2 firstElementTreeSet = treeSet.first();
        // System.out.println("TreeSet 1 - Elemen Pertama: " +
        // firstElementTreeSet.getId());

        // Person2 firstElementTreeSet2 = treeSet2.first();
        // System.out.println("TreeSet 2 - Elemen Pertama: " +
        // firstElementTreeSet2.getId());
    }
}
