import java.lang.annotation.*;
import java.util.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String key() default "foo";

    String value() default "bar";
}

public class Getting_annotation_values_at_runtime {
    // Getting Annotation values at run-time / Mendapatkan nilai Anotasi saat
    // run-time
    /*
     * Anda dapat mengambil properti Anotasi saat ini dengan menggunakan Refleksi
     * untuk mengambil Method, Field, atau class
     * yang memiliki Anotasi yang diterapkan padanya, dan kemudian mengambil
     * properti yang diinginkan
     * 
     * @Retention(RetentionPolicy.RUNTIME)
     * 
     * @interface MyAnnotation {
     * String key() default "foo";
     * String value() default "bar";
     * }
     * 
     */

    // Put the Annotation on the method, but leave the defaults
    @MyAnnotation
    public void testDefaults() throws Exception {
        // Using reflection, get the public method "testDefaults", which is this method
        // with no args
        Method method = Getting_annotation_values_at_runtime.class.getMethod("testDefaults", null);
        // Fetch the Annotation that is of type MyAnnotation from the Method
        MyAnnotation annotation = (MyAnnotation) method.getAnnotation(MyAnnotation.class);
        // Print out the settings of the Annotation
        print(annotation);
    }

    // Put the Annotation on the method, but override the settings
    @MyAnnotation(key = "baz", value = "buzz")
    public void testValues() throws Exception {
        // Using reflection, get the public method "testValues", which is this method
        // with no args
        Method method = Getting_annotation_values_at_runtime.class.getMethod("testValues", null);
        // Fetch the Annotation that is of type MyAnnotation from the Method
        MyAnnotation annotation = (MyAnnotation) method.getAnnotation(MyAnnotation.class);
        // Print out the settings of the Annotation
        print(annotation);
    }

    public void print(MyAnnotation annotation) {
        // Fetch the MyAnnotation 'key' & 'value' properties, and print them out
        System.out.println(annotation.key() + " = " + annotation.value());
    }

    public static void main(String[] args) {
        Getting_annotation_values_at_runtime example = new Getting_annotation_values_at_runtime();
        try {
            example.testDefaults();
            example.testValues();
        } catch (Exception e) {
            // Shouldn't throw any Exceptions
            System.err.println("Exception [" + e.getClass().getName() + "] - " + e.getMessage());
            e.printStackTrace(System.err);
        }
        /*
         * output:
         * foo = bar
         * baz = buzz
         */

    }
}
