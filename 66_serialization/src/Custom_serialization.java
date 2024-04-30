import java.io.*;

public class Custom_serialization {
    // Custom Serialization / Serialisasi Khusus

    /*
     * Dalam contoh ini kita ingin membuat kelas yang akan menghasilkan dan
     * menampilkan ke konsol, angka acak antara rentang dua bilangan bulat yang
     * diteruskan sebagai argumen selama inisialisasi.
     */

    /*
     * public class SimpleRangeRandom implements Runnable {
     * private int min;
     * private int max;
     * private Thread thread;
     * public SimpleRangeRandom(int min, int max){
     * this.min = min;
     * this.max = max;
     * thread = new Thread(this);
     * thread.start();
     * }
     * 
     * @Override
     * private void WriteObject(ObjectOutputStreamout) throws IO Exception;
     * private void ReadObject(ObjectInputStream in) throws IOException,
     * ClassNotFoundException;
     * public void run() {
     * while(true) {
     * Random rand = new Random();
     * System.out.println("Thread: " + thread.getId() + " Random:" +
     * rand.nextInt(max - min));
     * try {
     * Thread.sleep(10000);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * }
     * 
     */

    /*
     * Sekarang jika kita ingin membuat kelas ini Serializable akan ada beberapa
     * masalah. Thread adalah salah satu yang pasti
     * kelas tingkat sistem yang tidak dapat diserialkan. Jadi kita perlu
     * mendeklarasikan thread tersebut sebagai transient. Dengan melakukan ini kita
     * akan dapat membuat serialisasi objek kelas ini tetapi kita masih mempunyai
     * masalah. Seperti yang Anda lihat di konstruktor yang kami atur
     * nilai min dan maksimal pengacak kita dan setelah ini kita memulai thread yang
     * bertanggung jawab untuk menghasilkan dan mencetak nilai acak. Jadi ketika
     * memulihkan objek yang bertahan dengan memanggil readObject() tersebut
     * konstruktor tidak akan berjalan lagi karena tidak ada pembuatan objek baru.
     * Dalam hal ini kita perlu mengembangkan Custom
     * Serialization dengan menyediakan dua metode di dalam kelas. Cara-cara
     * tersebut adalah:
     */

    /*
     * private void writeObject(ObjectOutputStream out) throws IOException;
     * private void readObject(ObjectInputStream in) throws IOException,
     * ClassNotFoundException;
     */

    // Jadi dengan menambahkan implementasi kita di readObject() kita dapat memulai
    // dan memulai thread kita:

    /*
     * class RangeRandom implements Serializable, Runnable {
     * private int min;
     * private int max;
     * private transient Thread thread;
     * //transient should be any field that either cannot be serialized e.g Thread
     * or any field you do not
     * want serialized
     * public RangeRandom(int min, int max){
     * this.min = min;
     * this.max = max;
     * thread = new Thread(this);
     * thread.start();
     * }
     * 
     * @Override
     * public void run() {
     * while(true) {
     * Random rand = new Random();
     * System.out.println("Thread: " + thread.getId() + " Random:" +
     * rand.nextInt(max - min));
     * try {
     * Thread.sleep(10000);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * private void writeObject(ObjectOutputStream oos) throws IOException {
     * oos.defaultWriteObject();
     * }
     * private void readObject(ObjectInputStream in) throws IOException,
     * ClassNotFoundException {
     * in.defaultReadObject();
     * thread = new Thread(this);
     * thread.start();
     * }
     * }
     */

    // Inilah yang utama untuk contoh kita:
    /*
     * public class Main {
     * public static void main(String[] args) {
     * System.out.println("Hello");
     * RangeRandom rangeRandom = new RangeRandom(1,10);
     * FileOutputStream fos = null;
     * ObjectOutputStream out = null;
     * try
     * {
     * fos = new FileOutputStream("test");
     * out = new ObjectOutputStream(fos);
     * out.writeObject(rangeRandom);
     * out.close();
     * }
     * catch(IOException ex)
     * {
     * ex.printStackTrace();
     * }
     * RangeRandom rangeRandom2 = null;
     * FileInputStream fis = null;
     * ObjectInputStream in = null;
     * try
     * {
     * fis = new FileInputStream("test");
     * in = new ObjectInputStream(fis);
     * rangeRandom2 = (RangeRandom)in.readObject();
     * in.close();
     * }
     * catch(IOException ex)
     * {
     * ex.printStackTrace();
     * }
     * catch(ClassNotFoundException ex)
     * {
     * ex.printStackTrace();
     * }
     * }
     * }
     */

    /*
     * Jika Anda menjalankan main, Anda akan melihat bahwa ada dua thread yang
     * berjalan untuk setiap instance RangeRandom dan itu karena metode
     * Thread.start() sekarang ada di konstruktor dan readObject().
     */

    public static void main(String[] args) {
        // System.out.println("Hello");

        RangeRandom rangeRandom = new RangeRandom(1, 10);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("test");
            out = new ObjectOutputStream(fos);
            out.writeObject(rangeRandom);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        RangeRandom rangeRandom2 = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("test");
            in = new ObjectInputStream(fis);
            rangeRandom2 = (RangeRandom) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        /*
         * output:
         * Thread: 13 Random:4
         * Thread: 14 Random:1
         * Thread: 14 Random:8
         * Thread: 13 Random:4
         * Thread: 14 Random:4
         */

    }
}
