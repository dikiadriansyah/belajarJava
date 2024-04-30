public class print_current_caller_class {
    // Print current caller class/Cetak kelas penelepon saat ini

    /*
     * Berikut ini mencetak kelas pemanggil saat ini. Perhatikan bahwa dalam kasus
     * ini, StackWalker perlu dibuat dengan opsi RETAIN_CLASS_REFERENCE, sehingga
     * instance Class dipertahankan dalam objek StackFrame. Kalau tidak,
     * pengecualian akan terjadi.
     */

    /*
     * public class StackWalkerExample {
     * public static void main(String[] args) {
     * FooHelper.foo();
     * }
     * }
     * class FooHelper {
     * protected static void foo() {
     * BarHelper.bar();
     * }
     * }
     * class BarHelper {
     * protected static void bar() {
     * 
     * System.out.println(StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).
     * getCallerClass());
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        FooHelper2.foo();
        // output: class FooHelper2
    }
}
