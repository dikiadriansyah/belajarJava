public class Using_package_protected_scope {
    // Using Package Protected Scope / Menggunakan Lingkup yang Dilindungi Paket

    /*
     * Di Java, jika Anda tidak menyediakan pengubah akses, cakupan default untuk
     * variabel adalah tingkat yang dilindungi paket. Ini berarti bahwa kelas dapat
     * mengakses variabel kelas lain dalam paket yang sama seolah-olah variabel
     * tersebut tersedia untuk umum.
     */

    ExampleClass clazz = new ExampleClass();

    public void printOutput() {
        System.out.println("Example Number: " + clazz.exampleNumber);
        System.out.println("Example String: " + clazz.exampleString);
    }

    public static void main(String[] args) {
        Using_package_protected_scope anotherClass = new Using_package_protected_scope();
        anotherClass.printOutput();

        /*
         * output:
         * Example Number: 3.0
         * Example String: Test String
         */
    }
}
