public class Lambda_expression {
    // Lambda Expressions/Ekspresi Lambda

    /*
     * Runnable r = () -> System.out.println("Hello World");
     * Supplier<String> c = () -> "Hello World";
     * 
     * // Collection::contains is a simple unary method and its behavior is
     * // clear from the context. A method reference is preferred here.
     * appendFilter(goodStrings::contains);
     * 
     * // A lambda expression is easier to understand than just tempMap::put in this
     * case
     * trackTemperature((time, temp) -> tempMap.put(time, temp));
     * 
     * 
     */

    /*
     * 1. Lambda ekspresi lebih disukai daripada lambda blok satu baris.
     * 2. Referensi metode umumnya lebih diutamakan daripada ekspresi lambda.
     * 3. Untuk referensi metode instance terikat, atau metode dengan arity lebih
     * besar dari satu, ekspresi lambda mungkin lebih mudah dipahami dan oleh karena
     * itu lebih disukai. Apalagi jika perilaku metode tersebut tidak jelas dari
     * konteksnya.
     * 4. Jenis parameter harus dihilangkan kecuali jika meningkatkan keterbacaan.
     * 5. Jika ekspresi lambda membentang lebih dari beberapa baris, pertimbangkan
     * untuk membuat metode.
     */
    public static void main(String[] args) throws Exception {

    }
}
