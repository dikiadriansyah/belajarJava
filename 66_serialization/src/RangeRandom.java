import java.io.*;
import java.util.*;

class RangeRandom implements Serializable, Runnable {
    private int min;
    private int max;
    private transient Thread thread;

    // transient should be any field that either cannot be serialized e.g Thread or
    // any field you do not
    // want serialized
    public RangeRandom(int min, int max) {
        this.min = min;
        this.max = max;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            System.out.println("Thread: " + thread.getId() + " Random:" + rand.nextInt(max - min));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        thread = new Thread(this);
        thread.start();
    }
}