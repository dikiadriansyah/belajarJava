public class Pitfall_missing_a_break_in_a_switch_case {
    // Pitfall - Missing a ‘break’ in a 'switch' case/Kesalahan - Tidak ada 'break'
    // dalam case 'switch'

    /*
     * Masalah-masalah Java ini bisa sangat memalukan, dan kadang-kadang tetap tidak
     * diketahui hingga dijalankan dalam produksi.
     * Perilaku fallthrough dalam pernyataan switch sering kali berguna; namun, kata
     * kunci “break” hilang ketika perilaku tersebut
     * tidak diinginkan dapat menyebabkan akibat yang buruk. Jika Anda lupa memberi
     * tanda “break” pada “case 0” pada contoh kode di bawah ini, program akan
     * menulis “Zero” diikuti dengan “One”, karena aliran kontrol di dalam sini akan
     * melewati seluruh
     * pernyataan “switch” hingga mencapai “break”. Misalnya:
     * 
     * public static void switchCasePrimer() {
     * int caseIndex = 0;
     * switch (caseIndex) {
     * case 0:
     * System.out.println("Zero");
     * case 1:
     * System.out.println("One");
     * break;
     * case 2:
     * System.out.println("Two");
     * break;
     * default:
     * System.out.println("Default");
     * }
     * }
     * 
     */

    /*
     * Dalam kebanyakan kasus, solusi yang lebih bersih adalah dengan menggunakan
     * antarmuka dan memindahkan kode dengan perilaku tertentu ke dalam implementasi
     * terpisah (komposisi daripada warisan)
     * 
     * Jika pernyataan peralihan tidak dapat dihindari, disarankan untuk
     * mendokumentasikan kegagalan yang "expected" jika terjadi. Dengan cara itu
     * Anda menunjukkan kepada sesama pengembang bahwa Anda mengetahui adanya jeda
     * yang hilang, dan bahwa ini adalah perilaku yang diharapkan.
     */

    /*
     * switch(caseIndex) {
     * [...]
     * case 2:
     * System.out.println("Two");
     * // fallthrough
     * default:
     * System.out.println("Default");
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        switchCasePrimer();
        // output: Zero
    }

    public static void switchCasePrimer() {
        int caseIndex = 0;
        switch (caseIndex) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("Default");
        }
    }

}
