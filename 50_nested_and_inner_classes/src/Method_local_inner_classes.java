public class Method_local_inner_classes {
    // Method Local Inner Classes / Metode Kelas Dalam Lokal

    /*
     * Sebuah kelas yang ditulis dalam suatu metode disebut metode kelas dalam
     * lokal. Dalam hal ini ruang lingkup kelas dalam dibatasi dalam metode
     * tersebut.
     * 
     * Kelas dalam metode-lokal hanya dapat dipakai dalam metode di mana kelas dalam
     * ditentukan.
     * 
     * Contoh penggunaan metode kelas dalam lokal:
     * 
     * public class OuterClass {
     * private void outerMethod() {
     * final int outerInt = 1;
     * // Method Local Inner Class
     * class MethodLocalInnerClass {
     * private void print() {
     * System.out.println("Method local inner class " + outerInt);
     * }
     * }
     * // Accessing the inner class
     * MethodLocalInnerClass inner = new MethodLocalInnerClass();
     * inner.print();
     * }
     * public static void main(String args[]) {
     * OuterClass outer = new OuterClass();
     * outer.outerMethod();
     * }
     * }
     * 
     */

    private void outerMethod() {
        final int outerInt = 1;
        // Method Local Inner Class
        class MethodLocalInnerClass {
            private void print() {
                System.out.println("Method local inner class " + outerInt);
            }
        }
        // Accessing the inner class
        MethodLocalInnerClass inner = new MethodLocalInnerClass();
        inner.print();
    }

    public static void main(String[] args) {
        Method_local_inner_classes box1 = new Method_local_inner_classes();
        box1.outerMethod(); // Method local inner class 1
    }
}
