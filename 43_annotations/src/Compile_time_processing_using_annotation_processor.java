
// import annotation.Setter;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({ "annotation.Setter" })
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Compile_time_processing_using_annotation_processor {
    // Compile time processing using annotation processor / Kompilasi pemrosesan
    // waktu menggunakan prosesor anotasi

    /*
     * Contoh ini mendemonstrasikan cara melakukan pemeriksaan waktu kompilasi pada
     * elemen yang diberi anotasi
     */

    // The Annotation
    /*
     * Anotasi @Setter adalah penanda yang dapat diterapkan pada metode. Anotasi
     * akan dibuang selama kompilasi tidak tersedia setelahnya.
     * 
     * package annotation;
     * import java.lang.annotation.ElementType;
     * import java.lang.annotation.Retention;
     * import java.lang.annotation.RetentionPolicy;
     * import java.lang.annotation.Target;
     * 
     * @Retention(RetentionPolicy.SOURCE)
     * 
     * @Target(ElementType.METHOD)
     * public @interface Setter {
     * }
     * 
     */

    // The annotation processor
    /*
     * Kelas SetterProcessor digunakan oleh kompiler untuk memproses anotasi. Ia
     * memeriksa, apakah metodenya dijelaskan
     * dengan anotasi @Setter adalah metode publik dan non-statis dengan nama yang
     * dimulai dengan set dan memiliki huruf besar sebagai huruf ke-4. Jika salah
     * satu kondisi ini tidak terpenuhi, kesalahan ditulis ke Messager. Kompiler
     * menulis ini ke stderr, tetapi alat lain dapat menggunakan informasi ini
     * secara berbeda. Misalnya. NetBeans IDE memungkinkan pengguna menentukan
     * prosesor anotasi yang digunakan untuk menampilkan pesan kesalahan di editor.
     */

    // private Messager messager;

    // @Override
    // public boolean process(Set<? extends TypeElement> annotations,
    // RoundEnvironment roundEnv) {
    // // get elements annotated with the @Setter annotation
    // Set<? extends Element> annotatedElements =
    // roundEnv.getElementsAnnotatedWith(annotation.Setter.class);
    // for (Element element : annotatedElements) {
    // if (element.getKind() == ElementKind.METHOD) {
    // // only handle methods as targets
    // checkMethod((ExecutableElement) element);
    // }
    // }
    // // don't claim annotations to allow other processors to process them
    // return false;
    // }

    // private void checkMethod(ExecutableElement method) {
    // // check for valid name
    // String name = method.getSimpleName().toString();
    // if (!name.startsWith("set")) {
    // printError(method, "setter name must start with \"set\"");
    // } else if (name.length() == 3) {
    // printError(method, "the method name must contain more than just \"set\"");
    // } else if (Character.isLowerCase(name.charAt(3))) {
    // if (method.getParameters().size() != 1) {
    // printError(method, "character following \"set\" must be upper case");
    // }
    // }

    // // check if setter is public
    // if (!method.getModifiers().contains(Modifier.PUBLIC)) {
    // printError(method, "setter must be public");
    // }

    // // check if method is static
    // if (method.getModifiers().contains(Modifier.STATIC)) {
    // printError(method, "setter must not be static");
    // }
    // }

    // private void printError(Element element, String message) {
    // messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    // }

    // packaging
    /*
     * Agar dapat diterapkan oleh kompiler, pemroses anotasi harus tersedia untuk
     * SPI (lihat ServiceLoader).
     * 
     * Untuk melakukan ini, file teks
     * META-INF/services/javax.annotation.processing.Processor perlu ditambahkan ke
     * file jar yang berisi pemroses anotasi dan anotasi di samping file lainnya.
     * File tersebut perlu disertakan
     * nama pemroses anotasi yang sepenuhnya memenuhi syarat, yaitu akan terlihat
     * seperti ini
     * 
     * annotation.processor.SetterProcessor
     * 
     * Kami akan berasumsi file jar bernama AnnotationProcessor.jar di bawah.
     */

    // Example annotated class(Contoh kelas beranotasi)
    /*
     * Kelas berikut adalah kelas contoh dalam paket default dengan anotasi
     * diterapkan ke elemen yang benar sesuai dengan kebijakan penyimpanan. Namun
     * hanya pemroses anotasi yang menganggap metode kedua sebagai target anotasi
     * yang valid.
     * import annotation.Setter;
     * public class AnnotationProcessorTest {
     * 
     * @Setter
     * private void setValue(String value) {}
     * 
     * @Setter
     * public void setString(String value) {}
     * 
     * @Setter
     * public static void main(String[] args) {}
     * 
     * }
     * 
     */

    // Using the annotation processor with javac(Menggunakan pemroses anotasi dengan
    // javac)
    /*
     * Jika pemroses anotasi ditemukan menggunakan SPI, maka secara otomatis
     * digunakan untuk memproses elemen yang dianotasi. Misalnya.
     * mengkompilasi kelas AnnotationProcessorTest menggunakan
     */
    // javac -cp AnnotationProcessor.jar AnnotationProcessorTest.java

    /*
     * menghasilkan output berikut
     * AnnotationProcessorTest.java:6: error: setter must be public
     * private void setValue(String value) {}
     * ^
     * AnnotationProcessorTest.java:12: error: setter name must start with "set"
     * public static void main(String[] args) {}
     * ^
     * 2 errors
     * 
     * 
     * alih-alih mengkompilasi secara normal. Tidak ada file .class yang dibuat.
     * 
     * Hal ini dapat dicegah dengan menentukan opsi -proc:none untuk javac. Anda
     * juga bisa melupakan kompilasi biasa
     * dengan menentukan -proc:only sebagai gantinya.
     * 
     * IDE integration
     * Netbeans
     * 
     * Pemroses anotasi dapat digunakan di editor NetBeans. Untuk melakukan ini,
     * pemroses anotasi perlu ditentukan dalam pengaturan proyek:
     * 1. buka Project Properties > Build > Compiling
     * 2. tambahkan tanda centang untuk Enable Annotation Processing and Enable
     * Annotation Processing in Editor
     * 3. klik add di samping daftar pemroses anotasi
     * 4. pada popup yang muncul masukkan nama kelas prosesor anotasi yang
     * sepenuhnya memenuhi syarat dan klik Ok.
     * 
     * 
     */

    public static void main(String[] args) {
    }
}
