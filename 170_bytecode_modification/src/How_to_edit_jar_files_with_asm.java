import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.*;
import java.util.jar.*;

public class How_to_edit_jar_files_with_asm {
    // How to edit jar files with ASM/Cara mengedit file jar dengan ASM

    /*
     * Pertama, kelas dari toples perlu dimuat. Kami akan menggunakan tiga metode
     * untuk proses ini:
     * loadClasses(File)
     * readJar(JarFile, JarEntry, Map)
     * getNode(byte[])
     */

    /*
     * Map<String, ClassNode> loadClasses(File jarFile) throws IOException {
     * Map<String, ClassNode> classes = new HashMap<String, ClassNode>();
     * JarFile jar = new JarFile(jarFile);
     * Stream<JarEntry> str = jar.stream();
     * str.forEach(z -> readJar(jar, z, classes));
     * jar.close();
     * return classes;
     * }
     * Map<String, ClassNode> readJar(JarFile jar, JarEntry entry, Map<String,
     * ClassNode> classes) {
     * String name = entry.getName();
     * try (InputStream jis = jar.getInputStream(entry)){
     * if (name.endsWith(".class")) {
     * byte[] bytes = IOUtils.toByteArray(jis);
     * String cafebabe = String.format("%02X%02X%02X%02X", bytes[0], bytes[1],
     * bytes[2],
     * bytes[3]);
     * if (!cafebabe.toLowerCase().equals("cafebabe")) {
     * // This class doesn't have a valid magic
     * return classes;
     * }
     * try {
     * ClassNode cn = getNode(bytes);
     * classes.put(cn.name, cn);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * return classes;
     * }
     * ClassNode getNode(byte[] bytes) {
     * ClassReader cr = new ClassReader(bytes);
     * ClassNode cn = new ClassNode();
     * try {
     * cr.accept(cn, ClassReader.EXPAND_FRAMES);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * cr = null;
     * return cn;
     * }
     * 
     */

    /*
     * Dengan metode ini memuat dan mengubah file jar menjadi mudah dengan mengubah
     * ClassNodes di peta. Dalam contoh ini kita akan mengganti semua String di
     * toples dengan yang berhuruf besar menggunakan Tree API.
     */

    /*
     * File jarFile = new File("sample.jar");
     * Map<String, ClassNode> nodes = loadClasses(jarFile);
     * // Iterate ClassNodes
     * for (ClassNode cn : nodes.values()){
     * // Iterate methods in class
     * for (MethodNode mn : cn.methods){
     * // Iterate instructions in method
     * for (AbstractInsnNode ain : mn.instructions.toArray()){
     * // If the instruction is loading a constant value
     * if (ain.getOpcode() == Opcodes.LDC){
     * // Cast current instruction to Ldc
     * // If the constant is a string then capitalize it.
     * LdcInsnNode ldc = (LdcInsnNode) ain;
     * if (ldc.cst instanceof String){
     * ldc.cst = ldc.cst.toString().toUpperCase();
     * }
     * }
     * }
     * }
     * }
     */

    /*
     * Sekarang semua string ClassNode telah dimodifikasi, kita perlu menyimpan
     * perubahannya. Untuk menyimpan perubahan dan mendapatkan hasil yang berfungsi,
     * beberapa hal harus dilakukan:
     * 1. Export ClassNodes to bytes
     * 2. Load non-class jar entries (Ex: Manifest.mf / other binary resources in
     * jar) as bytes
     * 3. Save all bytes to a new jar
     */

    // Dari bagian terakhir di atas, kita akan membuat tiga metode.
    /*
     * 1. processNodes(Map<String, ClassNode> nodes)
     * 2. loadNonClasses(File jarFile)
     * 3. saveAsJar(Map<String, byte[]> outBytes, String fileName)
     */

    // pengguna:
    /*
     * Map<String, byte[]> out = process(nodes, new HashMap<String, MappedClass>());
     * out.putAll(loadNonClassEntries(jarFile));
     * saveAsJar(out, "sample-edit.jar");
     * 
     */

