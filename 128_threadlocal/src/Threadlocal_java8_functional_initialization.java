import java.text.SimpleDateFormat;
import java.util.Date;

public class Threadlocal_java8_functional_initialization {
    // ThreadLocal Java 8 functional initialization/Threadlocal Java 8 Inisialisasi
    // Fungsional

    /*
     * public static class ThreadLocalExample
     * {
     * private static final ThreadLocal<SimpleDateFormat> format =
     * ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd_HHmm"));
     * public String formatDate(Date date)
     * {
     * return format.get().format(date);
     * }
     * }
     */
    // ----------------------------
    public static class ThreadLocalExample {
        private static final ThreadLocal<SimpleDateFormat> format = ThreadLocal
                .withInitial(() -> new SimpleDateFormat("yyyyMMdd_HHmm"));

        public String formatDate(Date date) {
            return format.get().format(date);
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalExample example = new ThreadLocalExample();
        Date currentDate = new Date();
        String formattedDate = example.formatDate(currentDate);
        System.out.println("Formatted Date: " + formattedDate);// output: Formatted Date: 20240308_0953
    }
}
