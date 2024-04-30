public class These_are_the_basics {
    // These are the basics/Ini adalah dasar-dasarnya

    /*
     * JVM adalah mesin komputasi abstrak atau mesin Virtual yang berada di RAM
     * Anda. Ia memiliki lingkungan eksekusi platformindependen yang menafsirkan
     * bytecode Java menjadi kode mesin asli. (Javac adalah Java Compiler yang
     * mengkompilasi kode Java Anda menjadi Bytecode)
     * 
     * Program Java akan berjalan di dalam JVM yang kemudian dipetakan ke mesin
     * fisik yang mendasarinya. Ini adalah salah satu alat pemrograman di JDK.
     * 
     * (Kode byte adalah kode platform-independen yang dijalankan pada setiap
     * platform dan kode Mesin bersifat spesifik platform
     * kode yang dijalankan hanya pada platform tertentu seperti windows atau linux;
     * itu tergantung pada eksekusi.)
     * 
     * Beberapa komponen:
     * Class Loder - load the .class file into RAM.
     * Bytecode verifier - check whether there are any access restriction violations
     * in your code.
     * Execution engine - convert the byte code into executable machine code.
     * JIT(just in time) - JIT is part of JVM which used to improves the performance
     * of JVM.It will dynamically compile
     * or translate java bytecode into native machine code during execution time.
     * 
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