    // Metode yang digunakan
    /*
     * static Map<String, byte[]> processNodes(Map<String, ClassNode> nodes,
     * Map<String, MappedClass>
     * mappings) {
     * Map<String, byte[]> out = new HashMap<String, byte[]>();
     * // Iterate nodes and add them to the map of <Class names , Class bytes>
     * // Using Compute_Frames ensures that stack-frames will be re-calculated
     * automatically
     * for (ClassNode cn : nodes.values()) {
     * ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
     * out.put(mappings.containsKey(cn.name) ? mappings.get(cn.name).getNewName() :
     * cn.name,
     * cw.toByteArray());
     * }
     * return out;
     * }
     * static Map<String, byte[]> loadNonClasses(File jarFile) throws IOException {
     * Map<String, byte[]> entries = new HashMap<String, byte[]>();
     * ZipInputStream jis = new ZipInputStream(new FileInputStream(jarFile));
     * ZipEntry entry;
     * // Iterate all entries
     * while ((entry = jis.getNextEntry()) != null) {
     * try {
     * String name = entry.getName();
     * if (!name.endsWith(".class") && !entry.isDirectory()) {
     * // Apache Commons - byte[] toByteArray(InputStream input)
     * //
     * // Add each entry to the map <Entry name , Entry bytes>
     * byte[] bytes = IOUtils.toByteArray(jis);
     * entries.put(name, bytes);
     * }
     * } catch (Exception e) {
     * e.printStackTrace();
     * } finally {
     * jis.closeEntry();
     * }
     * }
     * jis.close();
     * return entries;
     * }
     * static void saveAsJar(Map<String, byte[]> outBytes, String fileName) {
     * try {
     * // Create jar output stream
     * JarOutputStream out = new JarOutputStream(new FileOutputStream(fileName));
     * // For each entry in the map, save the bytes
     * for (String entry : outBytes.keySet()) {
     * // Appent class names to class entries
     * String ext = entry.contains(".") ? "" : ".class";
     * out.putNextEntry(new ZipEntry(entry + ext));
     * out.write(outBytes.get(entry));
     * out.closeEntry();
     * }
     * out.close();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * 
     */

    // Itu dia. Semua perubahan akan disimpan ke "sample-edit.jar"
    public static void main(String[] args) {

        File jarFile = new File("sample.jar");
        Map<String, ClassNode> nodes = loadClasses(jarFile);

        // Iterate ClassNodes
        for (ClassNode cn : nodes.values()) {
            // Iterate methods in class
            for (MethodNode mn : cn.methods) {
                // Iterate instructions in method
                for (AbstractInsnNode ain : mn.instructions.toArray()) {
                    // If the instruction is loading a constant value
                    if (ain.getOpcode() == Opcodes.LDC) {
                        // Cast current instruction to Ldc
                        // If the constant is a string then capitalize it.
                        LdcInsnNode ldc = (LdcInsnNode) ain;
                        if (ldc.cst instanceof String) {
                            ldc.cst = ldc.cst.toString().toUpperCase();
                        }
                    }
                }
            }
        }
    }

    static Map<String, ClassNode> loadClasses(File jarFile) {
        Map<String, ClassNode> classes = new HashMap<>();
        try (JarFile jar = new JarFile(jarFile)) {
            jar.stream().forEach(entry -> readJar(jar, entry, classes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    static void readJar(JarFile jar, JarEntry entry, Map<String, ClassNode> classes) {
        String name = entry.getName();
        if (name.endsWith(".class")) {
            try (InputStream jis = jar.getInputStream(entry)) {
                byte[] bytes = IOUtils.toByteArray(jis);
                String cafebabe = String.format("%02X%02X%02X%02X", bytes[0], bytes[1], bytes[2], bytes[3]);
                if (!cafebabe.toLowerCase().equals("cafebabe")) {
                    // This class doesn't have a valid magic
                    return;
                }
                try {
                    ClassNode cn = getNode(bytes);
                    classes.put(cn.name, cn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static ClassNode getNode(byte[] bytes) {
        ClassReader cr = new ClassReader(bytes);
        ClassNode cn = new ClassNode();
        try {
            cr.accept(cn, ClassReader.EXPAND_FRAMES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

}
