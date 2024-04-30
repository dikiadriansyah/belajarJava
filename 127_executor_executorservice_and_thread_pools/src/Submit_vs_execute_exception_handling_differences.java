import java.util.concurrent.*;
import java.util.*;

public class Submit_vs_execute_exception_handling_differences {
    // submit() vs execute() exception handling differences/perbedaan penanganan
    // pengecualian submit() vs mengeksekusi()

    /*
     * Umumnya perintah eksekusi() digunakan untuk panggilan api dan lupakan (tanpa
     * perlu menganalisis result) dan submit()
     * perintah digunakan untuk menganalisis hasil objek Masa Depan.
     * 
     * Kita harus menyadari perbedaan utama mekanisme Penanganan Pengecualian antara
     * kedua perintah ini.
     * 
     * Pengecualian dari submit() ditelan oleh kerangka kerja jika Anda tidak
     * menangkapnya.
     * 
     * Contoh kode untuk memahami perbedaannya:
     * 
     * Kasus 1: kirimkan perintah Runnable dengan execute(), yang melaporkan
     * Exception.
     * 
     * import java.util.concurrent.*;
     * import java.util.*;
     * public class ExecuteSubmitDemo {
     * public ExecuteSubmitDemo() {
     * System.out.println("creating service");
     * ExecutorService service = Executors.newFixedThreadPool(2);
     * //ExtendedExecutor service = new ExtendedExecutor();
     * for (int i = 0; i < 2; i++){
     * service.execute(new Runnable(){
     * public void run(){
     * int a = 4, b = 0;
     * System.out.println("a and b=" + a + ":" + b);
     * System.out.println("a/b:" + (a / b));
     * System.out.println("Thread Name in Runnable after divide by
     * zero:"+Thread.currentThread().getName());
     * }
     * });
     * }
     * service.shutdown();
     * }
     * public static void main(String args[]){
     * ExecuteSubmitDemo demo = new ExecuteSubmitDemo();
     * }
     * }
     * 
     * 
     */

    /*
     * class ExtendedExecutor extends ThreadPoolExecutor {
     * public ExtendedExecutor() {
     * super(1, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
     * }
     * // ...
     * protected void afterExecute(Runnable r, Throwable t) {
     * super.afterExecute(r, t);
     * if (t == null && r instanceof Future<?>) {
     * try {
     * Object result = ((Future<?>) r).get();
     * } catch (CancellationException ce) {
     * t = ce;
     * } catch (ExecutionException ee) {
     * t = ee.getCause();
     * } catch (InterruptedException ie) {
     * Thread.currentThread().interrupt(); // ignore/reset
     * }
     * }
     * if (t != null)
     * System.out.println(t);
     * }
     * }
     */

    // hasil:
    /*
     * creating service
     * a and b=4:0
     * a and b=4:0
     * Exception in thread "pool-1-thread-1" Exception in thread "pool-1-thread-2"
     * java.lang.ArithmeticException: / by zero
     * at ExecuteSubmitDemo$1.run(ExecuteSubmitDemo.java:15)
     * at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:
     * 1145)
     * at
     * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:
     * 615)
     * at java.lang.Thread.run(Thread.java:744)
     * java.lang.ArithmeticException: / by zero
     * at ExecuteSubmitDemo$1.run(ExecuteSubmitDemo.java:15)
     * at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:
     * 1145)
     * at
     * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:
     * 615)
     * at java.lang.Thread.run(Thread.java:744)
     */

    /*
     * Kasus 2: Ganti execute() dengan submit() : service.submit(new
     * Runnable(){ Dalam kasus ini, Pengecualian ditelan oleh kerangka kerja karena
     * metode run() tidak menangkapnya secara eksplisit.
     */

    // hasil:
    /*
     * creating service
     * a and b=4:0
     * a and b=4:0
     */

    // Kasus 3: Ubah newFixedThreadPool menjadi ExtendedExecutor
    /*
     * //ExecutorService service = Executors.newFixedThreadPool(2);
     * ExtendedExecutor service = new ExtendedExecutor();
     */

    // hasil:
    /*
     * creating service
     * a and b=4:0
     * java.lang.ArithmeticException: / by zero
     * a and b=4:0
     * java.lang.ArithmeticException: / by zero
     * 
     */

    /*
     * Saya telah mendemonstrasikan contoh ini untuk mencakup dua topik: Gunakan
     * ThreadPoolExecutor khusus Anda dan handle exeception dengan
     * ThreadPoolExecutor khusus.
     */

    /*
     * Solusi sederhana lainnya untuk masalah di atas : Saat Anda menggunakan
     * perintah ExecutorService & submit normal, dapatkan objek Future dari
     * panggilan perintah submit() get() API di Future. Tangkap tiga pengecualian,
     * yang telah dikutip dalam implementasi metode afterExecute. Keuntungan dari
     * ThreadPoolExecutor khusus dibandingkan pendekatan ini:
     * Anda harus menangani mekanisme penanganan Pengecualian hanya di satu tempat -
     * Custom ThreadPoolExecutor.
     */
    // ------------------------------
    public Submit_vs_execute_exception_handling_differences() {
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(2);
        // ExtendedExecutor service = new ExtendedExecutor();
        for (int i = 0; i < 2; i++) {
            service.execute(new Runnable() {
                public void run() {
                    int a = 4, b = 0;
                    System.out.println("a and b=" + a + ":" + b);
                    System.out.println("a/b:" + (a / b));
                    System.out.println(
                            "Thread Name in Runnable after divide by zero:" + Thread.currentThread().getName());
                }
            });
        }
        service.shutdown();
    }

    public static void main(String[] args) throws Exception {
        Submit_vs_execute_exception_handling_differences demo = new Submit_vs_execute_exception_handling_differences();
        /*
         * output:
         * creating service
         * a and b=4:0
         * a and b=4:0
         */
    }
}
