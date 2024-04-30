public class Inherited_annotations {
    // Inherited Annotations

    /*
     * Secara default, anotasi kelas tidak berlaku untuk tipe yang memperluasnya.
     * Ini dapat diubah dengan menambahkan @Inherited
     * anotasi pada definisi anotasi
     */
    // contoh:
    // Pertimbangkan 2 Anotasi berikut:
    /*
     * @Inherited
     * 
     * @Target(ElementType.TYPE)
     * 
     * @Retention(RetentionPolicy.RUNTIME)
     * public @interface InheritedAnnotationType {
     * }
     * 
     * 
     * dan
     * 
     * @Target(ElementType.TYPE)
     * 
     * @Retention(RetentionPolicy.RUNTIME)
     * public @interface UninheritedAnnotationType {
     * }
     * 
     * 
     * 
     */

    // Jika tiga kelas diberi anotasi seperti ini:
    /*
     * @UninheritedAnnotationType
     * class A {
     * }
     * 
     * @InheritedAnnotationType
     * class B extends A {
     * }
     * class C extends B {
     * }
     * 
     */

    // menjalankan kode ini

    public static void main(String[] args) {
        // System.out.println(new
        // A().getClass().getAnnotation(InheritedAnnotationType.class));
        // System.out.println(new
        // B().getClass().getAnnotation(InheritedAnnotationType.class));
        // System.out.println(new
        // C().getClass().getAnnotation(InheritedAnnotationType.class));
        // System.out.println("_________________________________");
        // System.out.println(new
        // A().getClass().getAnnotation(UninheritedAnnotationType.class));
        // System.out.println(new
        // B().getClass().getAnnotation(UninheritedAnnotationType.class));
        // System.out.println(new
        // C().getClass().getAnnotation(UninheritedAnnotationType.class));
    }
    /*
     * output:
     * null
     * 
     * @InheritedAnnotationType()
     * 
     * @InheritedAnnotationType()
     * _________________________________
     * 
     * @UninheritedAnnotationType()
     * null
     * null
     */

    // Perhatikan bahwa anotasi hanya dapat diwarisi dari kelas, bukan antarmuka.
}
