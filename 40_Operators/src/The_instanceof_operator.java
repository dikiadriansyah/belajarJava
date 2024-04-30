public class The_instanceof_operator extends Vehicle {
    // The Instanceof Operator / Operator Contoh

    /*
     * Operator ini memeriksa apakah objek tersebut bertipe class/interface
     * tertentu. operator instanceof ditulis sebagai:
     * ( Object reference variable ) instanceof (class/interface type)
     */

    // public static void main(String[] args) {
    // contoh:

    // String name = "Buyya";

    // following will return true since name is type of String
    // boolean result = name instanceof String;
    // System.out.println(result); // true

    // Ini akan menghasilkan hasil sebagai berikut:
    // true

    /*
     * Operator ini akan tetap mengembalikan nilai true jika objek yang dibandingkan
     * adalah penugasan yang kompatibel dengan tipe di sebelah kanan.
     */

    // contoh:

    // }

    // -------------
    public static void main(String args[]) {
        Vehicle a = new The_instanceof_operator();
        boolean result = a instanceof The_instanceof_operator;
        System.out.println(result);
        // Ini akan menghasilkan hasil sebagai berikut:
        // true
    }

}
