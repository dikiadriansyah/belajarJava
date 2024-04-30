
public class Programming_to_an_interface {

    // Programming to an interface / Pemrograman ke antarmuka

    /*
     * Ide di balik pemrograman ke antarmuka adalah mendasarkan kode terutama pada
     * antarmuka dan hanya menggunakan yang konkret
     * kelas pada saat instantiasi. Dalam konteks ini, kode yang baik menangani mis.
     * Koleksi Java akan terlihat seperti ini (metode itu sendiri tidak berguna sama
     * sekali, hanya ilustrasi):
     */

    /*
     * public <T> Set<T> toSet(Collection<T> collection) {
     * return Sets.newHashSet(collection);
     * }
     * 
     */

    // sementara kode yang buruk mungkin terlihat seperti ini:
    /*
     * public <T> HashSet<T> toSet(ArrayList<T> collection) {
     * return Sets.newHashSet(collection);
     * }
     * 
     */

    /*
     * Tidak hanya yang pertama dapat diterapkan pada pilihan argumen yang lebih
     * luas, hasilnya juga akan lebih kompatibel dengan kode
     * disediakan oleh pengembang lain yang umumnya menganut konsep pemrograman pada
     * suatu antarmuka. Namun, itu
     * alasan terpenting untuk menggunakan yang pertama adalah:
     * 1. sering kali konteks yang digunakan untuk menggunakan hasil tidak
     * memerlukan banyak detail
     * implementasi konkritnya menyediakan;
     * 2. mengikuti antarmuka memaksa kode yang lebih bersih dan lebih sedikit
     * peretasan seperti metode publik lainnya yang ditambahkan
     * sebuah kelas yang melayani beberapa skenario tertentu;
     * 3. kodenya lebih mudah diuji karena antarmukanya mudah ditiru;
     * 4. akhirnya, konsep tersebut membantu meskipun hanya satu implementasi yang
     * diharapkan (setidaknya untuk pengujian).
     */

    /*
     * Jadi bagaimana seseorang dapat dengan mudah menerapkan konsep pemrograman ke
     * suatu antarmuka ketika menulis kode baru yang ada dalam pikirannya
     * satu implementasi tertentu? Salah satu opsi yang biasa kami gunakan adalah
     * kombinasi pola berikut:
     * pemrograman ke antarmuka
     * pabrik
     * pembangun
     */

    /*
     * Contoh berikut berdasarkan prinsip-prinsip ini adalah versi implementasi RPC
     * yang disederhanakan dan dipotong yang ditulis untuk sejumlah protokol
     * berbeda:
     * public interface RemoteInvoker {
     * <RQ, RS> CompletableFuture<RS> invoke(RQ request, Class<RS> responseClass);
     * }
     * 
     */

    /*
     * Antarmuka di atas tidak dimaksudkan untuk dibuat secara langsung melalui
     * pabrik, sebaliknya kita mendapatkan antarmuka yang lebih konkrit, satu untuk
     * pemanggilan HTTP dan satu lagi untuk AMQP, masing-masing kemudian memiliki
     * pabrik dan pembuat untuk membangun instance, yang pada gilirannya juga
     * merupakan instance dari antarmuka di atas:
     * 
     * public interface AmqpInvoker extends RemoteInvoker {
     * static AmqpInvokerBuilder with(String instanceId, ConnectionFactory factory)
     * {
     * return new AmqpInvokerBuilder(instanceId, factory);
     * }
     * }
     */

    /*
     * Contoh RemoteInvoker untuk digunakan dengan AMQP sekarang dapat dibuat
     * semudah (atau lebih rumit tergantung pada pembangun):
     * RemoteInvoker invoker = AmqpInvoker.with(instanceId, factory)
     * .requestRouter(router)
     * .build();
     * 
     */

    // Dan pemanggilan permintaan semudah:
    // Response res = invoker.invoke(new Request(data), Response.class).get();

    /*
     * Karena Java 8 mengizinkan penempatan metode statis langsung ke antarmuka,
     * pabrik perantara telah menjadi implisit dalam kode di atas diganti dengan
     * AmqpInvoker.with(). Di Java sebelum versi 8, efek yang sama dapat dicapai
     * dengan kelas Pabrik dalam:
     * 
     * public interface AmqpInvoker extends RemoteInvoker {
     * class Factory {
     * public static AmqpInvokerBuilder with(String instanceId, ConnectionFactory
     * factory) {
     * return new AmqpInvokerBuilder(instanceId, factory);
     * }
     * }
     * }
     */

    // Instansiasi yang sesuai kemudian akan berubah menjadi:
    /*
     * RemoteInvoker invoker = AmqpInvoker.Factory.with(instanceId, factory)
     * .requestRouter(router)
     * .build();
     */

    /*
     * Pembuat yang digunakan di atas akan terlihat seperti ini (walaupun ini adalah
     * penyederhanaan karena pembuat yang sebenarnya mengizinkan pendefinisian
     * hingga 15 parameter yang menyimpang dari default). Perhatikan bahwa
     * konstruksinya tidak bersifat publik, sehingga secara khusus hanya dapat
     * digunakan dari antarmuka AmqpInvoker di atas:
     * 
     * public class AmqpInvokerBuilder {
     * ...
     * AmqpInvokerBuilder(String instanceId, ConnectionFactory factory) {
     * this.instanceId = instanceId;
     * this.factory = factory;
     * }
     * public AmqpInvokerBuilder requestRouter(RequestRouter requestRouter) {
     * this.requestRouter = requestRouter;
     * return this;
     * }
     * public AmqpInvoker build() throws TimeoutException, IOException {
     * return new AmqpInvokerImpl(instanceId, factory, requestRouter);
     * }
     * }
     */

    /*
     * Umumnya, sebuah pembuat juga dapat dibuat menggunakan alat seperti
     * FreeBuilder.
     * 
     * Terakhir, implementasi standar (dan satu-satunya yang diharapkan) dari
     * antarmuka ini didefinisikan sebagai kelas paket-lokal
     * menegakkan penggunaan antarmuka, pabrik, dan pembuat:
     * 
     * class AmqpInvokerImpl implements AmqpInvoker {
     * AmqpInvokerImpl(String instanceId, ConnectionFactory factory, RequestRouter
     * requestRouter) {
     * ...
     * }
     * 
     * @Override
     * public <RQ, RS> CompletableFuture<RS> invoke(final RQ request, final
     * Class<RS> respClass) {
     * ...
     * }
     * }
     * 
     */

    /*
     * Sementara itu, pola ini terbukti sangat efisien dalam mengembangkan semua
     * kode baru kami, tidak peduli seberapa sederhana atau rumit fungsinya.
     */

    public static void main(String[] args) throws Exception {

    }

}
