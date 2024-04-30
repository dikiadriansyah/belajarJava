public class Break {
    // break/merusak

    // Pernyataan break mengakhiri perulangan (seperti for, while) atau evaluasi
    // pernyataan switch.

    // perulangan:
    /*
     * while(true) {
     * if(someCondition == 5) {
     * break;
     * }
     * }
     */

    /*
     * Perulangan dalam contoh ini akan berjalan selamanya. Namun ketika
     * someCondition sama dengan 5 pada suatu titik eksekusi, maka perulangan
     * berakhir.
     * 
     * Jika beberapa perulangan dirangkai, hanya perulangan paling dalam yang
     * diakhiri dengan menggunakan break.
     */

    public static void main(String[] args) {
        int someCondition = 0;

        while (true) {
            if (someCondition == 5) {
                break;
            }

            // Lakukan sesuatu di dalam loop
            System.out.println("Nilai someCondition: " + someCondition);
            /*
             * output:
             * //
             * Nilai someCondition: 0
             * Nilai someCondition: 1
             * Nilai someCondition: 2
             * Nilai someCondition: 3
             * Nilai someCondition: 4
             */

            // Simulasi perubahan nilai someCondition (harus ada kondisi perubahan untuk
            // keluar dari loop)
            someCondition++;

            // Jeda untuk melihat output dengan jelas
            try {
                Thread.sleep(1000); // Jeda 1 detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
