public class Object_member_vs_static_member {
    // Object Member vs Static Member

    // Dengan kelas ini:
    /*
     * class ObjectMemberVsStaticMember {
     * static int staticCounter = 0;
     * int memberCounter = 0;
     * void increment() {
     * staticCounter ++;
     * memberCounter++;
     * }
     * }
     */

    // cuplikan kode berikut:
    /*
     * final ObjectMemberVsStaticMember o1 = new ObjectMemberVsStaticMember();
     * final ObjectMemberVsStaticMember o2 = new ObjectMemberVsStaticMember();
     * o1.increment();
     * o2.increment();
     * o2.increment();
     * 
     * System.out.println("o1 static counter " + o1.staticCounter);
     * System.out.println("o1 member counter " + o1.memberCounter);
     * System.out.println();
     * System.out.println("o2 static counter " + o2.staticCounter);
     * System.out.println("o2 member counter " + o2.memberCounter);
     * System.out.println();
     * System.out.println("ObjectMemberVsStaticMember.staticCounter = " +
     * ObjectMemberVsStaticMember.staticCounter);
     * // the following line does not compile. You need an object
     * // to access its members
     * //System.out.println("ObjectMemberVsStaticMember.staticCounter = " +
     * ObjectMemberVsStaticMember.memberCounter);
     */

    /*
     * menghasilkan keluaran ini:
     * o1 static counter 3
     * o1 member counter 1
     * o2 static counter 3
     * o2 member counter 2
     * ObjectMemberVsStaticMember.staticCounter = 3
     */

    /*
     * Catatan: Anda tidak boleh memanggil anggota statis pada objek, tetapi pada
     * kelas. Meskipun tidak membuat perbedaan bagi JVM, pembaca manusia akan
     * menghargainya.
     * 
     * anggota statis adalah bagian dari kelas dan hanya ada satu kali per kelas.
     * Anggota non-statis ada di instans, ada salinan independen untuk setiap
     * instans. Ini juga berarti bahwa Anda memerlukan akses ke objek kelas tersebut
     * untuk mengakses anggotanya.
     */

    static int staticCounter = 0;
    int memberCounter = 0;

    void increment() {
        staticCounter++;
        memberCounter++;
    }

    public static void main(String[] args) {
        final Object_member_vs_static_member o1 = new Object_member_vs_static_member();
        final Object_member_vs_static_member o2 = new Object_member_vs_static_member();
        o1.increment();
        o2.increment();
        o2.increment();

        System.out.println("o1 static counter " + o1.staticCounter);
        System.out.println("o1 member counter " + o1.memberCounter);
        System.out.println();
        /*
         * output:
         * o1 static counter 3
         * o1 member counter 1
         */

        System.out.println("o2 static counter " + o2.staticCounter);
        System.out.println("o2 member counter " + o2.memberCounter);
        System.out.println();
        /*
         * output:
         * o2 static counter 3
         * o2 member counter 2
         */

        // System.out.println("ObjectMemberVsStaticMember.staticCounter = " +
        // ObjectMemberVsStaticMember.staticCounter);

    }
}
