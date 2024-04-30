public class running_an_executable_jar_file {
    // Running an executable JAR file / Menjalankan file JAR yang dapat dieksekusi

    // File JAR yang dapat dieksekusi adalah cara paling sederhana untuk menyusun
    // kode java menjadi satu file yang dapat dieksekusi. *(Catatan Editorial:
    // Pembuatan file JAR harus dicakup oleh Topik terpisah.) *.

    // dengan asumsi anda memiliki file JAR yang dapat dieksekusi dengan nama path
    // <jar-path>, anda seharusnya dapat menjalankannya sebagai berikut:

    // java -jar <jar-path>

    // jika perintah memerlukan argumen baris perintah, tambahkan setelah
    // <jar-path>. sebagai contoh:
    // java -jar <jar-path> arg1 arg2 arg3

    // jika anda perlu memberikan opsi JVM tambahan pada baris perintah Java, mereka
    // harus pergi sebelum -jar option.
    // perhatikan bahwa opsi -cp/ -classpath akan diabaikan jika anda menggunakan
    // -jar. Classpath aplikasi ditentukan oleh JAR file manifes.

}
