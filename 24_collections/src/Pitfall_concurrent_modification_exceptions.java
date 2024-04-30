import java.util.*;

public class Pitfall_concurrent_modification_exceptions {
    // Pitfall: concurrent modification exceptions
    /*
     * Pengecualian ini terjadi ketika koleksi dimodifikasi saat melakukan iterasi
     * menggunakan metode selain yang disediakan
     * oleh objek iterator. Misalnya, kami memiliki daftar topi dan kami ingin
     * menghapus semua topi yang memiliki penutup telinga
     */
    public static void main(String[] args) {
        List<IHat> hats = new ArrayList<>();
        hats.add(new Ushanka()); // that one has ear flaps
        hats.add(new Fedora());
        hats.add(new Sombrero());

        for (IHat hat : hats) {
            if (hat.hasEarFlaps()) {
                hats.remove(hat);
            }
            System.out.println(hat.getClass().getSimpleName());

        }

        /*
         * Jika kita menjalankan kode ini, ConcurrentModificationException akan
         * dimunculkan karena kode tersebut memodifikasi koleksi while
         * mengulanginya. Pengecualian yang sama dapat terjadi jika salah satu dari
         * beberapa thread yang bekerja dengan daftar yang sama mencoba mengubah koleksi
         * sementara yang lain mengulanginya. Modifikasi koleksi secara bersamaan di
         * beberapa thread adalah hal yang wajar, tetapi harus ditangani dengan alat
         * biasa dari kotak alat pemrograman bersamaan seperti
         * kunci sinkronisasi, koleksi khusus yang diadopsi untuk modifikasi bersamaan,
         * memodifikasi koleksi kloning dari awal dll
         */

    }

}

interface IHat {
    boolean hasEarFlaps();
}

class Ushanka implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return true;
    }
}

class Fedora implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return false;
    }
}

class Sombrero implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return false;
    }
}
