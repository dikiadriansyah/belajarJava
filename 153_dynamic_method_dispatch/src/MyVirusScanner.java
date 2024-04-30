public class MyVirusScanner extends ClsVirusScanner {
    @Override
    public void fnStartScan() {
        System.out.println("Starting the scan...");
        // Panggil metode-metode lain jika diperlukan
        fnCheckForUpdateVersion();
        fnBootTimeScan();
        fnInternetSecutiry();
        fnRealTimeScan();
        fnVirusMalwareScan();
        System.out.println("Scan completed.");
    }
}
