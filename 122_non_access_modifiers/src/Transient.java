public class Transient {
    // transient

    // Variabel yang dideklarasikan sebagai transient tidak akan diserialkan selama
    // serialisasi objek.
    /*
     * public transient int limit = 55; // will not persist
     * public int b; // will persist
     */

    public transient int limit = 55; // will not persist
    public int b; // will persist

    public static void main(String[] args) throws Exception {
        Transient box = new Transient();
        System.out.println("Nilai limit: " + box.limit); // output: 55
        System.out.println("Nilai b: " + box.b); // output: Nilai b: 0
    }
}
