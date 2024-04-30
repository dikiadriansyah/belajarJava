public class MyRunnable implements Runnable {
    private volatile boolean active;

    public void run() { // run is called in one thread
        active = true;
        while (active) {
            // some code here
            System.out.println("Thread is running...");
            try {
                Thread.sleep(1000); // Simulate some task being done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() { // stop() is called from another thread
        active = false;
        System.out.println("Thread stopped.");
    }
}
