public class example_of_instrumentation_of_all_bw_applications_in_a_single_step_for_app {
    // Example of Instrumentation of all BW Applications in a Single Step for
    // Appdynamics/ Contoh Instrumentasi seluruh BW Aplikasi dalam Satu Langkah
    // untuk Appdynamics

    /*
     * 1. Cari dan buka file TIBCO BW bwengine.tra Anda biasanya di bawah
     * TIBCO_HOME/bw/5.12/bin/bwengine.tra (Lingkungan Linux)
     * 2. Carilah baris yang menyatakan:
     */

    // *** Common variables. Modify these only. ***

    /*
     * 3. Tambahkan baris berikut tepat setelah bagian
     * tibco.deployment=%tibco.deployment%
     * 4. Pergi ke akhir file dan tambahkan (ganti ? dengan nilai Anda sendiri
     * sesuai kebutuhan atau hapus tanda yang tidak
     * berlaku):
     * java.exended.properties=-javaagent:/opt/appd/current/apagent/javaagent.jar -
     * Dappdynamics.http.proxyHost=? -Dappdynamics.http.proxyPort=?
     * -Dappdynamics.agent.applicationName=?
     * -Dappdynamics.agent.tierName=?
     * -Dappdynamics.agent.nodeName=%tibco.deployment% -
     * Dappdynamics.controller.ssl.enabled=? -Dappdynamics.controller.sslPort=?
     * -Dappdynamics.agent.logs.dir=? -
     * Dappdynamics.agent.runtime.dir=? -Dappdynamics.controller.hostName=?
     * -Dappdynamics.controller.port=?
     * -Dappdynamics.agent.accountName=? -Dappdynamics.agent.accountAccessKey=?
     * 5. Simpan file dan terapkan ulang. Semua aplikasi Anda sekarang harus
     * diinstrumentasikan secara otomatis pada waktu penerapan.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
