import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Natural_comparable_vs_explicit_comparator_sorting {
    // Natural (comparable) vs explicit (comparator) sorting/ Penyortiran alami
    // (sebanding) vs eksplisit (pembanding).

    // Ada dua metode Collections.sort():
    /*
     * Yang menggunakan List<T> sebagai parameter di mana T harus
     * mengimplementasikan Comparable dan mengganti metode compareTo() yang
     * menentukan urutan pengurutan.
     * 
     * Yang menggunakan Daftar dan Pembanding sebagai argumen, di mana Pembanding
     * menentukan urutan pengurutan.
     */

    // Pertama, berikut adalah kelas Person yang mengimplementasikan Comparable:
    /*
     * public class Person implements Comparable<Person> {
     * private String name;
     * private int age;
     * public String getName() {
     * return name;
     * }
     * public void setName(String name) {
     * this.name = name;
     * }
     * public int getAge() {
     * return age;
     * }
     * public void setAge(int age) {
     * this.age = age;
     * }
     * 
     * @Override
     * public int compareTo(Person o) {
     * return this.getAge() - o.getAge();
     * }
     * 
     * @Override
     * public String toString() {
     * return this.getAge()+"-"+this.getName();
     * }
     * }
     * 
     */

    /*
     * Inilah cara Anda menggunakan kelas di atas untuk mengurutkan Daftar
     * berdasarkan urutan alami elemen-elemennya, yang ditentukan oleh penggantian
     * metode compareTo():
     * 
     */

    /*
     * //-- usage
     * List<Person> pList = new ArrayList<Person>();
     * Person p = new Person();
     * p.setName("A");
     * p.setAge(10);
     * pList.add(p);
     * p = new Person();
     * p.setName("Z");
     * p.setAge(20);
     * pList.add(p);
     * p = new Person();
     * p.setName("D");
     * p.setAge(30);
     * pList.add(p);
     * 
     * //-- natural sorting i.e comes with object implementation, by age
     * Collections.sort(pList);
     * System.out.println(pList);
     */

    /*
     * Inilah cara Anda menggunakan Komparator sebaris anonim untuk mengurutkan
     * Daftar yang tidak mengimplementasikan Comparable, atau dalam hal ini, untuk
     * mengurutkan Daftar dalam urutan selain urutan alami:
     * 
     * //-- explicit sorting, define sort on another property here goes with name
     * Collections.sort(pList, new Comparator<Person>() {
     * 
     * @Override
     * public int compare(Person o1, Person o2) {
     * return o1.getName().compareTo(o2.getName());
     * }
     * });
     * System.out.println(pList);
     */

    public static void main(String[] args) {
        // -- usage
        List<Person8> pList = new ArrayList<Person8>();
        Person8 p = new Person8();
        p.setName("A");
        p.setAge(10);
        pList.add(p);
        p = new Person8();
        p.setName("Z");
        p.setAge(20);
        pList.add(p);
        p = new Person8();
        p.setName("D");
        p.setAge(30);
        pList.add(p);

        // -- natural sorting i.e comes with object implementation, by age
        // Collections.sort(pList);
        // System.out.println(pList);
        /*
         * output:
         * [10-A, 20-Z, 30-D]
         */
        // --------------------------------------
        // -- explicit sorting, define sort on another property here goes with name
        Collections.sort(pList, new Comparator<Person8>() {
            @Override
            public int compare(Person8 o1, Person8 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(pList);
        /*
         * output:
         * [10-A, 20-Z, 30-D]
         */

    }
}
