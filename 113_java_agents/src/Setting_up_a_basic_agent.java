import java.lang.instrument.Instrumentation;

public class Setting_up_a_basic_agent {
    // Setting up a basic agent/Menyiapkan agen dasar

    /*
     * Kelas Premain akan berisi metode
     * "premain(String agentArgs Instrumentation inst)"
     * Berikut ini contohnya:
     * 
     * import java.lang.instrument.Instrumentation;
     * public class PremainExample {
     * public static void premain(String agentArgs, Instrumentation inst) {
     * System.out.println(agentArgs);
     * }
     * }
     * 
     */

    /*
     * Saat dikompilasi ke dalam file jar, buka Manifest dan pastikan ia memiliki
     * atribut Premain-Class.
     * 
     * Berikut ini contohnya:
     * Premain-Class: PremainExample
     */

    /*
     * Untuk menggunakan agen dengan program Java lain "myProgram" Anda harus
     * mendefinisikan agen dalam argumen JVM:
     * java -javaagent:PremainAgent.jar -jar myProgram.jar
     */

    public static void main(String agentArgs, Instrumentation inst) {
        System.out.println(agentArgs);
    }
}
