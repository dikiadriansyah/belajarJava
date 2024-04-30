public class Shared {
    int i;

    synchronized void SharedMethod() {
        Thread t = Thread.currentThread();
        for (int i = 0; i <= 100; i++) {
            System.out.println(t.getName() + " : " + i);
        }
    }

    void SharedMethod2() {
        synchronized (this) {
            System.out.println("Thais access to currect object is synchronize " + this);
        }
    }

}
