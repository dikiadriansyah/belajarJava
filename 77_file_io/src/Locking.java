import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Locking {
    // Locking

    // Sebuah file dapat dikunci menggunakan FileChannel API yang dapat diperoleh
    // dari Input Output streams dan readers

    // contoh dengan streams

    /*
     * // Open a file stream
     * FileInputStream ios = new FileInputStream(filename);
     * // get underlying channel
     * FileChannel channel = ios.getChannel();
     * 
     * try to lock the file. true means whether the lock is shared or not i.e.
     * multiple processes can
     * acquire a
     * shared lock (for reading only) Using false with readable channel only will
     * generate an
     * exception. You should
     * use a writable channel (taken from FileOutputStream) when using false.
     * tryLock will always
     * return immediately
     * 
     * 
     * FileLock lock = channel.tryLock(0, Long.MAX_VALUE, true);
     * if (lock == null) {
     * System.out.println("Unable to acquire lock");
     * } else {
     * System.out.println("Lock acquired successfully");
     * }
     * // you can also use blocking call which will block until a lock is acquired.
     * channel.lock();
     * // Once you have completed desired operations of file. release the lock
     * if (lock != null) {
     * lock.release();
     * }
     * // close the file stream afterwards
     * // Example with reader
     * RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
     * FileChannel channel = randomAccessFile.getChannel();
     * //repeat the same steps as above but now you can use shared as true or false
     * as the channel is in
     * read write mode
     * 
     * 
     */

    public static void main(String[] args) {
        String filename = "example.txt";

        // Contoh dengan FileInputStream and shared lock
        try {
            FileInputStream ios = new FileInputStream(filename);
            FileChannel channel = ios.getChannel();
            FileLock lock = channel.tryLock(0, Long.MAX_VALUE, true);

            if (lock == null) {
                System.out.println("Tidak dapat memperoleh kunci");
            } else {
                System.out.println("Kunci Bersama berhasil diperoleh");
                // Perform operations on the file while holding the lock
                // ...

                // Release the lock when done
                lock.release();
            }

            // Close the file stream
            ios.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Contoh dengan RandomAccessFile and exclusive lock
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            FileLock lock = channel.tryLock(0, Long.MAX_VALUE, false);

            if (lock == null) {
                System.out.println("Tidak dapat memperoleh kunci");
            } else {
                System.out.println("Kunci Eksklusif berhasil diperoleh");
                // Perform operations on the file while holding the lock
                // ...

                // Release the lock when done
                lock.release();
            }

            // Close the random access file
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Kunci Bersama berhasil diperoleh
         * Kunci Eksklusif berhasil diperoleh
         */

    }
}