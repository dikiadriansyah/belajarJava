public class Abstract {
    // abstract

    /*
     * Abstraksi adalah proses menyembunyikan detail implementasi dan hanya
     * menampilkan fungsionalitas kepada pengguna. Kelas abstrak tidak akan pernah
     * bisa dipakai. Jika suatu kelas dideklarasikan sebagai abstrak maka tujuan
     * satu-satunya adalah agar kelas tersebut diperluas.
     */

    /*
     * abstract class Car
     * {
     * abstract void tagLine();
     * }
     * class Honda extends Car
     * {
     * void tagLine()
     * {
     * System.out.println("Start Something Special");
     * }
     * }
     * class Toyota extends Car
     * {
     * void tagLine()
     * {
     * System.out.println("Drive Your Dreams");
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        Honda hondaCar = new Honda();
        Toyota toyotaCar = new Toyota();

        System.out.print("Honda: ");
        hondaCar.tagLine();
        /*
         * output:
         * Honda: Start Something Special
         */

        System.out.print("Toyota: ");
        toyotaCar.tagLine();
        /*
         * output:
         * Toyota: Drive Your Dreams
         */
    }
}
