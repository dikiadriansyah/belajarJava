public class Dynamic_method_dispatch_example_code {
    // Dynamic Method Dispatch - Example Code/Pengiriman Metode Dinamis - Kode
    // Contoh

    // Abstract Class

    /*
     * package base;
     * //Abstract classes cannot be instantiated, but they can be subclassed
     * 
     * public abstract class ClsVirusScanner {
     * //With One Abstract method
     * public abstract void fnStartScan();
     * 
     * protected void fnCheckForUpdateVersion(){
     * System.out.println("Perform Virus Scanner Version Check");
     * }
     * 
     * protected void fnBootTimeScan(){
     * System.out.println("Perform BootTime Scan");
     * }
     * protected void fnInternetSecutiry(){
     * System.out.println("Scan for Internet Security");
     * }
     * 
     * protected void fnRealTimeScan(){
     * System.out.println("Perform RealTime Scan");
     * }
     * 
     * protected void fnVirusMalwareScan(){
     * System.out.println("Detect Virus & Malware");
     * }
     * }
     * 
     * 
     * 
     */

    // Mengganti Metode Abstrak di Kelas Anak :
    /*
     * import base.ClsVirusScanner;
     * //All the 3 child classes inherits the base class ClsVirusScanner
     * //Child Class 1
     * class ClsPaidVersion extends ClsVirusScanner{
     * 
     * @Override
     * public void fnStartScan() {
     * super.fnCheckForUpdateVersion();
     * super.fnBootTimeScan();
     * super.fnInternetSecutiry();
     * super.fnRealTimeScan();
     * super.fnVirusMalwareScan();
     * }
     * }; //ClsPaidVersion IS-A ClsVirusScanner
     * //Child Class 2
     * class ClsTrialVersion extends ClsVirusScanner{
     * 
     * @Override
     * public void fnStartScan() {
     * super.fnInternetSecutiry();
     * super.fnVirusMalwareScan();
     * }
     * }; //ClsTrialVersion IS-A ClsVirusScanner
     * //Child Class 3
     * class ClsFreeVersion extends ClsVirusScanner{
     * 
     * @Override
     * public void fnStartScan() {
     * super.fnVirusMalwareScan();
     * }
     * }; //ClsTrialVersion IS-A ClsVirusScanner
     * 
     */

    // Pengikatan Dinamis/Terlambat mengarah ke pengiriman metode Dinamis :

    /*
     * //Calling Class
     * public class ClsRunTheApplication {
     * public static void main(String[] args) {
     * final String VIRUS_SCANNER_VERSION = "TRIAL_VERSION";
     * //Parent Refers Null
     * ClsVirusScanner objVS=null;
     * //String Cases Supported from Java SE 7
     * switch (VIRUS_SCANNER_VERSION){
     * case "FREE_VERSION":
     * //Parent Refers Child Object 3
     * //ClsFreeVersion IS-A ClsVirusScanner
     * objVS = new ClsFreeVersion(); //Dynamic or Runtime Binding
     * break;
     * case "PAID_VERSION":
     * //Parent Refers Child Object 1
     * //ClsPaidVersion IS-A ClsVirusScanner
     * objVS = new ClsPaidVersion(); //Dynamic or Runtime Binding
     * break;
     * case "TRIAL_VERSION":
     * //Parent Refers Child Object 2
     * objVS = new ClsTrialVersion(); //Dynamic or Runtime Binding
     * break;
     * }
     * //Method fnStartScan() is the Version of ClsTrialVersion()
     * objVS.fnStartScan();
     * }
     * }
     */

    // hasil:

    /*
     * Scan for Internet Security
     * Detect Virus & Malware
     */

    // Upcasting :
    /*
     * objVS = new ClsFreeVersion();
     * objVS = new ClsPaidVersion();
     * objVS = new ClsTrialVersion()
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // MyVirusScanner scanner = new MyVirusScanner();
        // scanner.fnStartScan();
        /*
         * output:
         * Starting the scan...
         * Perform Virus Scanner Version Check
         * Perform BootTime Scan
         * Scan for Internet Security
         * Perform RealTime Scan
         * Detect Virus & Malware
         * Scan completed.
         */
        // -----------------
        final String VIRUS_SCANNER_VERSION = "TRIAL_VERSION";
        // Parent Refers Null
        ClsVirusScanner objVS = null;
        // String Cases Supported from Java SE 7
        switch (VIRUS_SCANNER_VERSION) {
            case "FREE_VERSION":
                // Parent Refers Child Object 3
                // ClsFreeVersion IS-A ClsVirusScanner
                objVS = new ClsFreeVersion(); // Dynamic or Runtime Binding
                break;
            case "PAID_VERSION":
                // Parent Refers Child Object 1
                // ClsPaidVersion IS-A ClsVirusScanner
                objVS = new ClsPaidVersion(); // Dynamic or Runtime Binding
                break;
            case "TRIAL_VERSION":
                // Parent Refers Child Object 2
                objVS = new ClsTrialVersion(); // Dynamic or Runtime Binding
                break;
        }
        // Method fnStartScan() is the Version of ClsTrialVersion()
        objVS.fnStartScan();

        /*
         * output:
         * Scan for Internet Security
         * Detect Virus & Malware
         */

    }
}
