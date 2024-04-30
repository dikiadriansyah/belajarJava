import java.lang.ref.WeakReference;

public class Different_reference_types {
    // Different Reference Types / Jenis Referensi yang Berbeda

    /*
     * Paket java.lang.ref menyediakan kelas objek referensi, yang mendukung
     * interaksi terbatas dengan pengumpul sampah.
     * 
     * Java memiliki empat tipe referensi utama yang berbeda. Mereka:
     * Strong Reference
     * Weak Reference
     * Soft Reference
     * Phantom Reference
     */

    /*
     * 1. Strong Reference
     * Ini adalah bentuk pembuatan objek yang biasa.
     * MyObject myObject = new MyObject();
     * 
     * Pemegang variabel memegang referensi kuat ke objek yang dibuat. Selama
     * variabel ini aktif dan menyimpan nilai ini, instance MyObject tidak akan
     * dikumpulkan oleh pengumpul sampah.
     * 
     * 2. Weak Reference
     * Ketika Anda tidak ingin menyimpan suatu objek lebih lama, dan Anda perlu
     * menghapus/membebaskan memori yang dialokasikan untuk suatu objek sesegera
     * mungkin, inilah cara untuk melakukannya.
     * WeakReference myObjectRef = new WeakReference(MyObject);
     * 
     * Sederhananya, referensi yang lemah adalah referensi yang tidak cukup kuat
     * untuk memaksa suatu objek tetap berada di memori. Referensi yang lemah
     * memungkinkan Anda memanfaatkan kemampuan pengumpul sampah untuk menentukan
     * keterjangkauan bagi Anda, sehingga Anda tidak perlu melakukannya sendiri.
     * 
     * Saat Anda membutuhkan objek yang Anda buat, cukup gunakan metode .get():
     * myObjectRef.get();
     * 
     * Kode berikut akan memberikan contoh ini:
     * WeakReference myObjectRef = new WeakReference(MyObject);
     * System.out.println(myObjectRef.get()); // This will print the object
     * reference address
     * System.gc();
     * System.out.println(myObjectRef.get()); // This will print 'null' if the GC
     * cleaned up the object
     * 
     */

    // 3. Soft Reference
    /*
     * Referensi lunak sedikit lebih kuat dari referensi lemah. Anda dapat membuat
     * objek referensi lunak sebagai berikut:
     * SoftReference myObjectRef = new SoftReference(MyObject);
     * 
     * Mereka dapat menyimpan memori lebih kuat dibandingkan referensi yang lemah.
     * Jika Anda memiliki persediaan/sumber daya memori yang cukup, pengumpul sampah
     * tidak akan membersihkan referensi lunak dengan antusias seperti referensi
     * lemah.
     * 
     * Referensi lunak berguna untuk digunakan dalam cache. Anda dapat membuat objek
     * referensi lunak sebagai cache, yang disimpan hingga memori Anda habis. Ketika
     * memori Anda tidak dapat menyediakan sumber daya yang cukup, pengumpul sampah
     * akan menghapus referensi lunak
     * 
     * SoftReference myObjectRef = new SoftReference(MyObject);
     * System.out.println(myObjectRef.get()); // This will print the reference
     * address of the Object
     * System.gc();
     * System.out.println(myObjectRef.get()); // This may or may not print the
     * reference address of the
     * Object
     */

    // 4. Phantom Reference
    /*
     * Ini adalah tipe referensi terlemah. Jika Anda membuat referensi objek
     * menggunakan Referensi Phantom, get()
     * metode akan selalu mengembalikan null!
     * 
     * Kegunaan referensi ini adalah "Objek referensi hantu, yang dimasukkan dalam
     * antrean setelah kolektor menentukan
     * bahwa referensi mereka dapat diklaim kembali. Referensi Phantom paling sering
     * digunakan untuk menjadwalkan tindakan pembersihan premortem dengan cara yang
     * lebih fleksibel dibandingkan dengan mekanisme finalisasi Java." - Dari
     * Referensi Phantom Javadoc dari Oracle.
     */

    /*
     * Anda dapat membuat objek Referensi Phantom sebagai berikut:
     * PhantomReference myObjectRef = new PhantomReference(MyObject);
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Create a new MyObject and wrap it in a WeakReference
        Different_reference_types myObject = new Different_reference_types();
        WeakReference<Different_reference_types> myObjectRef = new WeakReference<>(myObject);

        // Print the object reference address
        System.out.println("Object reference address: " + myObjectRef.get());
        /*
         * output:
         * Object reference address: Different_reference_types@53bd815b
         */

        // Perform garbage collection
        System.gc();

        // Print the object reference after garbage collection
        System.out.println("Object reference after GC: " + myObjectRef.get());
        /*
         * output:
         * Object reference after GC: Different_reference_types@53bd815b
         */
    }
}
