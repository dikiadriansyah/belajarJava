import java.util.*;

public class Adding_an_agent_at_runtime {
    // Adding an agent at runtime/Menambahkan agen saat runtime

    /*
     * Agen dapat ditambahkan ke JVM saat runtime. Untuk memuat agen, Anda perlu
     * menggunakan VirtualMachine.attatch(String id) dari API Lampirkan. Anda
     * kemudian dapat memuat toples agen yang dikompilasi dengan metode berikut:
     */

    /*
     * public static void loadAgent(String agentPath) {
     * String vmName = ManagementFactory.getRuntimeMXBean().getName();
     * int index = vmName.indexOf('@');
     * String pid = vmName.substring(0, index);
     * try {
     * File agentFile = new File(agentPath);
     * VirtualMachine vm = VirtualMachine.attach(pid);
     * vm.loadAgent(agentFile.getAbsolutePath(), "");
     * VirtualMachine.attach(vm.id());
     * } catch (Exception e) {
     * throw new RuntimeException(e);
     * }
     * }
     */

    /*
     * Ini tidak akan memanggil premain((String agentArgs, Instrumentation inst) di
     * agen yang dimuat, melainkan akan memanggil
     * agentmain(String agentArgs, Instrumentasi inst). Hal ini memerlukan
     * Agen-Kelas untuk diatur dalam agen Manifest.mf
     */

    public static void main(String[] args) throws Exception {
        String agentPath = "path/to/your/agent.jar";
        loadAgent(agentPath);
    }

    public static void loadAgent(String agentPath) {
        String vmName = ManagementFactory.getRuntimeMXBean().getName();
        int index = vmName.indexOf('@');
        String pid = vmName.substring(0, index);
        try {
            File agentFile = new File(agentPath);
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(agentFile.getAbsolutePath(), "");
            VirtualMachine.attach(vm.id());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
