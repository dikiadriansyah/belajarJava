import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class showing_reflection_and_other_hidden_frames {
    // Showing reflection and other hidden frames/Menampilkan refleksi dan bingkai
    // tersembunyi lainnya

    /*
     * Beberapa opsi lain memungkinkan pelacakan tumpukan menyertakan bingkai
     * implementasi dan/atau refleksi. Ini mungkin berguna untuk tujuan debugging.
     * Misalnya, kita dapat menambahkan opsi SHOW_REFLECT_FRAMES ke instance
     * StackWalker
     * setelah dibuat, sehingga bingkai untuk metode reflektif juga dicetak:
     * 
     * package test;
     * import java.lang.StackWalker.Option;
     * import java.lang.StackWalker.StackFrame;
     * import java.lang.reflect.InvocationTargetException;
     * import java.lang.reflect.Method;
     * import java.util.List;
     * import java.util.stream.Collectors;
     * public class StackWalkerExample {
     * public static void main(String[] args) throws NoSuchMethodException,
     * SecurityException,
     * IllegalAccessException, IllegalArgumentException, InvocationTargetException {
     * Method fooMethod = FooHelper.class.getDeclaredMethod("foo",
     * (Class<?>[])null);
     * fooMethod.invoke(null, (Object[]) null);
     * }
     * }
     * class FooHelper {
     * protected static void foo() {
     * BarHelper.bar();
     * }
     * }
     * class BarHelper {
     * protected static void bar() {
     * // show reflection methods
     * List<StackFrame> stack = StackWalker.getInstance(Option.SHOW_REFLECT_FRAMES)
     * .walk((s) -> s.collect(Collectors.toList()));
     * for(StackFrame frame : stack) {
     * System.out.println(frame.getClassName() + " " + frame.getLineNumber() + " " +
     * frame.getMethodName());
     * }
     * }
     * }
     * 
     */

    // hasil:
    /*
     * test.BarHelper 27 bar
     * test.FooHelper 20 foo
     * jdk.internal.reflect.NativeMethodAccessorImpl -2 invoke0
     * jdk.internal.reflect.NativeMethodAccessorImpl 62 invoke
     * jdk.internal.reflect.DelegatingMethodAccessorImpl 43 invoke
     * java.lang.reflect.Method 563 invoke
     * test.StackWalkerExample 14 main
     * 
     */

    /*
     * Perhatikan bahwa nomor baris untuk beberapa metode refleksi mungkin tidak
     * tersedia sehingga StackFrame.getLineNumber() dapat mengembalikan nilai
     * negatif.
     */

    public static void main(String[] args) throws Exception {
        Method fooMethod = FooHelper3.class.getDeclaredMethod("foo", (Class<?>[]) null);
        fooMethod.invoke(null, (Object[]) null);
        /*
         * output:
         * BarHelper3 12 bar
         * FooHelper3 3 foo
         * jdk.internal.reflect.NativeMethodAccessorImpl -2 invoke0
         * jdk.internal.reflect.NativeMethodAccessorImpl 62 invoke
         * jdk.internal.reflect.DelegatingMethodAccessorImpl 43 invoke
         * java.lang.reflect.Method 566 invoke
         * showing_reflection_and_other_hidden_frames 74 main
         */

    }
}
