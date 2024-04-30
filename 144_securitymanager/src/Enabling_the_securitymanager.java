public class Enabling_the_securitymanager {
    // Enabling the SecurityManager/Mengaktifkan SecurityManager

    /*
     * Java Virtual Machines (JVM) dapat dijalankan dengan SecurityManager
     * terinstal. SecurityManager mengatur apa yang boleh dilakukan oleh kode yang
     * berjalan di JVM, berdasarkan faktor-faktor seperti dari mana kode itu dimuat
     * dan sertifikat apa yang digunakan untuk menandatangani kode tersebut.
     * 
     * SecurityManager dapat diinstal dengan mengatur properti sistem
     * java.security.manager pada baris perintah saat memulai JVM:
     * 
     * java -Djava.security.manager <main class name>
     */

    // atau secara terprogram dari dalam kode Java:
    // System.setSecurityManager(new SecurityManager())

    /*
     * Java SecurityManager standar memberikan izin berdasarkan Kebijakan, yang
     * ditentukan dalam file kebijakan. Jika tidak
     * file kebijakan ditentukan, file kebijakan default di bawah
     * $JAVA_HOME/lib/security/java.policy akan digunakan.
     */

}
