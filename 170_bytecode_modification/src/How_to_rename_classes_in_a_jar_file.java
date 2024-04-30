import java.io.File;
import java.util.HashMap;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class How_to_rename_classes_in_a_jar_file {
    // How to rename classes in a jar file/Cara mengganti nama kelas di file jar

    /*
     * public static void main(String[] args) throws Exception {
     * File jarFile = new File("Input.jar");
     * Map<String, ClassNode> nodes = JarUtils.loadClasses(jarFile);
     * 
     * Map<String, byte[]> out = JarUtils.loadNonClassEntries(jarFile);
     * Map<String, String> mappings = new HashMap<String, String>();
     * mappings.put("me/example/ExampleClass", "me/example/ExampleRenamed");
     * out.putAll(process(nodes, mappings));
     * JarUtils.saveAsJar(out, "Input-new.jar");
     * }
     * 
     * static Map<String, byte[]> process(Map<String, ClassNode> nodes, Map<String,
     * String> mappings) {
     * Map<String, byte[]> out = new HashMap<String, byte[]>();
     * Remapper mapper = new SimpleRemapper(mappings);
     * for (ClassNode cn : nodes.values()) {
     * ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
     * ClassVisitor remapper = new ClassRemapper(cw, mapper);
     * cn.accept(remapper);
     * out.put(mappings.containsKey(cn.name) ? mappings.get(cn.name) : cn.name,
     * cw.toByteArray());
     * }
     * return out;
     * }
     */

    /*
     * SimpleRemapper adalah kelas yang ada di perpustakaan ASM. Namun itu hanya
     * memungkinkan nama kelas diubah. Jika Anda ingin mengganti nama bidang dan
     * metode, Anda harus membuat implementasi kelas Remapper Anda sendiri.
     */
    public static void main(String[] args) throws Exception {
        File jarFile = new File("Input.jar");
        Map<String, ClassNode> nodes = JarUtils.loadClasses(jarFile);

        Map<String, byte[]> out = JarUtils.loadNonClassEntries(jarFile);
        Map<String, String> mappings = new HashMap<String, String>();
        mappings.put("me/example/ExampleClass", "me/example/ExampleRenamed");
        out.putAll(process(nodes, mappings));
        JarUtils.saveAsJar(out, "Input-new.jar");
    }

    static Map<String, byte[]> process(Map<String, ClassNode> nodes, Map<String, String> mappings) {
        Map<String, byte[]> out = new HashMap<String, byte[]>();
        Remapper mapper = new SimpleRemapper(mappings);
        for (ClassNode cn : nodes.values()) {
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            ClassVisitor remapper = new ClassRemapper(cw, mapper);
            cn.accept(remapper);
            out.put(mappings.containsKey(cn.name) ? mappings.get(cn.name) : cn.name, cw.toByteArray());
        }
        return out;
    }

}
