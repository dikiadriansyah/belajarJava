import java.util.ServiceLoader;

public class Simple_serviceloader_example {
    // Simple ServiceLoader Example/Contoh ServiceLoader Sederhana

    /*
     * ServiceLoader adalah mekanisme bawaan yang sederhana dan mudah digunakan
     * untuk memuat implementasi antarmuka secara dinamis. Dengan pemuat layanan -
     * menyediakan sarana untuk instantasi (tetapi bukan pengkabelan) - mekanisme
     * injeksi ketergantungan sederhana dapat dibangun di Java SE. Dengan antarmuka
     * dan implementasi ServiceLoader
     * pemisahan menjadi alami dan program dapat diperluas dengan mudah. Sebenarnya
     * banyak Java API yang diterapkan berdasarkan ServiceLoader
     */

    /*
     * Konsep dasarnya adalah
     * 1. Beroperasi pada interfaces layanan
     * 2. Mendapatkan implementasi layanan melalui ServiceLoader
     * 3. Memberikan pelaksanaan pelayanan
     */

    // Mari kita mulai dengan antarmuka dan memasukkannya ke dalam toples, misalnya
    // diberi nama accounting-api.jar

    /*
     * package example;
     * public interface AccountingService {
     * long getBalance();
     * }
     */

    /*
     * Sekarang kami menyediakan implementasi layanan tersebut dalam toples bernama
     * Accounting-Impl.jar, yang berisi implementasi layanan tersebut
     * 
     * package example.impl;
     * import example.AccountingService;
     * public interface DefaultAccountingService implements AccouningService {
     * public long getBalance() {
     * return balanceFromDB();
     * }
     * private long balanceFromDB(){
     * //...
     * }
     * }
     * 
     */

    /*
     * selanjutnya, Accounting-impl.jar berisi file yang menyatakan bahwa jar ini
     * menyediakan implementasi AccountingService. File harus memiliki jalur yang
     * dimulai dengan META-INF/services/ dan harus memiliki nama yang sama dengan
     * nama antarmuka yang sepenuhnya memenuhi syarat:
     * 
     * META-INF/services/example.AccountingService
     */

    /*
     * Isi file adalah nama implementasi yang sepenuhnya memenuhi syarat:
     * example.impl.DefaultAccountingService
     */

    /*
     * Mengingat kedua toples berada di jalur kelas program, yang menggunakan
     * AccountingService, sebuah instance dari Layanan dapat diperoleh dengan
     * menggunakan ServiceLauncher
     * 
     * ServiceLoader<AccountingService> loader =
     * ServiceLoader.load(AccountingService.class)
     * AccountingService service = loader.next();
     * long balance = service.getBalance();
     */

    /*
     * Karena ServiceLoader adalah sebuah Iterable, ia mendukung beberapa penyedia
     * implementasi, di mana program dapat memilih dari:
     * 
     * ServiceLoader<AccountingService> loader =
     * ServiceLoader.load(AccountingService.class)
     * for(AccountingService service : loader) {
     * //...
     * }
     */

    /*
     * Perhatikan bahwa saat memanggil next(), instance baru akan selalu dibuat.
     * Jika Anda ingin menggunakan kembali sebuah instance, Anda harus menggunakan
     * metode iterator() dari ServiceLoader atau loop for-each seperti yang
     * ditunjukkan di atas.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ---------------
        DefaultAccountingService accountingService = new DefaultAccountingService();
        long balance = accountingService.getBalance();
        System.out.println("Balance: " + balance);
        // output: Balance: 1000
        // ---------------

    }
}
