public class Overflow_and_underflow {
    // OverFlow and UnderFlow/Aliran Melimpah dan Aliran Bawah

    // Float data type
    // Tipe data float adalah floating point IEEE 754 32-bit presisi tunggal

    // Float overflow

    // Nilai maksimum yang mungkin adalah 3.4028235e+38 , Jika melebihi nilai ini
    // maka akan menghasilkan Infinity

    /*
     * float f = 3.4e38f;
     * float result = f*2;
     * System.out.println(result); //Infinity
     */

    // Float UnderFlow
    // Nilai minimumnya adalah 1.4e-45f, bila berada di bawah nilai ini maka akan
    // menghasilkan 0.0

    /*
     * float f = 1e-45f;
     * float result = f/1000;
     * System.out.println(result);
     */

    // double data type
    // Tipe data ganda adalah floating point IEEE 754 64-bit presisi ganda

    // Double OverFlow

    // Nilai maksimum yang mungkin adalah 1.7976931348623157e+308 , Jika melebihi
    // nilai ini maka akan menghasilkan Infinity

    /*
     * double d = 1e308;
     * double result=d*2;
     * System.out.println(result); //Infinity
     */

    // Double UnderFlow

    // Nilai minimumnya adalah 4.9e-324, jika berada di bawah nilai ini maka akan
    // menghasilkan 0.0
    /*
     * double d = 4.8e-323;
     * double result = d/1000;
     * System.out.println(result); //0.0
     */

    public static void main(String[] args) {
        // float f = 3.4e38f;
        // float result = f * 2;
        // System.out.println(result); // Infinity
        // ---------------------
        // float f = 1e-45f;
        // float result = f / 1000;
        // System.out.println(result); // 0.0

        // -------------------------
        // double d = 1e308;
        // double result = d * 2;
        // System.out.println(result); // Infinity
        // --------------
        // double d = 4.8e-323;
        // double result = d / 1000;
        // System.out.println(result); // 0.0
    }
}
