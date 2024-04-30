public class Create_instance_of_non_static_inner {
    // Create instance of non-static inner class from outside / Buat instance kelas
    // dalam non-statis dari luar

    /*
     * Kelas dalam yang dapat dilihat oleh kelas luar mana pun dapat dibuat dari
     * kelas ini juga.
     * 
     * Kelas dalam bergantung pada kelas luar dan memerlukan referensi ke instance
     * kelas tersebut. Untuk membuat sebuah instance dari
     * kelas dalam, operator new hanya perlu dipanggil pada instance kelas luar.
     * 
     * class OuterClass {
     * class InnerClass {
     * }
     * }
     * class OutsideClass {
     * OuterClass outer = new OuterClass();
     * 
     * OuterClass.InnerClass createInner() {
     * return outer.new InnerClass();
     * }
     * }
     * 
     * Perhatikan penggunaannya sebagai outer.new.
     */

    public static void main(String[] args) {
        DuaClass outsideObj = new DuaClass();
        SatuClass.InnerClass innerObj = outsideObj.createInner();

        // Contoh pemanggilan objek inner class
        System.out.println("Objek InnerClass berhasil dibuat!");
        /*
         * output:
         * Objek InnerClass berhasil dibuat!
         */

    }
}
