import org.objectweb.asm.ClassWriter;

public class How_to_load_a_classnode_as_a_class {
    // How to load a ClassNode as a Class/Cara memuat ClassNode sebagai Kelas

    /*
     * // Load a class by from a ClassNode
     * //@param cn
     * //ClassNode to load
     * //@return
     * 
     * 
     * public static Class<?> load(ClassNode cn) {
     * ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
     * return new
     * ClassDefiner(ClassLoader.getSystemClassLoader()).get(cn.name.replace("/",
     * "."),
     * cw.toByteArray());
     * }
     * 
     */

    // Classloader that loads a class from bytes.
    /*
     * static class ClassDefiner extends ClassLoader {
     * public ClassDefiner(ClassLoader parent) {
     * super(parent);
     * }
     * public Class<?> get(String name, byte[] bytes) {
     * Class<?> c = defineClass(name, bytes, 0, bytes.length);
     * resolveClass(c);
     * return c;
     * }
     * }
     */
    public static void main(String[] args) {
        // Membuat contoh pohon kelas
        ClassNode classNode = new ClassNode("com.example.MyClass");

        // Memuat kelas dari pohon kelas
        Class<?> loadedClass = load(classNode);

        // Menampilkan informasi tentang kelas yang dimuat
        System.out.println("Loaded class: " + loadedClass.getName());
    }

    public static Class<?> load(ClassNode cn) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        return new ClassDefiner(ClassLoader.getSystemClassLoader()).get(cn.name.replace("/", "."), cw.toByteArray());
    }

    static class ClassDefiner extends ClassLoader {
        public ClassDefiner(ClassLoader parent) {
            super(parent);
        }

        public Class<?> get(String name, byte[] bytes) {
            Class<?> c = defineClass(name, bytes, 0, bytes.length);
            resolveClass(c);
            return c;
        }
    }

    static class ClassNode {
        String name;

        public ClassNode(String name) {
            this.name = name;
        }
    }

}
