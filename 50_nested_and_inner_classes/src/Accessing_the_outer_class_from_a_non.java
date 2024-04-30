public class Accessing_the_outer_class_from_a_non {
    // Accessing the outer class from a non-static inner class / Mengakses kelas
    // luar dari kelas dalam non-statis

    /*
     * Referensi kelas luar menggunakan nama kelas dan this
     * public class OuterClass {
     * public class InnerClass {
     * public void method() {
     * System.out.println("I can access my enclosing class: " + OuterClass.this);
     * }
     * }
     * }
     */

    // Anda dapat mengakses bidang dan metode kelas luar secara langsung

    /*
     * public class OuterClass {
     * private int counter;
     * public class InnerClass {
     * public void method() {
     * System.out.println("I can access " + counter);
     * }
     * }
     * }
     */

    // Namun jika terjadi tabrakan nama, Anda dapat menggunakan referensi kelas
    // luar.
    /*
     * public class OuterClass {
     * private int counter;
     * public class InnerClass {
     * private int counter;
     * 
     * public void method() {
     * System.out.println("My counter: " + counter);
     * System.out.println("Outer counter: " + OuterClass.this.counter);
     * 
     * // updating my counter
     * counter = OuterClass.this.counter;
     * }
     * }
     * }
     */

    private int counter;

    public Accessing_the_outer_class_from_a_non(int counter) {
        this.counter = counter;
    }

    public class InnerClass {
        private int counter;

        public void method() {
            System.out.println("My counter: " + counter);
            System.out.println("Outer counter: " + Accessing_the_outer_class_from_a_non.this.counter);

            // updating my counter
            counter = Accessing_the_outer_class_from_a_non.this.counter;
        }
    }

    public static void main(String[] args) {
        // Membuat objek Accessing_the_outer_class_from_a_non
        Accessing_the_outer_class_from_a_non outerObj = new Accessing_the_outer_class_from_a_non(10);

        // Membuat objek InnerClass menggunakan objek
        // Accessing_the_outer_class_from_a_non
        Accessing_the_outer_class_from_a_non.InnerClass innerObj = outerObj.new InnerClass();

        // Memanggil metode dari InnerClass
        innerObj.method();

        /*
         * output:
         * My counter: 0
         * Outer counter: 1
         */
    }
}
