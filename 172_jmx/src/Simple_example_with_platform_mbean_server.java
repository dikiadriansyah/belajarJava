import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Simple_example_with_platform_mbean_server {
    // Simple example with Platform MBean Server/Contoh sederhana dengan Platform
    // MBean Server

    /*
     * Katakanlah kita memiliki server yang mendaftarkan pengguna baru dan menyambut
     * mereka dengan beberapa pesan. Dan kami ingin
     * pantau server ini dan ubah beberapa parameternya.
     * 
     * Pertama, kita memerlukan antarmuka dengan metode pemantauan dan pengendalian
     * kita
     */

    /*
     * public interface UserCounterMBean {
     * long getSleepTime();
     * void setSleepTime(long sleepTime);
     * int getUserCount();
     * void setUserCount(int userCount);
     * String getGreetingString();
     * void setGreetingString(String greetingString);
     * void stop();
     * }
     */

    /*
     * Dan beberapa implementasi sederhana yang memungkinkan kita melihat cara
     * kerjanya dan pengaruhnya
     * 
     * public class UserCounter implements UserCounterMBean, Runnable {
     * private AtomicLong sleepTime = new AtomicLong(10000);
     * private AtomicInteger userCount = new AtomicInteger(0);
     * private AtomicReference<String> greetingString = new
     * AtomicReference<>("welcome");
     * private AtomicBoolean interrupted = new AtomicBoolean(false);
     * 
     * @Override
     * public long getSleepTime() {
     * return sleepTime.get();
     * }
     * 
     * @Override
     * public void setSleepTime(long sleepTime) {
     * this.sleepTime.set(sleepTime);
     * }
     * 
     * @Override
     * public int getUserCount() {
     * return userCount.get();
     * }
     * 
     * @Override
     * public void setUserCount(int userCount) {
     * this.userCount.set(userCount);
     * }
     * 
     * @Override
     * public String getGreetingString() {
     * return greetingString.get();
     * }
     * 
     * @Override
     * public void setGreetingString(String greetingString) {
     * this.greetingString.set(greetingString);
     * }
     * 
     * @Override
     * public void stop() {
     * this.interrupted.set(true);
     * }
     * 
     * @Override
     * public void run() {
     * while (!interrupted.get()) {
     * try {
     * System.out.printf("User %d, %s%n", userCount.incrementAndGet(),
     * greetingString.get());
     * Thread.sleep(sleepTime.get());
     * } catch (InterruptedException ignored) {
     * }
     * }
     * }
     * }
     * 
     * 
     */

    // Sebagai contoh sederhana dengan manajemen lokal atau jarak jauh, kita perlu
    // mendaftarkan MBean kita:
    /*
     * import javax.management.InstanceAlreadyExistsException;
     * import javax.management.MBeanRegistrationException;
     * import javax.management.MBeanServer;
     * import javax.management.MalformedObjectNameException;
     * import javax.management.NotCompliantMBeanException;
     * import javax.management.ObjectName;
     * import java.lang.management.ManagementFactory;
     * public class Main {
     * public static void main(String[] args) throws MalformedObjectNameException,
     * NotCompliantMBeanException, InstanceAlreadyExistsException,
     * MBeanRegistrationException,
     * InterruptedException {
     * final UserCounter userCounter = new UserCounter();
     * final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
     * final ObjectName objectName = new
     * ObjectName("ServerManager:type=UserCounter");
     * mBeanServer.registerMBean(userCounter, objectName);
     * final Thread thread = new Thread(userCounter);
     * thread.start();
     * thread.join();
     * }
     * }
     */

    /*
     * Setelah itu kita dapat menjalankan aplikasi kita dan menghubungkannya melalui
     * jConsole, yang dapat ditemukan di $JAVA_HOME/bin Anda
     * direktori. Pertama, kita perlu menemukan proses java lokal dengan aplikasi
     * kita
     */

    /*
     * kemudian beralih ke tab MBeans dan temukan MBean yang kita gunakan di kelas
     * Utama sebagai ObjectName (dalam contoh
     * di atasnya adalah ServerManager). Di bagian Atribut kita bisa melihat
     * atribut. Jika Anda menentukan metode get saja,
     * atribut akan dapat dibaca tetapi tidak dapat ditulis. Jika Anda menentukan
     * metode get dan set, atribut akan dapat dibaca
     * dan dapat ditulisi.
     */

    // Metode yang ditentukan dapat dipanggil di bagian Operasi.

    /*
     * Jika Anda ingin dapat menggunakan manajemen jarak jauh, Anda memerlukan
     * parameter JVM tambahan, seperti:
     * 
     * -Dcom.sun.management.jmxremote=true //true by default
     * -Dcom.sun.management.jmxremote.port=36006
     * -Dcom.sun.management.jmxremote.authenticate=false
     * -Dcom.sun.management.jmxremote.ssl=false
     * 
     */

    /*
     * Parameter ini dapat ditemukan di Bab 2 panduan JMX. Setelah itu Anda akan
     * dapat terhubung ke Anda
     * aplikasi melalui jConsole dari jarak jauh dengan jconsole host:port atau
     * dengan menentukan host:port atau
     * layanan:jmx:rmi:///jndi/rmi://hostName:portNum/jmxrmi di jConsole GUI.
     */

    // Tautan yang berguna:
    /*
     * 
     * JMX guides
     * JMX Best practices
     */

    public static void main(String[] args) throws MalformedObjectNameException,
            NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException,
            InterruptedException {
        // System.out.println("Hello, World!");

        final UserCounter userCounter = new UserCounter();
        final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        final ObjectName objectName = new ObjectName("ServerManager:type=UserCounter");
        mBeanServer.registerMBean(userCounter, objectName);
        final Thread thread = new Thread(userCounter);
        thread.start();
        thread.join();

    }
}
