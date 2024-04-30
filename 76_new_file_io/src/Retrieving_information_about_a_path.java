import java.nio.file.Path;
import java.nio.file.Paths;

public class Retrieving_information_about_a_path {
    // Retrieving information about a path/Mengambil informasi tentang suatu jalur

    /*
     * Informasi tentang suatu jalur dapat diperoleh dengan menggunakan metode objek
     * Jalur:
     * 
     * toString() mengembalikan representasi string dari jalur
     * Path p1 = Paths.get("/var/www"); // p1.toString() returns "/var/www"
     * 
     * getFileName() mengembalikan nama file (atau, lebih khusus lagi, elemen
     * terakhir dari jalur tersebut
     * Path p1 = Paths.get("/var/www"); // p1.getFileName() returns "www"
     * Path p3 = Paths.get("C:\\Users\\DentAr\\Documents\\HHGTDG.odt"); //
     * p3.getFileName() returns
     * "HHGTDG.odt"
     * 
     * getNameCount() mengembalikan jumlah elemen yang membentuk jalur
     * Path p1 = Paths.get("/var/www"); // p1.getNameCount() returns 2
     * 
     * getName(int indeks) mengembalikan elemen pada indeks yang diberikan
     * Path p1 = Paths.get("/var/www"); // p1.getName(0) returns "var",
     * p1.getName(1) returns "www"
     * 
     * getParent() mengembalikan jalur direktori induk
     * Path p1 = Paths.get("/var/www"); // p1.getParent().toString() returns "/var"
     * 
     * getRoot() mengembalikan akar jalur
     * Path p1 = Paths.get("/var/www"); // p1.getRoot().toString() returns "/"
     * Path p3 = Paths.get("C:\\Users\\DentAr\\Documents\\HHGTDG.odt"); //
     * p3.getRoot().toString()
     * returns "C:\\"
     */
    public static void main(String[] args) {
        Path p1 = Paths.get("/var/www");
        System.out.println("path: " + p1);
        /*
         * output:
         * path: \var\www
         */

    }
}
