
public class Implement_equals_method {
    // Implement equals() method/Menerapkan metode sama dengan()

    /*
     * Untuk mengimplementasikan metode equals dengan suatu objek dengan mudah, Anda
     * dapat menggunakan kelas EqualsBuilder.
     * 
     * Memilih bidang:
     * 
     * @Override
     * public boolean equals(Object obj) {
     * if(!(obj instanceof MyClass)) {
     * return false;
     * }
     * MyClass theOther = (MyClass) obj;
     * 
     * EqualsBuilder builder = new EqualsBuilder();
     * builder.append(field1, theOther.field1);
     * builder.append(field2, theOther.field2);
     * builder.append(field3, theOther.field3);
     * 
     * return builder.isEquals();
     * }
     */

    // gunakan reflection:
    /*
     * @Override
     * public boolean equals(Object obj) {
     * return EqualsBuilder.reflectionEquals(this, obj, false);
     * }
     */

    /*
     * parameter boolean adalah untuk menunjukkan apakah persamaan harus memeriksa
     * bidang sementara.
     * 
     * Menggunakan refleksi menghindari beberapa bidang:
     * 
     * @Override
     * public boolean equals(Object obj) {
     * return EqualsBuilder.reflectionEquals(this, obj, "field1", "field2");
     * }
     */
    // -----------------------------------

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ----------------------------------

    }
}
