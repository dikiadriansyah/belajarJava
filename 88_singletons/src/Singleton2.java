public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {

        // Atau pengaturan lain yang mungkin diperlukan saat pembuatan instansi
        System.out.println("Instansi Singleton dibuat!");
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
