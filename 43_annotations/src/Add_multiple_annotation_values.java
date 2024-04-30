import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface SuppressWarnings {
    String[] value();
}

@SuppressWarnings({ "unused", "javadoc" })
public class Add_multiple_annotation_values {
    // Add multiple annotation values / Tambahkan beberapa nilai anotasi

    /*
     * Parameter Anotasi dapat menerima beberapa nilai jika didefinisikan sebagai
     * array. Misalnya saja standarnya
     * anotasi @SuppressWarnings didefinisikan seperti ini:
     * public @interface SuppressWarnings {
     * String[] value();
     * }
     * 
     * Parameter nilai adalah array String. Anda dapat menetapkan beberapa nilai
     * dengan menggunakan notasi yang mirip dengan inisialisasi Array:
     * 
     * @SuppressWarnings({"unused"})
     * 
     * @SuppressWarnings({"unused", "javadoc"})
     * 
     * Jika Anda hanya perlu menetapkan satu nilai, tanda kurung dapat dihilangkan:
     * 
     * @SuppressWarnings("unused")
     */

    public static void main(String[] args) {
        System.out.println("Hello, World!"); // hello world!
    }
}
