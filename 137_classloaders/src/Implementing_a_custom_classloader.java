public class Implementing_a_custom_classloader {
    // Implementing a custom classLoader/Menerapkan classLoader khusus

    /*
     * Setiap custom loader harus secara langsung atau tidak langsung memperluas
     * kelas java.lang.ClassLoader. Poin ekstensi utama adalah metode berikut:
     * 
     * 1. findClass(String) - membebani metode ini jika pemuat kelas Anda mengikuti
     * model delegasi standar untuk pemuatan kelas.
     * 2. loadClass(String, boolean) - membebani metode ini secara berlebihan untuk
     * mengimplementasikan model delegasi alternatif.
     * 3. findResource dan findResources - bebankan metode ini secara berlebihan
     * untuk menyesuaikan pemuatan sumber daya
     */

    /*
     * Metode defineClass yang bertanggung jawab untuk memuat kelas dari array byte
     * bersifat final untuk mencegah kelebihan beban. Perilaku khusus apa pun perlu
     * dilakukan sebelum memanggil defineClass.
     * 
     * Berikut ini adalah cara sederhana yang memuat kelas tertentu dari array byte:
     * 
     * public class ByteArrayClassLoader extends ClassLoader {
     * private String classname;
     * private byte[] classfile;
     * public ByteArrayClassLoader(String classname, byte[] classfile) {
     * this.classname = classname;
     * this.classfile = classfile.clone();
     * }
     * 
     * @Override
     * protected Class findClass(String classname) throws ClassNotFoundException {
     * if (classname.equals(this.classname)) {
     * return defineClass(classname, classfile, 0, classfile.length);
     * } else {
     * throw new ClassNotFoundException(classname);
     * }
     * }
     * }
     */

    /*
     * Karena kita hanya mengganti metode findClass, pemuat kelas khusus ini akan
     * berperilaku sebagai berikut ketika loadClass dipanggil.
     * 1. Metode loadClass classloader memanggil findLoadedClass untuk melihat
     * apakah kelas dengan nama ini telah dimuat oleh classloader ini. Jika
     * berhasil, Class objek yang dihasilkan dikembalikan ke pemohon.
     * 2. Metode loadClass kemudian mendelegasikan ke classloader induk dengan
     * memanggil panggilan loadClass-nya. Jika induk dapat menangani permintaan
     * tersebut, ia akan mengembalikan Class objek yang kemudian dikembalikan ke
     * pemohon.
     * 3. Jika pemuat kelas induk tidak dapat memuat kelas, findClass kemudian
     * memanggil metode findClass pengganti kami, meneruskan nama kelas yang akan
     * dimuat.
     * 4. Jika nama yang diminta cocok dengan this.classname, kami memanggil
     * defineClass untuk memuat kelas sebenarnya dari
     * array byte this.classfile. Objek Kelas yang dihasilkan kemudian dikembalikan.
     * 5. Jika namanya tidak cocok, kita membuang ClassNotFoundException.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
