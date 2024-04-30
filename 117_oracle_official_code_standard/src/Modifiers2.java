class Modifiers2 implements ExampleInterface {
    // Modifiers/Pengubah

    /*
     * class ExampleClass {
     * // Access modifiers first (don't do for instance "static public")
     * public static void main(String[] args) {
     * System.out.println("Hello World");
     * }
     * }
     * interface ExampleInterface {
     * // Avoid 'public' and 'abstract' since they are implicit
     * void sayHello();
     * }
     */

    // 1. Pengubah harus berada dalam urutan berikut
    /*
     * Access modifier (public / private / protected)
     * abstract
     * static
     * final
     * transient
     * volatile
     * default
     * synchronized
     * native
     * strictfp
     */

    /*
     * 2. Pengubah tidak boleh ditulis jika bersifat implisit. Misalnya, metode
     * antarmuka tidak boleh dinyatakan public atau abstract, dan enum serta
     * antarmuka bersarang tidak boleh dinyatakan statis.
     * 3. Parameter metode dan variabel lokal tidak boleh dinyatakan final kecuali
     * jika hal tersebut meningkatkan keterbacaan atau
     * mendokumentasikan keputusan desain aktual.
     * 4. Bidang harus dinyatakan final kecuali ada alasan kuat yang membuat bidang
     * tersebut dapat diubah.
     */

    public static void main(String[] args) throws Exception {
        Modifiers2 box = new Modifiers2();
        box.sayHello();
        /*
         * output:
         * Hello from ExampleInterface
         */
    }

    @Override
    public void sayHello() {
        System.out.println("Hello from ExampleInterface");

    }
}
