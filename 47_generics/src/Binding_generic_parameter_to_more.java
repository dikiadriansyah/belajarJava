import java.io.Closeable;
import java.io.Flushable;

class Binding_generic_parameter_to_more<T extends Flushable & Closeable> {
    // Binding generic parameter to more than 1 type

    /*
     * Parameter generik juga dapat diikat ke lebih dari satu tipe menggunakan
     * sintaks T extends Type1 & Type2 & ....
     * 
     * Katakanlah Anda ingin membuat kelas yang tipe Generiknya harus
     * mengimplementasikan Flushable dan Closeable, Anda bisa menulis
     * 
     * class ExampleClass<T extends Flushable & Closeable> {
     * }
     * 
     */

    // Sekarang, ContohKelas hanya menerima sebagai parameter generik, tipe yang
    // mengimplementasikan Flushable dan Closeable
    /*
     * ExampleClass<BufferedWriter> arg1; // Works because BufferedWriter implements
     * both Flushable and
     * Closeable
     * ExampleClass<Console> arg4; // Does NOT work because Console only implements
     * Flushable
     * ExampleClass<ZipFile> arg5; // Does NOT work because ZipFile only implements
     * Closeable
     * ExampleClass<Flushable> arg2; // Does NOT work because Closeable bound is not
     * satisfied.
     * ExampleClass<Closeable> arg3; // Does NOT work because Flushable bound is not
     * satisfied.
     * 
     */

    // Metode kelas dapat memilih untuk menyimpulkan argumen tipe generik sebagai
    // Closeable atau Flushable.

    /*
     * 
     */

    // Catatan:
    /*
     * Anda tidak dapat mengikat parameter generik ke salah satu tipe menggunakan
     * klausa OR (|). Hanya klausa AND (&) yang didukung. Tipe generik hanya dapat
     * memperluas satu kelas dan banyak antarmuka. Kelas harus ditempatkan di awal
     * daftar.
     */

    public void test(T param) {
        Flushable arg1 = param; // Works
        Closeable arg2 = param; // Works too.
    }

    // public void test2(T param) {
    // param.flush(); // Method of Flushable called on T and works fine.
    // param.close(); // Method of Closeable called on T and works fine too.
    // }

    public static void main(String[] args) {
        Binding_generic_parameter_to_more<MyClass> example = new Binding_generic_parameter_to_more<>();
        example.test(new MyClass());
        // example.test2(new MyClass());
    }

}
