
// import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Blockingqueue {
    // BlockingQueue

    /*
     * BlockingQueue adalah sebuah antarmuka, yang merupakan antrian yang memblokir
     * ketika Anda mencoba untuk melakukan dequeue darinya dan antrian tersebut
     * kosong, atau jika Anda mencoba memasukkan item ke dalamnya dan antrian sudah
     * penuh. Sebuah thread mencoba melakukan dequeue dari yang kosong
     * antrian diblokir sampai beberapa thread lain memasukkan item ke dalam
     * antrian. Sebuah thread yang mencoba memasukkan item ke dalam antrean dalam
     * antrean penuh akan diblokir hingga beberapa thread lain memberi ruang di
     * antrean, baik dengan menghapus antrean satu atau lebih item atau
     * membersihkan antrian sepenuhnya.
     * 
     * Metode BlockingQueue hadir dalam empat bentuk, dengan cara penanganan operasi
     * berbeda yang tidak dapat dipenuhi segera, namun mungkin dipenuhi di beberapa
     * titik di masa depan: yang satu melontarkan pengecualian, yang kedua
     * mengembalikan nilai khusus (baik null atau false, tergantung pada
     * operasinya),yang ketiga memblokir thread saat ini tanpa batas waktu hingga
     * operasi dapat berhasil, dan blok keempat hanya
     * untuk batas waktu maksimum yang diberikan sebelum menyerah.
     */
    public static void main(String[] args) throws InterruptedException {
        // Operation | Throws Exception | Special | Value Blocks | Times out
        /*
         * Insert | add() | offer(e) | put(e) | offer(e, time, unit)
         * Remove | remove() | poll() | take() | poll(time, unit)
         * Examine | element() | peek() | N/A | N/A
         * 
         * BlockingQueue dapat dibatasi atau tidak dibatasi. BlockingQueue yang dibatasi
         * adalah yang diinisialisasi dengan kapasitas awal.
         * BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(2);
         * 
         * Setiap panggilan ke metode put() akan diblokir jika ukuran antrian sama
         * dengan kapasitas awal yang ditentukan.
         * 
         * Antrian tak terbatas adalah antrian yang diinisialisasi tanpa kapasitas,
         * sebenarnya secara default diinisialisasi dengan Integer.MAX_VALUE.
         * 
         * Beberapa implementasi umum BlockingQueue adalah:
         * 1. ArrayBlockingQueue
         * 2. LinkedBlockingQueue
         * 3. PriorityBlockingQueue
         * 
         * Sekarang mari kita lihat contoh ArrayBlockingQueue:
         * 
         */
        BlockingQueue<String> bQueue = new ArrayBlockingQueue<>(2);
        bQueue.put("This is entry 1");
        System.out.println("Entry one done");

        bQueue.put("This is entry 2");
        System.out.println("Entry two done");

        bQueue.put("This is entry 3");
        System.out.println("Entry three done");
    }
    /*
     * output:
     * Entry one done
     * Entry two done
     * 
     */
    // Dan utasnya akan diblokir setelah keluaran kedua
}
