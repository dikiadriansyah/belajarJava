import java.util.concurrent.atomic.AtomicBoolean;

public class wait_and_notify_methods {
    // wait() and notify() methods

    /*
     * wait() dan notify() bekerja bersama-sama – ketika satu thread memanggil
     * wait() pada suatu objek, thread tersebut akan memblokir hingga thread lain
     * memanggil notify() atau notifyAll() pada objek yang sama.
     * 
     * (See Also: wait()/notify() )
     * 
     */

    public static void main(String[] args) throws InterruptedException {

        final Object obj = new Object();
        AtomicBoolean aHasFinishedWaiting = new AtomicBoolean(false);

        Thread threadA = new Thread("Thread A") {

            public void run() {
                System.out.println("A1: Could print before or after B1");
                System.out.println("A2: Thread A is about to start waiting...");

                try {
                    synchronized (obj) { // wait() must be in a synchronized block
                        // execution of thread A stops until obj.notify() is called
                        obj.wait();
                    }
                    System.out.println("A3: Thread A has finished waiting. "
                            + "Guaranteed to happen after B3");
                } catch (InterruptedException e) {
                    System.out.println("Thread A was interrupted while waiting");
                } finally {
                    aHasFinishedWaiting.set(true);
                }

            }

        };

        Thread threadB = new Thread("Thread B") {
            public void run() {
                System.out.println("B1: Could print before or after A1");
                System.out.println("B2: Thread B is about to wait for 10 seconds");
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000); // sleep for 1 second
                    } catch (InterruptedException e) {
                        System.err.println("Thread B was interrupted from waiting");
                    }
                }

                System.out.println("B3: Will ALWAYS print before A3 since "
                        + "A3 can only happen after obj.notify() is called.");

                while (!aHasFinishedWaiting.get()) {
                    synchronized (obj) {
                        // notify ONE thread which has called obj.wait()
                        obj.notify();
                    }
                }
            }
        };

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("Finished!");

        /*
         * output:
         * A1: Could print before or after B1
         * B1: Could print before or after A1
         * A2: Thread A is about to start waiting...
         * B2: Thread B is about to wait for 10 seconds
         * B3: Will ALWAYS print before A3 since A3 can only happen after obj.notify()
         * is called.
         * A3: Thread A has finished waiting. Guaranteed to happen after B3
         * Finished!
         * 
         * B1: Could print before or after A1
         * B2: Thread B is about to wait for 10 seconds
         * A1: Could print before or after B1
         * A2: Thread A is about to start waiting...
         * B3: Will ALWAYS print before A3 since A3 can only happen after obj.notify()
         * is called.
         * A3: Thread A has finished waiting. Guaranteed to happen after B3
         * Finished!
         * 
         * A1: Could print before or after B1
         * A2: Thread A is about to start waiting...
         * B1: Could print before or after A1
         * B2: Thread B is about to wait for 10 seconds
         * B3: Will ALWAYS print before A3 since A3 can only happen after obj.notify()
         * is called.
         * A3: Thread A has finished waiting. Guaranteed to happen after B3
         * Finished!
         * 
         * 
         */

    }
}
