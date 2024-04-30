public class Instantiating_a_generic_type {
    // Instantiating a generic type / Membuat instance tipe generik

    /*
     * public <T> void genericMethod() {
     * T t = new T(); // Can not instantiate the type T.
     * }
     */

    /*
     * Tipe T terhapus. Karena, pada saat runtime, JVM tidak mengetahui T aslinya,
     * sehingga tidak mengetahui yang mana konstruktor untuk dipanggil.
     */

    // Solusi
    /*
     * 1. Melewati kelas T saat memanggil Metode generik:
     * public <T> void genericMethod(Class<T> cls) {
     * try {
     * T t = cls.newInstance();
     * } catch (InstantiationException | IllegalAccessException e) {
     * System.err.println("Could not instantiate: " + cls.getName());
     * }
     * }
     * genericMethod(String.class);
     * 
     * Yang memunculkan pengecualian, karena tidak ada cara untuk mengetahui apakah
     * kelas yang diteruskan memiliki konstruktor default yang dapat diakses.
     * 
     * versi > java se 8
     * 2. Melewati referensi ke konstruktor T:
     * public <T> void genericMethod(Supplier<T> cons) {
     * T t = cons.get();
     * }
     * genericMethod(String::new);
     */

    public static <T> void genericMethod(Class<T> cls) {
        try {
            T t = cls.newInstance();
            System.out.println("Successfully instantiated: " + t.getClass().getName());
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Could not instantiate: " + cls.getName());
        }
    }

    public static void main(String[] args) {
        genericMethod(String.class);
        /*
         * output:
         * Successfully instantiated: java.lang.String
         */
    }
}
