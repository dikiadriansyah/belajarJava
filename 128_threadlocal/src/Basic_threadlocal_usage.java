import java.text.SimpleDateFormat;
import java.util.Random;

public class Basic_threadlocal_usage implements Runnable {
    // Basic ThreadLocal usage/ Penggunaan benang dasar

    /*
     * Java Threadlocal digunakan untuk membuat variabel lokal utas. Diketahui bahwa
     * utas objek berbagi variabelnya,
     * Jadi variabelnya tidak aman utas. Kita dapat menggunakan sinkronisasi untuk
     * keselamatan utas tetapi jika kita ingin menghindari sinkronisasi, threadlocal
     * memungkinkan kita untuk membuat variabel yang lokal ke utas, yaitu hanya utas
     * yang dapat membaca atau menulis ke variabel -variabel itu, sehingga utas
     * lainnya menjalankan bagian kode yang sama tidak akan dapat mengakses variabel
     * threadlocal satu sama lain.
     * 
     * Ini dapat digunakan kita dapat menggunakan variabel ThreadLocal. Dalam
     * situasi di mana Anda memiliki kumpulan utas seperti misalnya di layanan web.
     * Misalnya, membuat objek SimpleDateFormat setiap saat untuk setiap permintaan
     * memakan waktu dan
     * yang statis tidak dapat dibuat sebagai SimpleDateFormat tidak aman, jadi kami
     * dapat membuat ThreadLocal sehingga kami
     * Dapat melakukan operasi utas yang aman tanpa overhead membuat
     * SimpleDateFormat setiap saat.
     * 
     */

    /*
     * Sepotong kode di bawah ini menunjukkan bagaimana itu dapat digunakan:
     * Setiap utas memiliki variabel ThreadLocal sendiri dan mereka dapat
     * get() dan set() metode untuk mendapatkan nilai default atau
     * mengubah nilai lokal menjadi utas.
     */

    /*
     * Instance Threadlocal biasanya merupakan bidang statis pribadi di kelas yang
     * ingin mengaitkan status dengan utas.
     * 
     * Berikut adalah contoh kecil yang menunjukkan penggunaan ThreadLocal dalam
     * program Java dan membuktikan bahwa setiap utas memiliki salinan variabel
     * ThreadLocal sendiri.
     */

    /*
     * package com.examples.threads;
     * import java.text.SimpleDateFormat;
     * import java.util.Random;
     * public class ThreadLocalExample implements Runnable{
     * // SimpleDateFormat is not thread-safe, so give one to each thread
     * // SimpleDateFormat is not thread-safe, so give one to each thread
     * private static final ThreadLocal<SimpleDateFormat> formatter = new
     * ThreadLocal<SimpleDateFormat>(){
     * 
     * @Override
     * protected SimpleDateFormat initialValue()
     * {
     * return new SimpleDateFormat("yyyyMMdd HHmm");
     * }
     * };
     * 
     * public static void main(String[] args) throws InterruptedException {
     * ThreadLocalExample obj = new ThreadLocalExample();
     * for(int i=0 ; i<10; i++){
     * Thread t = new Thread(obj, ""+i);
     * Thread.sleep(new Random().nextInt(1000));
     * t.start();
     * }
     * }
     * 
     * @Override
     * public void run() {
     * System.out.println("Thread Name= "+Thread.currentThread().getName()+" default
     * Formatter =
     * "+formatter.get().toPattern());
     * try {
     * Thread.sleep(new Random().nextInt(1000));
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * 
     * formatter.set(new SimpleDateFormat());
     * 
     * System.out.println("Thread Name= "+Thread.currentThread().getName()+"
     * formatter =
     * "+formatter.get().toPattern());
     * }
     * }
     */

    // hasil:
    /*
     * Thread Name= 0 default Formatter = yyyyMMdd HHmm
     * Thread Name= 1 default Formatter = yyyyMMdd HHmm
     * Thread Name= 0 formatter = M/d/yy h:mm a
     * Thread Name= 2 default Formatter = yyyyMMdd HHmm
     * Thread Name= 1 formatter = M/d/yy h:mm a
     * Thread Name= 3 default Formatter = yyyyMMdd HHmm
     * Thread Name= 4 default Formatter = yyyyMMdd HHmm
     * Thread Name= 4 formatter = M/d/yy h:mm a
     * Thread Name= 5 default Formatter = yyyyMMdd HHmm
     * Thread Name= 2 formatter = M/d/yy h:mm a
     * Thread Name= 3 formatter = M/d/yy h:mm a
     * Thread Name= 6 default Formatter = yyyyMMdd HHmm
     * Thread Name= 5 formatter = M/d/yy h:mm a
     * Thread Name= 6 formatter = M/d/yy h:mm a
     * Thread Name= 7 default Formatter = yyyyMMdd HHmm
     * Thread Name= 8 default Formatter = yyyyMMdd HHmm
     * Thread Name= 8 formatter = M/d/yy h:mm a
     * Thread Name= 7 formatter = M/d/yy h:mm a
     * Thread Name= 9 default Formatter = yyyyMMdd HHmm
     * Thread Name= 9 formatter = M/d/yy h:mm a
     */

    /*
     * Seperti yang dapat kita lihat dari output bahwa Thread-0 telah mengubah nilai
     * formatter tetapi masih formatter default thread-2 sama dengan nilai yang
     * diinisialisasi.
     */
    // -------------------------------
    // SimpleDateFormat is not thread-safe, so give one to each thread
    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ---------------
        Basic_threadlocal_usage obj = new Basic_threadlocal_usage();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        /*
         * output:
         * Thread Name= 0 default Formatter =yyyyMMdd HHmm
         * Thread Name= 1 default Formatter =yyyyMMdd HHmm
         * Thread Name= 0 formatter =M/d/yy, h:mm a
         * Thread Name= 2 default Formatter =yyyyMMdd HHmm
         * Thread Name= 1 formatter =M/d/yy, h:mm a
         * Thread Name= 2 formatter =M/d/yy, h:mm a
         * Thread Name= 3 default Formatter =yyyyMMdd HHmm
         * Thread Name= 4 default Formatter =yyyyMMdd HHmm
         * Thread Name= 4 formatter =M/d/yy, h:mm a
         * Thread Name= 3 formatter =M/d/yy, h:mm a
         * Thread Name= 5 default Formatter =yyyyMMdd HHmm
         * Thread Name= 5 formatter =M/d/yy, h:mm a
         * Thread Name= 6 default Formatter =yyyyMMdd HHmm
         * Thread Name= 6 formatter =M/d/yy, h:mm a
         * Thread Name= 7 default Formatter =yyyyMMdd HHmm
         * Thread Name= 7 formatter =M/d/yy, h:mm a
         * Thread Name= 8 default Formatter =yyyyMMdd HHmm
         * Thread Name= 8 formatter =M/d/yy, h:mm a
         * Thread Name= 9 default Formatter =yyyyMMdd HHmm
         * Thread Name= 9 formatter =M/d/yy, h:mm a
         */
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter ="
                + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());

        System.out.println(
                "Thread Name= " + Thread.currentThread().getName() + " formatter =" + formatter.get().toPattern());
    }

}
