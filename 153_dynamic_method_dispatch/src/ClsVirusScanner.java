public abstract class ClsVirusScanner {
    // With One Abstract method
    public abstract void fnStartScan();

    protected void fnCheckForUpdateVersion() {
        System.out.println("Perform Virus Scanner Version Check");
    }

    protected void fnBootTimeScan() {
        System.out.println("Perform BootTime Scan");
    }

    protected void fnInternetSecutiry() {
        System.out.println("Scan for Internet Security");
    }

    protected void fnRealTimeScan() {
        System.out.println("Perform RealTime Scan");
    }

    protected void fnVirusMalwareScan() {
        System.out.println("Detect Virus & Malware");
    }
}
