public class Reference_to_non_static_member_from_static_context {
    // Reference to non-static member from static context/Referensi ke anggota
    // non-statis dari konteks statis

    /*
     * Variabel dan metode statis bukan bagian dari sebuah instance. Akan selalu ada
     * satu salinan dari variabel tersebut tidak peduli berapa banyak objek yang
     * Anda buat dari kelas tertentu.
     * 
     * Misalnya Anda mungkin ingin memiliki daftar konstanta yang tidak dapat
     * diubah, sebaiknya tetap statis dan inisialisasi sekali saja di dalam metode
     * statis. Ini akan memberi Anda peningkatan kinerja yang signifikan jika Anda
     * membuat beberapa instance dari kelas tertentu secara teratur.
     * 
     * Selain itu, Anda juga dapat memiliki blok statis di kelas. Anda dapat
     * menggunakannya untuk menetapkan nilai default ke variabel statis. Mereka
     * dieksekusi hanya sekali ketika kelas dimuat ke dalam memori.
     * 
     * Variabel instan seperti namanya bergantung pada sebuah instance dari objek
     * tertentu, mereka hidup untuk melayani keinginannya. Anda dapat bermain-main
     * dengan mereka selama siklus hidup suatu objek tertentu.
     * 
     * Semua bidang dan metode kelas yang digunakan di dalam metode statis kelas
     * tersebut harus statis atau lokal. Jika Anda mencoba menggunakan
     * variabel atau metode instan (non-statis), kode Anda tidak akan dapat
     * dikompilasi.
     * 
     */

    /*
     * public class Week {
     * static int daysOfTheWeek = 7; // static variable
     * int dayOfTheWeek; // instance variable
     * 
     * public static int getDaysLeftInWeek(){
     * return Week.daysOfTheWeek-dayOfTheWeek; // this will cause errors
     * }
     * public int getDaysLeftInWeek(){
     * return Week.daysOfTheWeek-dayOfTheWeek; // this is valid
     * }
     * public static int getDaysLeftInTheWeek(int today){
     * return Week.daysOfTheWeek-today; // this is valid
     * }
     * 
     * }
     * 
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Membuat objek Week
        Week myWeek = new Week();

        // Menetapkan nilai instance variable dayOfTheWeek
        myWeek.dayOfTheWeek = 3;

        // Memanggil metode getDaysLeftInWeek() secara statis
        int staticResult = Week.getDaysLeftInWeek();
        System.out.println("Static Result: " + staticResult);
        // output: Static Result: 7

        // Memanggil metode getDaysLeftInWeek() melalui objek
        int instanceResult = myWeek.getDaysLeftInWeek2();
        System.out.println("Instance Result: " + instanceResult);
        // output: Instance Result: 4

        // Memanggil metode getDaysLeftInTheWeek() secara statis dengan parameter
        int parameterResult = Week.getDaysLeftInTheWeek(2);
        System.out.println("Parameter Result: " + parameterResult);
        // output: Parameter Result: 5
    }
}
