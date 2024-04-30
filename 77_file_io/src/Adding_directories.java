import java.io.File;
import java.io.IOException;

public class Adding_directories {
    // Adding Directories/Menambahkan Direktori

    // Untuk membuat direktori baru dari instance File Anda perlu menggunakan salah
    // satu dari dua metode: mkdirs() atau mkdir().

    /*
     * mkdir() - Membuat direktori yang diberi nama dengan nama jalur abstrak ini.
     * (source)
     * mkdirs() - Membuat direktori yang diberi nama dengan nama jalur abstrak ini,
     * termasuk direktori induk yang diperlukan namun tidak ada. Perhatikan bahwa
     * jika operasi ini gagal, mungkin berhasil membuat beberapa direktori induk
     * yang diperlukan. (source)
     */

    // Catatan: createNewFile() tidak akan membuat direktori baru, hanya file

    /*
     * File singleDir = new File("C:/Users/SomeUser/Desktop/A New Folder/");
     * 
     * File multiDir = new
     * File("C:/Users/SomeUser/Desktop/A New Folder 2/Another Folder/");
     * // assume that neither "A New Folder" or "A New Folder 2" exist
     * singleDir.createNewFile(); // will make a new file called "A New Folder.file"
     * singleDir.mkdir(); // will make the directory
     * singleDir.mkdirs(); // will make the directory
     * multiDir.createNewFile(); // will throw a IOException
     * multiDir.mkdir(); // will not work
     * multiDir.mkdirs(); // will make the directory
     */
    public static void main(String[] args) {
        // Single directory creation
        File singleDir = new File("D:/");

        // Assume that "A New Folder" does not exist
        if (!singleDir.exists()) {
            // Create the directory
            singleDir.mkdir();
            System.out.println("Directory created: " + singleDir);
        }

        // Multi-level directory creation
        File multiDir = new File("D:/");

        // Assume that neither "A New Folder 2" nor "Another Folder" exist
        if (!multiDir.exists()) {
            // Create the directory and its parent directories if they don't exist
            multiDir.mkdirs();
            System.out.println("Directory created: " + multiDir);
        }

        // Creating a file in the single directory
        File singleFile = new File(singleDir, "A New Folder.file");
        try {
            if (singleFile.createNewFile()) {
                System.out.println("File created: " + singleFile);
            } else {
                System.out.println("File already exists: " + singleFile);
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        // Attempting to create a file in the multi-level directory (will throw
        // IOException)
        File multiFile = new File(multiDir, "SomeFile.txt");
        try {
            if (multiFile.createNewFile()) {
                System.out.println("File created: " + multiFile);
            } else {
                System.out.println("File already exists: " + multiFile);
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
