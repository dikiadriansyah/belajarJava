public class Outcast_downcasting {
    // Outcast Downcasting/Downcasting yang Diasingkan

    /*
     * Hati-hati dalam menggunakan "downcasting" - Downcasting adalah menurunkan
     * hierarki warisan dari kelas dasar ke subkelas (yaitu kebalikan dari
     * polimorfisme). Secara umum, gunakan polimorfisme & overriding daripada
     * instanceof & merendahkan.
     */

    /*
     * C++ Example
     * // explicit type case required
     * Child *pChild = (Child *) &parent;
     */

    /*
     * Java Example
     * if(mySubClass instanceof SubClass) {
     * SubClass mySubClass = (SubClass)someBaseClass;
     * mySubClass.nonInheritedMethod();
     * }
     */
    public static void main(String[] args) {
        BaseClass2 someBaseClass = new SubClass2();

        if (someBaseClass instanceof SubClass2) {
            SubClass2 mySubClass = (SubClass2) someBaseClass;
            mySubClass.nonInheritedMethod();
        }
    }
}
