public class Creating_basic_deadlocked_system {

    // Creating basic deadlocked system/Membuat sistem dasar kebuntuan

    /*
     * Kebuntuan terjadi ketika dua aksi yang bersaing menunggu hingga aksi lainnya
     * selesai, sehingga tidak ada yang menyelesaikannya. Di java ada satu kunci
     * yang terkait dengan setiap objek. Untuk menghindari modifikasi bersamaan yang
     * dilakukan oleh beberapa thread pada satu objek, kita dapat menggunakan kata
     * kunci synchronized, namun semuanya harus dibayar mahal. Penggunaan kata
     * kunci synchronized yang salah dapat menyebabkan sistem macet yang disebut
     * sistem buntu.
     * 
     * Misalkan ada 2 thread yang bekerja pada 1 instance, sebut saja thread sebagai
     * Pertama dan Kedua, dan katakanlah kita memiliki 2 sumber daya R1 dan R2. Yang
     * pertama memperoleh R1 dan juga membutuhkan R2 untuk penyelesaiannya sedangkan
     * Yang Kedua memperoleh R2 dan membutuhkan R1 untuk penyelesaiannya.
     */

    // jadi katakanlah pada time t=0,

    /*
     * Yang pertama memiliki R1 dan yang kedua memiliki R2. sekarang Yang Pertama
     * menunggu R2 sedangkan Yang Kedua menunggu R1. penantian ini tidak terbatas
     * dan ini menyebabkan kebuntuan.
     */

    /*
     * public class Example2 {
     * 
     * public static void main(String[] args) throws InterruptedException {
     * final DeadLock dl = new DeadLock();
     * Thread t1 = new Thread(new Runnable() {
     * 
     * @Override
     * public void run() {
     * // TODO Auto-generated method stub
     * dl.methodA();
     * }
     * });
     * 
     * Thread t2 = new Thread(new Runnable() {
     * 
     * @Override
     * public void run() {
     * // TODO Auto-generated method stub
     * try {
     * dl.method2();
     * } catch (InterruptedException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * }
     * });
     * t1.setName("First");
     * t2.setName("Second");
     * t1.start();
     * t2.start();
     * }
     * }
     * class DeadLock {
     * 
     * Object mLock1 = new Object();
     * Object mLock2 = new Object();
     * 
     * public void methodA() {
     * System.out.println("methodA wait for mLock1 " +
     * Thread.currentThread().getName());
     * synchronized (mLock1) {
     * System.out.println("methodA mLock1 acquired " +
     * Thread.currentThread().getName());
     * try {
     * Thread.sleep(100);
     * method2();
     * } catch (InterruptedException e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * }
     * }
     * public void method2() throws InterruptedException {
     * System.out.println("method2 wait for mLock2 " +
     * Thread.currentThread().getName());
     * synchronized (mLock2) {
     * System.out.println("method2 mLock2 acquired " +
     * Thread.currentThread().getName());
     * Thread.sleep(100);
     * method3();
     * }
     * }
     * public void method3() throws InterruptedException {
     * System.out.println("method3 mLock1 "+ Thread.currentThread().getName());
     * synchronized (mLock1) {
     * System.out.println("method3 mLock1 acquired " +
     * Thread.currentThread().getName());
     * }
     * }
     * }
     * 
     */

    // hasil:
    /*
     * methodA wait for mLock1 First
     * method2 wait for mLock2 Second
     * method2 mLock2 acquired Second
     * methodA mLock1 acquired First
     * method3 mLock1 Second
     * method2 wait for mLock2 First
     */

    public static void main(String[] args) throws InterruptedException {
        final Deadlock dl = new Deadlock();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                dl.methodA();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    dl.method2();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        t1.setName("First");
        t2.setName("Second");
        t1.start();
        t2.start();
        /*
         * output:
         * method2 wait for mLock2 Second
         * methodA wait for mLock1 First
         * method2 mLock2 acquired Second
         * methodA mLock1 acquired First
         * method2 wait for mLock2 First
         * method3 mLock1 Second
         */

    }
}
