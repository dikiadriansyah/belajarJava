public class Getting_subnodes_of_preferences {
    // Getting sub-nodes of Preferences/Mendapatkan sub-node Preferensi

    // Objek Preferensi selalu mewakili node tertentu di seluruh pohon Preferensi,
    // seperti ini:

    /*
     * rRoot ├── com │ └── mycompany │ └── myapp │ ├── darkApplicationMode=true │
     * ├──
     * showExitConfirmation=false │ └── windowMaximized=true └── org └──
     * myorganization └── anotherapp ├──
     * defaultFont=Helvetica ├── defaultSavePath=/home/matt/Documents └── exporting
     * ├── defaultFormat=pdf └──
     * openInBrowserAfterExport=false
     */

    // Untuk memilih node /com/mycompany/myapp:

    // 1. Berdasarkan konvensi, berdasarkan paket suatu kelas:
    /*
     * package com.mycompany.myapp;
     * // ...
     * // Because this class is in the com.mycompany.myapp package, the node
     * // /com/mycompany/myapp will be returned.
     * Preferences myApp = Preferences.userNodeForPackage(getClass());
     */

    // 2. Melalui jalur relatif:
    // Preferences myApp = Preferences.userRoot().node("com/mycompany/myapp");

    /*
     * Menggunakan jalur relatif (jalur yang tidak dimulai dengan /) akan
     * menyebabkan jalur diselesaikan secara relatif terhadap induknya
     * simpul itu diselesaikan. Misalnya, contoh berikut akan mengembalikan node
     * jalur /one/two/three/com/mycompany/myapp:
     */

    /*
     * Preferences prefix = Preferences.userRoot().node("one/two/three");
     * Preferences myAppWithPrefix = prefix.node("com/mycompany/myapp");
     * // prefix is /one/two/three
     * // myAppWithPrefix is /one/two/three/com/mycompany/myapp
     */

    // 3. Melalui jalur absolut:
    // Preferences myApp = Preferences.userRoot().node("/com/mycompany/myapp");

    /*
     * Menggunakan jalur absolut pada node akar tidak akan berbeda dengan
     * menggunakan jalur relatif. Perbedaannya adalah, jika sub-node dipanggil,
     * jalur akan diselesaikan secara relatif terhadap node akar.
     */

    /*
     * Preferences prefix = Preferences.userRoot().node("one/two/three");
     * Preferences myAppWitoutPrefix = prefix.node("/com/mycompany/myapp");
     * // prefix is /one/two/three
     * // myAppWitoutPrefix is /com/mycompany/myapp
     */

    public static void main(String[] args) {
    }
}
