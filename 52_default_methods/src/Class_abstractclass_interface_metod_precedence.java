public class Class_abstractclass_interface_metod_precedence extends AbstractSwimmer {
    // Class, Abstract class and Interface method precedence / Kelas, Kelas abstrak
    // dan metode Antarmuka hak lebih tinggi

    /*
     * Implementasi di kelas, termasuk deklarasi abstrak, diutamakan daripada semua
     * default antarmuka
     * Metode kelas abstrak lebih diutamakan daripada Metode Default Antarmuka
     */

    /*
     * public interface Swim {
     * default void backStroke() {
     * System.out.println("Swim.backStroke");
     * }
     * }
     * public abstract class AbstractSwimmer implements Swim {
     * public void backStroke() {
     * System.out.println("AbstractSwimmer.backStroke");
     * }
     * }
     * public class FooSwimmer extends AbstractSwimmer {
     * }
     */

    // Pernyataan berikut
    // new FooSwimmer().backStroke();

    // Akan menghasilkan
    // AbstractSwimmer.backStroke

    /*
     * Metode kelas lebih diutamakan daripada Metode Default Antarmuka
     * public interface Swim {
     * default void backStroke() {
     * System.out.println("Swim.backStroke");
     * }
     * }
     * public abstract class AbstractSwimmer implements Swim {
     * }
     * public class FooSwimmer extends AbstractSwimmer {
     * public void backStroke() {
     * System.out.println("FooSwimmer.backStroke");
     * }
     * }
     * 
     */

    // Pernyataan berikut
    // new FooSwimmer().backStroke();

    // Akan menghasilkan
    // FooSwimmer.backStroke

    @Override
    public void backStroke() {
        System.out.println("FooSwimmer.backStroke");
    }

    @Override
    public void performSwimming() {
        System.out.println("FooSwimmer is swimming");
    }

    public static void main(String[] args) {
        Class_abstractclass_interface_metod_precedence fooSwimmer = new Class_abstractclass_interface_metod_precedence();
        fooSwimmer.backStroke(); // Memanggil metode backStroke dari FooSwimmer
        fooSwimmer.performSwimming(); // Memanggil metode performSwimming dari FooSwimmer

        /*
         * output:
         * FooSwimmer.backStroke
         * FooSwimmer is swimming
         */

    }
}
