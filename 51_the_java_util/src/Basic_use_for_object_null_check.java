import java.util.Objects;

public class Basic_use_for_object_null_check {
    // Basic use for object null check / Penggunaan dasar untuk pemeriksaan objek
    // nol

    /*
     * For null check in method / Untuk metode check-in nol
     * Object nullableObject = methodReturnObject();
     * if (Objects.isNull(nullableObject)) {
     * return;
     * }
     * 
     * For not null check in method / Untuk metode check-in bukan null
     * Object nullableObject = methodReturnObject();
     * if (Objects.nonNull(nullableObject)) {
     * return;
     * }
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Object nullableObject = methodReturnObject();
        if (Objects.isNull(nullableObject)) {
            System.out.println("nullableObject is null. Exiting the program.");
            return;
        }
        /*
         * output:
         * nullableObject is null. Exiting the program
         */

    }

    // Contoh methodReturnObject
    private static Object methodReturnObject() {
        // Implementasi sesuai kebutuhan Anda
        // Misalnya:
        // return new Object();
        return null; // Ganti dengan nilai objek yang sesuai jika tidak null
    }

}
