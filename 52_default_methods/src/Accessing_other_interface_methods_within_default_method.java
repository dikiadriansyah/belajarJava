public class Accessing_other_interface_methods_within_default_method {
    // Accessing other interface methods within default method / Mengakses metode
    // antarmuka lain dalam metode default

    /*
     * Anda juga dapat mengakses metode antarmuka lainnya dari dalam metode default
     * Anda.
     * 
     * public interface Summable {
     * int getA();
     * int getB();
     * default int calculateSum() {
     * return getA() + getB();
     * }
     * }
     * public class Sum implements Summable {
     * 
     * @Override
     * public int getA() {
     * return 1;
     * }
     * 
     * @Override
     * public int getB() {
     * return 2;
     * }
     * }
     * 
     */

    /*
     * Pernyataan berikut akan mencetak 3:
     * System.out.println(new Sum().calculateSum());
     */

    /*
     * Metode default juga dapat digunakan bersama dengan metode statis antarmuka:
     * public interface Summable {
     * static int getA() {
     * return 1;
     * }
     * static int getB() {
     * return 2;
     * }
     * default int calculateSum() {
     * return getA() + getB();
     * }
     * }
     * public class Sum implements Summable {}
     */

    /*
     * Pernyataan berikut juga akan mencetak 3:
     * System.out.println(new Sum().calculateSum());
     */

    public static void main(String[] args) {
        System.out.println(new Sum().calculateSum());
        /*
         * output:
         * 3
         */

    }
}
