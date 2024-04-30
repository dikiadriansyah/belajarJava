public class Overview {
    // Overview/Ringkasan

    /*
     * Kompiler Just-In-Time (JIT) adalah komponen Java™ Runtime Environment yang
     * meningkatkan kinerja aplikasi Java pada waktu dijalankan.
     * 1. Program Java terdiri dari kelas-kelas, yang berisi bytecode
     * platform-netral yang dapat diinterpretasikan oleh JVM
     * pada banyak arsitektur komputer yang berbeda.
     * 2. Saat run time, JVM memuat file kelas, menentukan semantik setiap bytecode,
     * dan melakukan perhitungan yang sesuai.
     */

    /*
     * Penggunaan prosesor dan memori tambahan selama interpretasi berarti kinerja
     * aplikasi Java lebih lambat dibandingkan aplikasi asli.
     * 
     * Kompiler JIT membantu meningkatkan kinerja program Java dengan mengkompilasi
     * bytecode ke dalam kode mesin asli pada waktu proses.
     */

    /*
     * Kompiler JIT diaktifkan secara default, dan diaktifkan ketika metode Java
     * dipanggil. Kompiler JIT mengkompilasi bytecode metode tersebut ke dalam kode
     * mesin asli, mengkompilasinya "tepat pada waktunya" untuk dijalankan.
     * 
     * Ketika suatu metode telah dikompilasi, JVM memanggil kode yang dikompilasi
     * dari metode tersebut secara langsung alih-alih menafsirkannya. Secara
     * teoritis, jika kompilasi tidak memerlukan waktu prosesor dan penggunaan
     * memori, kompilasi setiap metode dapat memungkinkan kecepatan program Java
     * mendekati kecepatan aplikasi asli.
     * 
     * Kompilasi JIT memang memerlukan waktu prosesor dan penggunaan memori. Saat
     * JVM pertama kali dijalankan, ribuan
     * metode disebut. Mengkompilasi semua metode ini dapat mempengaruhi waktu
     * startup secara signifikan, bahkan jika program pada akhirnya mencapai kinerja
     * puncak yang sangat baik.
     */

    /*
     * 1. Dalam praktiknya, metode tidak dikompilasi saat pertama kali dipanggil.
     * Untuk setiap metode, JVM mempertahankan jumlah panggilan yang bertambah
     * setiap kali metode dipanggil.
     * 2. JVM menafsirkan suatu metode hingga jumlah panggilannya melebihi ambang
     * batas kompilasi JIT.
     * 3. Oleh karena itu, metode yang sering digunakan dikompilasi segera setelah
     * JVM dimulai, dan metode yang jarang digunakan dikompilasi jauh kemudian, atau
     * tidak dikompilasi sama sekali.
     * 4. Ambang kompilasi JIT membantu JVM memulai dengan cepat dan tetap
     * meningkatkan kinerja.
     * 5. Ambang batas telah dipilih dengan cermat untuk mendapatkan keseimbangan
     * optimal antara waktu startup dan kinerja jangka panjang.
     * 6. Setelah suatu metode dikompilasi, jumlah panggilannya direset ke nol dan
     * panggilan berikutnya ke metode tersebut terus menambah jumlah panggilannya.
     * 7. Ketika jumlah panggilan suatu metode mencapai ambang batas kompilasi ulang
     * JIT, kompiler JIT akan mengkompilasinya untuk kedua kalinya, menerapkan
     * pilihan optimasi yang lebih besar daripada kompilasi sebelumnya.
     * 8. Proses ini diulangi hingga tingkat optimasi maksimum tercapai.
     */

    /*
     * Metode tersibuk dari program Java selalu dioptimalkan dengan paling agresif,
     * sehingga memaksimalkan manfaat kinerja menggunakan kompiler JIT.
     * 
     * Kompiler JIT juga dapat mengukur data operasional pada waktu proses, dan
     * menggunakan data tersebut untuk meningkatkan kualitas kompilasi ulang lebih
     * lanjut.
     * 
     * Kompiler JIT dapat dinonaktifkan, dalam hal ini seluruh program Java akan
     * diinterpretasikan. Menonaktifkan kompiler JIT tidak disarankan kecuali untuk
     * mendiagnosis atau mengatasi masalah kompilasi JIT.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
