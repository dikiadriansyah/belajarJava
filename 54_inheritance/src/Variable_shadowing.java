public class Variable_shadowing extends Car {
    // Variable shadowing / Bayangan variabel

    /*
     * Variabel DIBAYANGKAN dan metode DIGANTI. Variabel mana yang akan digunakan
     * tergantung pada kelas yang dimilikinya variabel dideklarasikan. Metode mana
     * yang akan digunakan bergantung pada kelas sebenarnya dari objek yang
     * direferensikan variabel.
     */

    public int gearRatio = 9;

    public String accelerate() {
        return "Accelerate : SportsCar";
    }

    public void test() {
    }

    public static void main(String[] args) {
        Variable_shadowing car = new Variable_shadowing();
        System.out.println(car.gearRatio + " " + car.accelerate());
        // 9 Accelerate : SportsCar
    }
}
