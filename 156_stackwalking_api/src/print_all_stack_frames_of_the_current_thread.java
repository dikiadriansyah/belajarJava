import java.lang.StackWalker.StackFrame;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class print_all_stack_frames_of_the_current_thread {
    // Print all stack frames of the current thread/Cetak semua bingkai tumpukan
    // dari utas saat ini

    // Berikut ini mencetak semua frame tumpukan dari thread saat ini:

    /*
     * 1. package test;
     * 2
     * 3 import java.lang.StackWalker.StackFrame;
     * 4 import java.lang.reflect.InvocationTargetException;
     * 5 import java.lang.reflect.Method;
     * 6 import java.util.List;
     * 7 import java.util.stream.Collectors;
     * 8
     * 9 public class StackWalkerExample {
     * 10
     * 11 public static void main(String[] args) throws NoSuchMethodException,
     * SecurityException,
     * IllegalAccessException, IllegalArgumentException, InvocationTargetException {
     * 12 Method fooMethod = FooHelper.class.getDeclaredMethod("foo",
     * (Class<?>[])null);
     * 13 fooMethod.invoke(null, (Object[]) null);
     * 14 }
     * 15 }
     * 16
     * 17 class FooHelper {
     * 18 protected static void foo() {
     * 19 BarHelper.bar();
     * 20 }
     * 21 }
     * 22
     * 23 class BarHelper {
     * 24 protected static void bar() {
     * 25 List<StackFrame> stack = StackWalker.getInstance()
     * 26 .walk((s) -> s.collect(Collectors.toList()));
     * 27 for(StackFrame frame : stack) {
     * 28 System.out.println(frame.getClassName() + " " + frame.getLineNumber() +
     * " " +
     * frame.getMethodName());
     * 29 }
     * 30 }
     * 31 }
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ---------------
        Method fooMethod = FooHelper.class.getDeclaredMethod("foo", (Class<?>[]) null);
        fooMethod.invoke(null, (Object[]) null);
    }
}

class FooHelper {
    protected static void foo() {
        BarHelper.bar();
    }
}

class BarHelper {
    protected static void bar() {
        List<StackFrame> stack = StackWalker.getInstance()
                .walk((s) -> s.collect(Collectors.toList()));
        for (StackFrame frame : stack) {
            System.out.println(frame.getClassName() + " " + frame.getLineNumber() + " " +
                    frame.getMethodName());
        }
        /*
         * output:
         * BarHelper 70 bar
         * FooHelper 63 foo
         * print_all_stack_frames_of_the_current_thread 57 main
         */
    }
}
