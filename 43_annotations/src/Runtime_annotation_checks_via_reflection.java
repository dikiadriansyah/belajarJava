import java.util.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@interface MyDefaultAnnotation {
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRuntimeVisibleAnnotation {
}

public class Runtime_annotation_checks_via_reflection {
    // Runtime annotation checks via reflection / Pemeriksaan anotasi runtime
    // melalui refleksi

    /*
     * API Refleksi Java memungkinkan pemrogram untuk melakukan berbagai pemeriksaan
     * dan operasi pada bidang kelas, metode, dan
     * anotasi selama runtime. Namun, agar anotasi terlihat saat runtime,
     * RetentionPolicy harus diubah menjadi RUNTIME, seperti yang ditunjukkan pada
     * contoh di bawah:
     * 
     *
     * 
     */

    @MyDefaultAnnotation
    static class RuntimeCheck1 {
    }

    @MyRuntimeVisibleAnnotation
    static class RuntimeCheck2 {
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Annotation[] annotationsByType = RuntimeCheck1.class.getAnnotations();
        Annotation[] annotationsByType2 = RuntimeCheck2.class.getAnnotations();
        System.out.println("default retention: " + Arrays.toString(annotationsByType));
        System.out.println("runtime retention: " + Arrays.toString(annotationsByType2));
        /*
         * output:
         * default retention: []
         * runtime retention: [@MyRuntimeVisibleAnnotation()]
         */

    }
}
