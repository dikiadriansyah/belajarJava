import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;
import java.nio.channels.spi.SelectorProvider;

public class Using_selector_to_wait_for_events {
    // Using Selector to wait for events(example with OP_CONNECT)/Menggunakan
    // Selector untuk menunggu acara (contoh dengan OP_CONNECT)

    /*
     * NIO muncul di Java 1.4 dan memperkenalkan konsep "Channels", yang seharusnya
     * lebih cepat daripada I/O biasa. Dari segi jaringan, SelectableChannel adalah
     * yang paling menarik karena memungkinkan untuk memantau berbagai status
     * Channel. Ia bekerja dengan cara yang sama seperti panggilan sistem C
     * SELECT(): kita terbangun ketika jenis peristiwa tertentu terjadi:
     * 
     * connection received (OP_ACCEPT)
     * connection realized (OP_CONNECT)
     * data available in read FIFO (OP_READ)
     * data can be pushed to write FIFO (OP_WRITE)
     */

    /*
     * Hal ini memungkinkan pemisahan antara detecting socket I/O (sesuatu dapat
     * read/written/...) dan melakukan I/O
     * (read/ write/...). Terutama, semua deteksi I/O dapat dilakukan dalam satu
     * thread untuk beberapa socket (clients).
     * melakukan I/O dapat ditangani di kumpulan thread atau di mana pun. Hal ini
     * memungkinkan aplikasi untuk diskalakan dengan mudah
     * jumlah klien yang terhubung.
     */

    // Contoh berikut menunjukkan dasar-dasarnya:
    /*
     * 1. Create a Selector
     * 2. Create a SocketChannel
     * 3. Register the SocketChannelto the Selector
     * 4. Loop with the Selector to detect events
     * 
     */

    /*
     * Selector sel = Selector.open(); // CREATE the Selector
     * SocketChannel sc = SocketChannel.open(); // CREATE a SocketChannel
     * sc.configureBlocking(FALSE); // ... non blocking
     * sc.setOption(StandardSocketOptions.SO_KEEPALIVE, TRUE); // ... SET SOME
     * options
     * // Register the Channel TO the Selector FOR wake-up ON CONNECT event AND USE
     * SOME description AS an
     * attachement
     * sc.register(sel, SelectionKey.OP_CONNECT, "Connection to google.com"); //
     * RETURNS a SelectionKey:
     * the association BETWEEN the SocketChannel AND the Selector
     * System.out.println("Initiating connection");
     * IF (sc.connect(NEW InetSocketAddress("www.google.com", 80)))
     * System.out.println("Connected"); // Connected right-away: nothing ELSE TO do
     * ELSE {
     * BOOLEAN exit = FALSE;
     * while (!exit) {
     * IF (sel.select(100) == 0) // Did something happen ON SOME registered Channels
     * during the
     * LAST 100ms?
     * continue; // No, wait SOME more
     * 
     * // Something happened...
     * Set<SelectionKey> KEYS = sel.selectedKeys(); // List OF SelectionKeys ON
     * which SOME
     * registered operation was triggered
     * FOR (SelectionKey k : KEYS) {
     * System.out.println("Checking "+k.attachment());
     * IF (k.isConnectable()) { // CONNECT event
     * System.out.print("Connected through select() on "+k.channel()+" -> ");
     * IF (sc.finishConnect()) { // Finish connection process
     * System.out.println("done!");
     * k.interestOps(k.interestOps() & ~SelectionKey.OP_CONNECT); // We are already
     * connected: remove interest IN CONNECT event
     * exit = TRUE;
     * } ELSE
     * System.out.println("unfinished...");
     * }
     * // TODO: ELSE IF (k.isReadable()) { ...
     * }
     * KEYS.clear(); // Have TO clear the selected KEYS SET once processed!
     * }
     * }
     * System.out.print("Disconnecting ... ");
     * sc.shutdownOutput(); // Initiate graceful disconnection
     * // TODO: empty receive buffer
     * sc.close();
     * System.out.println("done");
     */

    // Akan memberikan output berikut:

    /*
     * Initiating connection
     * Checking Connection to google.com
     * Connected through 'select()' on
     * java.nio.channels.SocketChannel[connection-pending
     * remote=www.google.com/216.58.208.228:80] -> done!
     * Disconnecting ... done
     */

    public static void main(String[] args) throws IOException {
        // System.out.println("Hello, World!");

        // -----------------
        Selector sel = Selector.open(); // CREATE the Selector
        SocketChannel sc = SocketChannel.open(); // CREATE a SocketChannel
        sc.configureBlocking(false); // ... non blocking
        sc.setOption(StandardSocketOptions.SO_KEEPALIVE, true); // ... SET SOME options
        // Register the Channel TO the Selector FOR wake-up ON CONNECT event AND USE
        // SOME description AS an
        // attachment
        sc.register(sel, SelectionKey.OP_CONNECT, "Connection to google.com"); // RETURNS a SelectionKey:
        // the association BETWEEN the SocketChannel AND the Selector
        System.out.println("Initiating connection");
        if (sc.connect(new InetSocketAddress("www.google.com", 80))) {
            System.out.println("Connected"); // Connected right-away: nothing ELSE TO do
        } else {
            boolean exit = false;
            while (!exit) {
                if (sel.select(100) == 0) // Did something happen ON SOME registered Channels during the
                    // LAST 100ms?
                    continue; // No, wait SOME more

                // Something happened...
                Set<SelectionKey> keys = sel.selectedKeys(); // List OF SelectionKeys ON which SOME
                // registered operation was triggered
                for (SelectionKey k : keys) {
                    System.out.println("Checking " + k.attachment());
                    if (k.isConnectable()) { // CONNECT event
                        System.out.print("Connected through select() on " + k.channel() + " -> ");
                        if (sc.finishConnect()) { // Finish connection process
                            System.out.println("done!");
                            k.interestOps(k.interestOps() & ~SelectionKey.OP_CONNECT); // We are already
                            // connected: remove interest IN CONNECT event
                            exit = true;
                        } else
                            System.out.println("unfinished...");
                    }
                    // TODO: ELSE IF (k.isReadable()) { ...
                }
                keys.clear(); // Have TO clear the selected KEYS SET once processed!
            }
        }
        System.out.print("Disconnecting ... ");
        sc.shutdownOutput(); // Initiate graceful disconnection
        // TODO: empty receive buffer
        sc.close();
        System.out.println("done");

    }
}
