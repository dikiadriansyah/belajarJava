public class Implement_hashcode_method {
    // Implement hashCode() method/Menerapkan metode hashCode()

    /*
     * Untuk mengimplementasikan metode hashCode suatu objek dengan mudah, Anda
     * dapat menggunakan kelas HashCodeBuilder.
     * 
     * Memilih bidang:
     * 
     * @Override
     * public int hashCode() {
     * 
     * HashCodeBuilder builder = new HashCodeBuilder();
     * builder.append(field1);
     * builder.append(field2);
     * builder.append(field3);
     * 
     * return builder.hashCode();
     * }
     */

    // gunakan reflection
    /*
     * @Override
     * public int hashCode() {
     * return HashCodeBuilder.reflectionHashCode(this, false);
     * }
     */

    /*
     * parameter boolean menunjukkan apakah harus menggunakan bidang sementara.
     * 
     * Menggunakan refleksi menghindari beberapa bidang:
     * 
     * @Override
     * public int hashCode() {
     * return HashCodeBuilder.reflectionHashCode(this, "field1", "field2");
     * }
     */

}
