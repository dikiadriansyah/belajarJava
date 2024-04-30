import java.util.*;

public class Adding_behaviour_by_adding_classes_without_touching_existing_code {
    // Adding behaviour by adding classes without touching existing code/Menambahkan
    // perilaku dengan menambahkan kelas tanpa menyentuh kode yang ada

    /*
     * import java.util.ArrayList;
     * import java.util.List;
     * import static java.lang.System.out;
     * public class PolymorphismDemo {
     * public static void main(String[] args) {
     * List<FlyingMachine> machines = new ArrayList<FlyingMachine>();
     * machines.add(new FlyingMachine());
     * machines.add(new Jet());
     * machines.add(new Helicopter());
     * machines.add(new Jet());
     * new MakeThingsFly().letTheMachinesFly(machines);
     * }
     * }
     * class MakeThingsFly {
     * public void letTheMachinesFly(List<FlyingMachine> flyingMachines) {
     * for (FlyingMachine flyingMachine : flyingMachines) {
     * flyingMachine.fly();
     * }
     * }
     * }
     * class FlyingMachine {
     * public void fly() {
     * out.println("No implementation");
     * }
     * }
     * class Jet extends FlyingMachine {
     * 
     * @Override
     * public void fly() {
     * out.println("Start, taxi, fly");
     * }
     * public void bombardment() {
     * out.println("Fire missile");
     * }
     * }
     * class Helicopter extends FlyingMachine {
     * 
     * @Override
     * public void fly() {
     * out.println("Start vertically, hover, fly");
     * }
     * }
     */

    // penjelasan:
    /*
     * a) Kelas MakeThingsFly dapat bekerja dengan segala sesuatu yang bertipe
     * FlyingMachine.
     * b) Metode letTheMachinesFly juga berfungsi tanpa perubahan apa pun (!) saat
     * Anda menambahkan kelas baru, misalnya
     * PropellerPlane:
     * 
     * public void letTheMachinesFly(List<FlyingMachine> flyingMachines) {
     * for (FlyingMachine flyingMachine : flyingMachines) {
     * flyingMachine.fly();
     * }
     * }
     * }
     * 
     */

    /*
     * Itulah kekuatan polimorfisme. Anda dapat menerapkan prinsip buka-tutup
     * dengannya.
     */

    public static void main(String[] args) throws Exception {
        List<FlyingMachine> machines = new ArrayList<FlyingMachine>();
        machines.add(new FlyingMachine());
        machines.add(new Jet());
        machines.add(new Helicopter());
        machines.add(new Jet());
        new MakeThingsFly().letTheMachinesFly(machines);

        /*
         * output:
         * No implementation
         * Start, taxi, fly
         * Start vertically, hover, fly
         * Start, taxi, fly
         */
    }
}
