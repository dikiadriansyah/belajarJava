public class SubClassWithField extends BaseClassWithField {
    public SubClassWithField(int x) {
        this.x = x; // Dapat mengakses field dari kelas induk
    }

    public static void main(String[] args) {
        // Membuat objek dari kelas SubClassWithField
        SubClassWithField subClassObj = new SubClassWithField(42);

        // Mencetak nilai field x dari objek SubClassWithField
        System.out.println("Nilai x dari objek SubClassWithField: " + subClassObj.x);
        /*
         * output:
         * Nilai x dari objek SubClassWithField: 42
         */
    }
}
