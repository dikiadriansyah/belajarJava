
public class Implement_tostring_method {
    // Implement toString() method/Menerapkan metode toString()

    /*
     * Untuk mengimplementasikan metode toString suatu objek dengan mudah, Anda
     * dapat menggunakan kelas ToStringBuilder.
     * 
     * Memilih bidang:
     * 
     * @Override
     * public String toString() {
     * ToStringBuilder builder = new ToStringBuilder(this);
     * builder.append(field1);
     * builder.append(field2);
     * builder.append(field3);
     * 
     * return builder.toString();
     * }
     * 
     */

    // contoh hasil:
    // ar.com.jonat.lang.MyClass@dd7123[<null>,0,false]

    // Memberi nama secara eksplisit pada bidang:
    /*
     * @Override
     * public String toString() {
     * ToStringBuilder builder = new ToStringBuilder(this);
     * builder.append("field1",field1);
     * builder.append("field2",field2);
     * builder.append("field3",field3);
     * 
     * return builder.toString();
     * }
     */

    // contoh hasil:
    // ar.com.jonat.lang.MyClass@dd7404[field1=<null>,field2=0,field3=false]

    // Anda dapat mengubah gaya melalui parameter:
    /*
     * @Override
     * public String toString() {
     * ToStringBuilder builder = new ToStringBuilder(this,
     * ToStringStyle.MULTI_LINE_STYLE);
     * builder.append("field1", field1);
     * builder.append("field2", field2);
     * builder.append("field3", field3);
     * return builder.toString();
     * }
     */

    // contoh hasil:
    /*
     * ar.com.bna.lang.MyClass@ebbf5c[
     * field1=<null>
     * field2=0
     * field3=false
     * ]
     */

    /*
     * Ada beberapa gaya, misalnya JSON, tanpa Nama Kelas, pendek, dll...
     * Melalui refleksi:
     * 
     * @Override
     * public String toString() {
     * return ToStringBuilder.reflectionToString(this);
     * }
     */

    /*
     * Anda juga bisa menunjukkan gayanya:
     * 
     * @Override
     * public String toString() {
     * return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
     * }
     */

}
