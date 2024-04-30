interface InterfaceA {
    public default String getName() {
        return "a";
    }
}

interface InterfaceB {
    public default String getName() {
        return "b";
    }
}

public class Default_methods implements InterfaceA, InterfaceB {
    // Default methods/Metode bawaan

    /*
     * Diperkenalkan di Java 8, metode default adalah cara menentukan implementasi
     * di dalam antarmuka. Ini dapat digunakan untuk menghindari kelas "Base" atau
     * "Abstract" yang khas dengan menyediakan sebagian implementasi antarmuka, dan
     * membatasi hierarki subkelas.
     */

    // Observer pattern implementation/Implementasi pola pengamat

    /*
     * Misalnya, pola Pengamat-Pendengar dapat diimplementasikan secara langsung ke
     * antarmuka, sehingga memberikan lebih banyak fleksibilitas pada kelas
     * pelaksana.
     */

    /*
     * interface Observer {
     * void onAction(String a);
     * }
     * interface Observable{
     * public abstract List<Observer> getObservers();
     * public default void addObserver(Observer o){
     * getObservers().add(o);
     * }
     * public default void notify(String something ){
     * for( Observer l : getObservers() ){
     * l.onAction(something);
     * }
     * }
     * }
     * 
     */

    /*
     * Sekarang, kelas mana pun dapat dibuat "Observable/Dapat Diamati" hanya dengan
     * mengimplementasikan antarmuka Observable, sekaligus bebas menjadi bagian dari
     * hierarki kelas yang berbeda.
     */

    /*
     * abstract class Worker{
     * public abstract void work();
     * }
     * public class MyWorker extends Worker implements Observable {
     * private List<Observer> myObservers = new ArrayList<Observer>();
     * 
     * @Override
     * public List<Observer> getObservers() {
     * return myObservers;
     * }
     * 
     * @Override
     * public void work(){
     * notify("Started work");
     * // Code goes here...
     * notify("Completed work");
     * }
     * 
     * public static void main(String[] args) {
     * MyWorker w = new MyWorker();
     * 
     * w.addListener(new Observer() {
     * 
     * @Override
     * public void onAction(String a) {
     * System.out.println(a + " (" + new Date() + ")");
     * }
     * });
     * 
     * w.work();
     * }
     * }
     * 
     */

    // Diamond problem

    /*
     * Kompiler di Java 8 menyadari masalah berlian yang disebabkan ketika suatu
     * kelas mengimplementasikan antarmuka yang berisi metode dengan tanda tangan
     * yang sama.
     * Untuk mengatasinya, kelas pelaksana harus mengganti metode bersama dan
     * menyediakan implementasinya sendiri.
     */

    /*
     * interface InterfaceA {
     * public default String getName(){
     * return "a";
     * }
     * }
     * interface InterfaceB {
     * public default String getName(){
     * return "b";
     * }
     * }
     * public class ImpClass implements InterfaceA, InterfaceB {
     * 
     * @Override
     * public String getName() {
     * //Must provide its own implementation
     * return InterfaceA.super.getName() + InterfaceB.super.getName();
     * }
     * 
     * public static void main(String[] args) {
     * ImpClass c = new ImpClass();
     * 
     * System.out.println( c.getName() ); // Prints "ab"
     * System.out.println( ((InterfaceA)c).getName() ); // Prints "ab"
     * System.out.println( ((InterfaceB)c).getName() ); // Prints "ab"
     * }
     * }
     */

    /*
     * Masih ada masalah memiliki metode dengan nama dan parameter yang sama dengan
     * tipe pengembalian berbeda, yang tidak dapat dikompilasi
     */

    // Use default methods to resolve compatibility issues /Gunakan metode default
    // untuk menyelesaikan masalah kompatibilitas

    /*
     * Implementasi metode default sangat berguna jika suatu metode ditambahkan ke
     * antarmuka dalam sistem yang ada di mana antarmuka tersebut digunakan oleh
     * beberapa kelas.
     * 
     * Untuk menghindari putusnya keseluruhan sistem, Anda dapat menyediakan
     * implementasi metode default saat Anda menambahkan metode ke antarmuka. Dengan
     * cara ini, sistem akan tetap dikompilasi dan implementasi sebenarnya dapat
     * dilakukan langkah demi langkah.
     * 
     * Untuk informasi selengkapnya, lihat topik Metode Default.
     */

    @Override
    public String getName() {
        // Must provide its own implementation
        return InterfaceA.super.getName() + InterfaceB.super.getName();
    }

    public static void main(String[] args) {
        Default_methods c = new Default_methods();

        System.out.println(c.getName()); // Prints "ab"
        System.out.println(((InterfaceA) c).getName()); // Prints "ab"
        System.out.println(((InterfaceB) c).getName()); // Prints "ab"
    }
}
