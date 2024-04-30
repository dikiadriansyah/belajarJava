
public class Using_interfaces_with_generics {
    // Using Interfaces with Generics/Menggunakan Antarmuka dengan Generik

    /*
     * Katakanlah Anda ingin menentukan antarmuka yang memungkinkan
     * penerbitan/penggunaan data ke dan dari berbagai jenis saluran (misalnya AMQP,
     * JMS, dll), tetapi Anda ingin dapat mengganti detail implementasi ...
     * 
     * Mari kita tentukan antarmuka IO dasar yang dapat digunakan kembali di
     * berbagai implementasi:
     * 
     * public interface IO<IncomingType, OutgoingType> {
     * void publish(OutgoingType data);
     * IncomingType consume();
     * IncomingType RPCSubmit(OutgoingType data);
     * }
     */

    /*
     * Sekarang saya dapat membuat instance antarmuka tersebut, tetapi karena kami
     * tidak memiliki implementasi default untuk metode tersebut, maka diperlukan
     * implementasi saat kami membuat instance:
     * 
     * IO<String, String> mockIO = new IO<String, String>() {
     * private String channel = "somechannel";
     * 
     * @Override
     * public void publish(String data) {
     * System.out.println("Publishing " + data + " to " + channel);
     * }
     * 
     * @Override
     * public String consume() {
     * System.out.println("Consuming from " + channel);
     * return "some useful data";
     * }
     * 
     * @Override
     * public String RPCSubmit(String data) {
     * return "received " + data + " just now ";
     * }
     * };
     * mockIO.consume(); // prints: Consuming from somechannel
     * mockIO.publish("TestData"); // Publishing TestData to somechannel
     * System.out.println(mockIO.RPCSubmit("TestData")); // received TestData just
     * now
     */

    /*
     * Kita juga dapat melakukan sesuatu yang lebih berguna dengan antarmuka
     * tersebut, misalkan kita ingin menggunakannya untuk menggabungkan beberapa
     * fungsi dasar RabbitMQ:
     * 
     * public class RabbitMQ implements IO<String, String> {
     * private String exchange;
     * private String queue;
     * public RabbitMQ(String exchange, String queue){
     * this.exchange = exchange;
     * this.queue = queue;
     * }
     * 
     * @Override
     * public void publish(String data) {
     * rabbit.basicPublish(exchange, queue, data.getBytes());
     * }
     * 
     * @Override
     * public String consume() {
     * return rabbit.basicConsume(exchange, queue);
     * }
     * 
     * @Override
     * public String RPCSubmit(String data) {
     * return rabbit.rpcPublish(exchange, queue, data);
     * }
     * }
     */

    /*
     * Katakanlah saya ingin menggunakan antarmuka IO ini sekarang sebagai cara
     * untuk menghitung kunjungan ke situs web saya sejak sistem terakhir saya
     * restart dan kemudian dapat menampilkan jumlah total kunjungan - Anda dapat
     * melakukan hal seperti ini:
     * 
     * import java.util.concurrent.atomic.AtomicLong;
     * public class VisitCounter implements IO<Long, Integer> {
     * private static AtomicLong websiteCounter = new AtomicLong(0);
     * 
     * @Override
     * public void publish(Integer count) {
     * websiteCounter.addAndGet(count);
     * }
     * 
     * @Override
     * public Long consume() {
     * return websiteCounter.get();
     * }
     * 
     * @Override
     * public Long RPCSubmit(Integer count) {
     * return websiteCounter.addAndGet(count);
     * }
     * 
     * }
     */

    /*
     * Sekarang mari kita gunakan VisitCounter:
     * VisitCounter counter = new VisitCounter();
     * // just had 4 visits, yay
     * counter.publish(4);
     * // just had another visit, yay
     * counter.publish(1);
     * // get data for stats counter
     * System.out.println(counter.consume()); // prints 5
     * // show data for stats counter page, but include that as a page view
     * System.out.println(counter.RPCSubmit(1)); // prints 6
     * 
     */

    /*
     * Saat mengimplementasikan banyak antarmuka, Anda tidak dapat
     * mengimplementasikan antarmuka yang sama dua kali. Hal ini juga berlaku untuk
     * antarmuka umum. Jadi, kode berikut ini tidak valid, dan akan mengakibatkan
     * kesalahan kompilasi:
     * 
     * interface Printer<T> {
     * void print(T value);
     * }
     * // Invalid!
     * class SystemPrinter implements Printer<Double>, Printer<Integer> {
     * 
     * @Override public void print(Double d){ System.out.println("Decimal: " + d); }
     * 
     * @Override public void print(Integer i){ System.out.println("Discrete: " + i);
     * }
     * }
     */

    public static void main(String[] args) {
        // IO<String, String> mockIO = new IO<String, String>() {
        // private String channel = "somechannel";

        // @Override
        // public void publish(String data) {
        // System.out.println("Publishing " + data + " to " + channel);
        // }

        // @Override
        // public String consume() {
        // System.out.println("Consuming from " + channel);
        // return "some useful data";
        // }

        // @Override
        // public String RPCSubmit(String data) {
        // return "received " + data + " just now ";
        // }
        // };

        // mockIO.consume(); // output: Consuming from somechannel
        // mockIO.publish("TestData"); // output: Publishing TestData to somechannel
        // System.out.println(mockIO.RPCSubmit("TestData")); // output: received
        // TestData just now
        // ------------------------------
        // VisitCounter counter = new VisitCounter();

        // // just had 4 visits, yay
        // counter.publish(4);

        // // just had another visit, yay
        // counter.publish(1);

        // // get data for stats counter
        // System.out.println(counter.consume()); // output: 5

        // // show data for stats counter page, but include that as a page view
        // System.out.println(counter.RPCSubmit(1)); // output: 6
        // -----------------------

    }
}
