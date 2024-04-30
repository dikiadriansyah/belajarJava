import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

public class Modifying_classes_with_agents {
    // Modifying classes with agents/Memodifikasi kelas dengan agen

    // Pertama, pastikan agen yang digunakan memiliki atribut berikut di
    // Manifest.mf:
    /*
     * Can-Redefine-Classes: true
     * Can-Retransform-Classes: true
     */

    /*
     * Memulai agen java akan membiarkan agen mengakses kelas Instrumentasi. Dengan
     * Instrumentasi Anda dapat menelepon
     * addTransformer(ClassFileTransformer transformer). ClassFileTransformers
     * akan membiarkan Anda menulis ulang byte kelas. Itu
     * kelas hanya memiliki satu metode yang memasok ClassLoader yang memuat kelas,
     * nama kelas, instance java.lang.Class, ProtectionDomain, dan terakhir byte
     * kelas itu sendiri.
     * 
     * Ini terlihat seperti ini:
     * byte[] transform(ClassLoader loader, String className, Class<?>
     * classBeingRedefined,
     * ProtectionDomain protectionDomain, byte[] classfileBuffer)
     */

    /*
     * Memodifikasi kelas murni dari byte bisa memakan waktu lama. Untuk
     * mengatasinya, terdapat perpustakaan yang dapat digunakan untuk mengubah byte
     * kelas menjadi sesuatu yang lebih bermanfaat.
     * 
     * Dalam contoh ini saya akan menggunakan ASM, namun alternatif lain seperti
     * Javassist dan BCEL memiliki fitur serupa
     */

    /*
     * ClassNode getNode(byte[] bytes) {
     * // Create a ClassReader that will parse the byte array into a ClassNode
     * ClassReader cr = new ClassReader(bytes);
     * ClassNode cn = new ClassNode();
     * try {
     * // This populates the ClassNode
     * cr.accept(cn, ClassReader.EXPAND_FRAMES);
     * cr = null;
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * return cn;
     * }
     */

    /*
     * Dari sini perubahan dapat dilakukan pada objek ClassNode. Hal ini membuat
     * perubahan akses bidang/metode menjadi sangat mudah.
     * Ditambah dengan Tree API ASM, memodifikasi bytecode metode sangatlah mudah.
     * 
     * Setelah pengeditan selesai, Anda dapat mengubah ClassNode kembali menjadi
     * byte dengan metode berikut dan mengembalikannya dalam metode transformasi:
     * 
     * public static byte[] getNodeBytes(ClassNode cn, boolean useMaxs) {
     * ClassWriter cw = new ClassWriter(useMaxs ? ClassWriter.COMPUTE_MAXS :
     * ClassWriter.COMPUTE_FRAMES);
     * cn.accept(cw);
     * byte[] b = cw.toByteArray();
     * return b;
     * }
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------

        // Buat sebuah objek ClassNode (contoh saja)
        ClassNode classNode = new ClassNode();

        // Panggil metode getNodeBytes untuk mendapatkan array byte
        byte[] resultBytes = getNodeBytes(classNode, true);

        // Cetak hasilnya
        System.out.println("Resulting bytes:");
        for (byte b : resultBytes) {
            System.out.print(b + " ");
        }
    }

    public static byte[] getNodeBytes(ClassNode cn, boolean useMaxs) {
        ClassWriter cw = new ClassWriter(useMaxs ? ClassWriter.COMPUTE_MAXS : ClassWriter.COMPUTE_FRAMES);
        cn.accept(cw);
        byte[] b = cw.toByteArray();
        return b;
    }

}
