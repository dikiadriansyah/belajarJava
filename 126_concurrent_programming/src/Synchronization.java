import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronization {
    // Synchronization

    /*
     * Di Java, ada mekanisme penguncian tingkat bahasa bawaan: blok
     * tersinkronisasi, yang dapat menggunakan objek Java apa pun
     * sebagai kunci intrinsik (yaitu setiap objek Java mungkin memiliki monitor
     * yang terkait dengannya).
     * 
     * Kunci intrinsik memberikan atomisitas pada kelompok pernyataan. Untuk
     * memahami apa artinya bagi kita, mari kita lihat
     * contoh di mana sinkronisasi berguna:
     * 
     * private static int t = 0;
     * private static Object mutex = new Object();
     * public static void main(String[] args) {
     * ExecutorService executorService = Executors.newFixedThreadPool(400); // The
     * high thread count
     * is for demonstration purposes.
     * for (int i = 0; i < 100; i++) {
     * executorService.execute(() -> {
     * synchronized (mutex) {
     * t++;
     * System.out.println(MessageFormat.format("t: {0}", t));
     * }
     * });
     * }
     * executorService.shutdown();
     * }
     */

    /*
     * Dalam hal ini, jika bukan karena blok yang synchronized, akan ada beberapa
     * masalah konkurensi yang terlibat.
     * Yang pertama adalah dengan operator kenaikan pos (itu bukan atomik itu
     * sendiri), dan yang kedua adalah kita akan mengamati nilai t setelah sejumlah
     * thread lain memiliki kesempatan untuk memodifikasinya.
     * Namun, karena kami memperoleh kunci intrinsik, tidak akan ada kondisi balapan
     * di sini dan keluarannya akan berisi angka dari 1 hingga 100 dalam urutan
     * normalnya.
     * 
     * Kunci intrinsik di Java adalah mutexes (yaitu kunci eksekusi bersama).
     * Eksekusi
     * timbal balik berarti jika satu thread telah memperoleh kunci, thread kedua
     * akan terpaksa menunggu thread pertama melepaskannya sebelum thread tersebut
     * dapat memperoleh kunci itu sendiri. Catatan: Operasi yang dapat membuat
     * thread berada dalam status tunggu (tidur) disebut operasi pemblokiran. Jadi,
     * memperoleh kunci adalah operasi pemblokiran.
     * 
     * Kunci intrinsik di Java bersifat reentrant. Artinya, jika sebuah thread
     * mencoba mendapatkan kunci yang sudah dimilikinya, thread tersebut tidak akan
     * diblokir dan akan berhasil memperolehnya. Misalnya, kode berikut tidak akan
     * diblokir saat dipanggil:
     * 
     * public void bar(){
     * synchronized(this){
     * ...
     * }
     * }
     * public void foo(){
     * synchronized(this){
     * bar();
     * }
     * }
     * 
     */

    // Selain blok synchronized, ada juga metode synchronized.
    /*
     * Blok kode berikut secara praktis setara (walaupun bytecodenya tampaknya
     * berbeda):
     * 
     * 1. synchronized block on this:
     * public void foo() {
     * synchronized(this) {
     * doStuff();
     * }
     * }
     * 2. synchronized method:
     * public synchronized void foo() {
     * doStuff();
     * }
     */

    // Begitu juga untuk metode static, ini:

    /*
     * class MyClass {
     * ...
     * public static void bar() {
     * synchronized(MyClass.class) {
     * doSomeOtherStuff();
     * }
     * }
     * }
     * 
     */

    // memiliki efek yang sama seperti ini:
    /*
     * class MyClass {
     * ...
     * public static synchronized void bar() {
     * doSomeOtherStuff();
     * }
     * }
     */

    // ------------------
    // private static int t = 0;
    // private static Object mutex = new Object();

    public static void main(String[] args) throws Exception {
        // ExecutorService executorService = Executors.newFixedThreadPool(400); // The
        // high thread count

        // is for demonstration purposes.
        // for (int i = 0; i < 10; i++) {
        // executorService.execute(() -> {
        // synchronized (mutex) {
        // t++;
        // System.out.println(MessageFormat.format("t: {0}", t));
        // }
        // });
        // }
        // executorService.shutdown();

        /*
         * output:
         * t: 1
         * t: 2
         * t: 3
         * t: 4
         * t: 5
         * t: 6
         * t: 7
         * t: 8
         * t: 9
         * t: 10
         */

        // ---------------------
        bar2();
        // output: Doing some other stuff...
    }

    public static void bar2() {
        synchronized (Synchronization.class) {
            doSomeOtherStuff();
        }
    }

    public static void doSomeOtherStuff() {
        System.out.println("Doing some other stuff...");
    }

}
