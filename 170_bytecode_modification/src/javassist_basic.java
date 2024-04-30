import java.lang.instrument.Instrumentation;

public class javassist_basic {
    // Javassist Basic/Dasar Javassist

    /*
     * Javassist adalah pustaka instrumentasi bytecode yang memungkinkan Anda
     * memodifikasi kode Java yang memasukkan bytecode yang akan dikonversi menjadi
     * bytecode oleh Javassist dan ditambahkan ke kelas/metode yang diinstrumentasi
     * saat runtime.
     * 
     * Mari kita tulis trafo pertama yang benar-benar mengambil kelas hipotetis
     * "com.my.to.be.instrumented.MyClass" dan
     * tambahkan ke instruksi setiap metode panggilan log.
     */

    /*
     * import java.lang.instrument.ClassFileTransformer;
     * import java.lang.instrument.IllegalClassFormatException;
     * import java.security.ProtectionDomain;
     * import javassist.ClassPool;
     * import javassist.CtClass;
     * import javassist.CtMethod;
     * public class DynamicTransformer implements ClassFileTransformer {
     * public byte[] transform(ClassLoader loader, String className, Class
     * classBeingRedefined,
     * ProtectionDomain protectionDomain, byte[] classfileBuffer) throws
     * IllegalClassFormatException {
     * byte[] byteCode = classfileBuffer;
     * // into the transformer will arrive every class loaded so we filter
     * 
     * // to match only what we need
     * if (className.equals("com/my/to/be/instrumented/MyClass")) {
     * try {
     * // retrive default Javassist class pool
     * ClassPool cp = ClassPool.getDefault();
     * // get from the class pool our class with this qualified name
     * CtClass cc = cp.get("com.my.to.be.instrumented.MyClass");
     * // get all the methods of the retrieved class
     * CtMethod[] methods = cc.getDeclaredMethods()
     * for(CtMethod meth : methods) {
     * // The instrumentation code to be returned and injected
     * final StringBuffer buffer = new StringBuffer();
     * String name = meth.getName();
     * // just print into the buffer a log for example
     * buffer.append("System.out.println(\"Method " + name + " executed\" );");
     * meth.insertBefore(buffer.toString())
     * }
     * // create the byteclode of the class
     * byteCode = cc.toBytecode();
     * // remove the CtClass from the ClassPool
     * cc.detach();
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * }
     * return byteCode;
     * }
     * }
     * 
     */

    /*
     * Sekarang untuk menggunakan transformator ini (sehingga JVM kita akan
     * memanggil metode transformasi pada setiap kelas pada waktu muat) kita perlu
     * menambahkan instrumen ini atau ini dengan agen:
     * 
     * import java.lang.instrument.Instrumentation;
     * public class EasyAgent {
     * public static void premain(String agentArgs, Instrumentation inst) {
     * 
     * // registers the transformer
     * inst.addTransformer(new DynamicTransformer());
     * }
     * }
     */

    /*
     * Langkah terakhir untuk memulai eksperimen instrumentor pertama kita adalah
     * mendaftarkan kelas agen ini ke eksekusi mesin JVM. Cara termudah untuk
     * melakukannya adalah dengan mendaftarkannya dengan opsi ke dalam perintah
     * shell:
     * 
     * java -javaagent:myAgent.jar MyJavaApplication
     */

    /*
     * Seperti yang bisa kita lihat, proyek agen/transformator ditambahkan sebagai
     * toples ke eksekusi aplikasi apa pun yang diberi nama
     * Aplikasi MyJava yang seharusnya berisi kelas bernama
     * "com.my.to.be.instrumented.MyClass" untuk benar-benar
     * jalankan kode yang kami masukkan.
     */
    public static void premain(String agentArgs, Instrumentation inst) {

        // registers the transformer
        inst.addTransformer(new DynamicTransformer());
    }
}
