public class Local_inner_class {
    // Local Inner Class

    /*
     * Kelas yang dibuat di dalam suatu metode disebut kelas dalam lokal di java.
     * Jika Anda ingin memanggil metode kelas dalam lokal, Anda harus membuat
     * instance kelas ini di dalam metode tersebut.
     */

    private int data = 30;// instance variable

    void display() {
        class Local {
            void msg() {
                System.out.println(data);
            }
        }
        Local l = new Local();
        l.msg();
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Local_inner_class obj = new Local_inner_class();
        obj.display();
        /*
         * output: 30
         */
    }
}
