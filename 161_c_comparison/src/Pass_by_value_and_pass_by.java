public class Pass_by_value_and_pass_by {
    // Pass-by-value & Pass-by-reference/Pass-by-value dan Pass-by-reference

    /*
     * Banyak yang berpendapat bahwa Java HANYA berdasarkan nilai, namun lebih
     * bernuansa dari itu. Bandingkan C++ dan Java berikut
     * contoh untuk melihat berbagai jenis pass-by-value (alias copy) dan
     * pass-by-reference (alias alias).
     */

    /*
     * C++ Example (complete code)
     * // passes a COPY of the object
     * static void passByCopy(PassIt obj) {
     * obj.i = 22; // only a "local" change
     * }
     * // passes a pointer
     * static void passByPointer(PassIt* ptr) {
     * ptr->i = 33;
     * ptr = 0; // better to use nullptr instead if '0'
     * }
     * // passes an alias (aka reference)
     * static void passByAlias(PassIt& ref) {
     * ref.i = 44;
     * }
     * // This is an old-school way of doing it.
     * // Check out std::swap for the best way to do this
     * static void swap(PassIt** pptr1, PassIt** pptr2) {
     * PassIt* tmp = *pptr1;
     * pptr1 = *pptr2;
     * pptr2 = tmp;
     * }
     * 
     */

    /*
     * Java Example (complete code)
     * // passes a copy of the variable
     * // NOTE: in java only primitives are pass-by-copy
     * public static void passByCopy(int copy) {
     * copy = 33; // only a "local" change
     * }
     * // No such thing as pointers in Java
     * 
     * //public static void passByPointer(PassIt *ptr) {
     * //ptr->i = 33;
     * //ptr = 0; // better to use nullptr instead if '0'
     * //}
     */

    /*
     * // passes an alias (aka reference)
     * public static void passByAlias(PassIt ref) {
     * ref.i = 44;
     * }
     * // passes aliases (aka references),
     * // but need to do "manual", potentially expensive copies
     * public static void swap(PassIt ref1, PassIt ref2) {
     * PassIt tmp = new PassIt(ref1);
     * ref1.copy(ref2);
     * ref2.copy(tmp);
     * }
     */
    // --------------------
    int i;

    public Pass_by_value_and_pass_by(int i) {
        this.i = i;
    }

    public void copy(Pass_by_value_and_pass_by other) {
        this.i = other.i;
    }

    public static void passByCopy(int copy) {
        copy = 33; // hanya perubahan "lokal"
    }

    /*
     * public static void passByPointer(Pass_by_value_and_pass_by *ptr) {
     * ptr->i = 33;
     * ptr = 0; // lebih baik menggunakan nullptr daripada '0'
     * }
     */

    public static void passByAlias(Pass_by_value_and_pass_by ref) {
        ref.i = 44;
    }

    public static void swap(Pass_by_value_and_pass_by ref1, Pass_by_value_and_pass_by ref2) {
        Pass_by_value_and_pass_by tmp = new Pass_by_value_and_pass_by(ref1.i);
        ref1.copy(ref2);
        ref2.copy(tmp);
    }

    public static void main(String[] args) {
        Pass_by_value_and_pass_by obj1 = new Pass_by_value_and_pass_by(10);
        Pass_by_value_and_pass_by obj2 = new Pass_by_value_and_pass_by(20);

        System.out.println("Sebelum pemanggilan swap():");
        System.out.println("obj1.i = " + obj1.i);
        System.out.println("obj2.i = " + obj2.i);
        /*
         * output:
         * Sebelum pemanggilan swap():
         * obj1.i = 10
         * obj2.i = 20
         */

        swap(obj1, obj2);

        System.out.println("Setelah pemanggilan swap():");
        System.out.println("obj1.i = " + obj1.i);
        System.out.println("obj2.i = " + obj2.i);
        /*
         * output:
         * Setelah pemanggilan swap():
         * obj1.i = 20
         * obj2.i = 10
         */
    }
}
