import java.util.*;

public class Hashtable1 {
    // Hashtable

    /*
     * Hashtable adalah kelas dalam koleksi Java yang mengimplementasikan map
     * interface dan memperluas Kelas Kamus.
     * 
     * Hanya berisi elemen unik dan tersinkronisasi
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // membuat dan mengisi hash tabel
        Hashtable<Integer, String> map = new Hashtable<Integer, String>();
        map.put(101, "C Language");
        map.put(102, "Domain");
        map.put(104, "Databases");
        System.out.println("Values before remove: " + map);
        /*
         * Values before remove: {104=Databases, 102=Domain, 101=C Language}
         */

        // Remove value for key 102
        map.remove(102);
        System.out.println("Values after remove: " + map);
        /*
         * output:
         * Values after remove: {104=Databases, 101=C Language}
         */

    }
}
