import java.nio.ByteBuffer;

public class Basic_usage_write_data_to_the_buffer {
    // Basic Usage - Write Data to the Buffer/Penggunaan Dasar - Tulis Data ke
    // Buffer

    /*
     * Dengan adanya instance ByteBuffer, seseorang dapat menulis data tipe primitif
     * menggunakan put relatif dan absolut. Perbedaan yang mencolok adalah
     * menempatkan data menggunakan metode relatif melacak indeks tempat data
     * dimasukkan untuk Anda,
     * sedangkan metode absolut selalu mengharuskan pemberian indeks untuk
     * meletakkan datanya.
     * 
     * Kedua metode ini mengizinkan panggilan "chaining". Dengan adanya buffer
     * berukuran cukup, seseorang dapat melakukan hal berikut:
     * buffer.putInt(0xCAFEBABE).putChar('c').putFloat(0.25).putLong(
     * 0xDEADBEEFCAFEBABE);
     * 
     */

    // yang setara dengan:
    /*
     * buffer.putInt(0xCAFEBABE);
     * buffer.putChar('c');
     * buffer.putFloat(0.25);
     * buffer.putLong(0xDEADBEEFCAFEBABE);
     * 
     */

    /*
     * Perhatikan bahwa metode yang beroperasi pada byte tidak diberi nama khusus.
     * Selain itu, perhatikan bahwa meneruskan ByteBuffer dan byte[] juga valid
     * untuk dimasukkan. Selain itu, semua tipe primitif memiliki metode put khusus.
     * 
     * Catatan tambahan: Indeks yang diberikan saat menggunakan absolute put* selalu
     * dihitung dalam byte.
     */

    public static void main(String[] args) throws Exception {
        // Membuat ByteBuffer dengan kapasitas total 24 byte (4 + 2 + 4 + 8 = 18 byte)
        ByteBuffer buffer = ByteBuffer.allocate(24);

        // Menambahkan data ke dalam ByteBuffer
        buffer.putInt(0xCAFEBABE);
        buffer.putChar('c');
        buffer.putFloat(0.25f);
        buffer.putLong(0xDEADBEEFCAFEBABEL);

        // Mengatur posisi buffer ke awal
        buffer.flip();

        // Membaca data dari ByteBuffer sesuai dengan tipe datanya
        int intValue = buffer.getInt();
        char charValue = buffer.getChar();
        float floatValue = buffer.getFloat();
        long longValue = buffer.getLong();

        // Menampilkan nilai-nilai yang dibaca
        System.out.println("Int Value: " + intValue); // output: Int Value: -889275714
        System.out.println("Char Value: " + charValue); // output: Char Value: c
        System.out.println("Float Value: " + floatValue); // output: Float Value: 0.25
        System.out.println("Long Value: " + longValue); // output: Long Value: -2401053089206453570

    }
}
