import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.io.FileOutputStream;

public class Migrating_from_java_io_file_to_java7_nio {
    // Migrating from java.io.File to Java 7 NIO(java.nio.file.Path)/Bermigrasi dari
    // java.io.File ke Java 7 NIO(java.nio.file.Path)

    /*
     * Contoh-contoh ini mengasumsikan bahwa Anda sudah mengetahui apa itu NIO Java
     * 7 secara umum, dan Anda terbiasa menulis kode
     * menggunakan java.io.File. Gunakan contoh berikut sebagai sarana untuk segera
     * menemukan lebih banyak dokumentasi yang berpusat pada NIO untuk migrasi.
     * 
     * Ada lebih banyak hal di NIO Java 7 seperti file yang dipetakan memori atau
     * membuka file ZIP atau JAR menggunakan FileSystem.
     * Contoh-contoh ini hanya akan mencakup sejumlah kasus penggunaan dasar.
     * 
     * Sebagai aturan dasar, jika Anda terbiasa melakukan operasi baca/tulis sistem
     * file menggunakan instance metode java.io.File, Anda akan menemukannya sebagai
     * metode statis dalam java.nio.file.Files.
     */

    // Point to a path/Tunjuk ke sebuah jalan
    /*
     * // -> IO
     * File file = new File("io.txt");
     * 
     * // -> NIO
     * Path path = Paths.get("nio.txt");
     */

    // Paths relative to another path/Jalur relatif terhadap jalur lain
    // Garis miring ke depan dapat digunakan sebagai pengganti garis miring terbalik
    // bahkan pada sistem operasi Windows -> IO

    /*
     * File folder = new File("C:/");
     * File fileInFolder = new File(folder, "io.txt");
     * // -> NIO
     * Path directory = Paths.get("C:/");
     * Path pathInDirectory = directory.resolve("nio.txt");
     */

    // Converting File from/to Path for use with libraries / Mengonversi File
    // dari/ke Path untuk digunakan dengan perpustakaan

    /*
     * // -> IO to NIO
     * Path pathFromFile = new File("io.txt").toPath();
     * // -> NIO to IO
     * File fileFromPath = Paths.get("nio.txt").toFile();
     */

    // Check if the file exists and delete it if it does/Periksa apakah file
    // tersebut ada dan hapus jika ada
    /*
     * // -> IO
     * if (file.exists()) {
     * boolean deleted = file.delete();
     * if (!deleted) {
     * throw new IOException("Unable to delete file");
     * }
     * }
     * // -> NIO
     * Files.deleteIfExists(path);
     */

    // Write to a file via an OutputStream/Menulis ke file melalui OutputStream
    /*
     * Ada beberapa cara untuk menulis dan membaca dari file menggunakan NIO untuk
     * batasan performa dan memori yang berbeda,
     * keterbacaan dan kasus penggunaan, seperti FileChannel, Files.write(Path path,
     * byte\[\] bytes, OpenOption...options)... Dalam contoh ini, hanya OutputStream
     * yang tercakup, namun Anda sangat dianjurkan untuk mempelajari tentang
     * memorymapped file dan berbagai metode statis yang tersedia di
     * java.nio.file.Files.
     */

    /*
     * List<String> lines = Arrays.asList(
     * String.valueOf(Calendar.getInstance().getTimeInMillis()),
     * "line one",
     * "line two");
     * // -> IO
     * if (file.exists()) {
     * // Note: Not atomic
     * throw new IOException("File already exists");
     * }
     * try (FileOutputStream outputStream = new FileOutputStream(file)) {
     * for (String line : lines) {
     * outputStream.write((line +
     * System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
     * }
     * }
     * // -> NIO
     * try (OutputStream outputStream = Files.newOutputStream(path,
     * StandardOpenOption.CREATE_NEW)) {
     * for (String line : lines) {
     * outputStream.write((line +
     * System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
     * }
     * }
     */

    // Iterating on each file within a folder/ Iterasi pada setiap file dalam folder
    /*
     * // -> IO
     * for (File selectedFile : folder.listFiles()) {
     * // Note: Depending on the number of files in the directory folder.listFiles()
     * may take a long
     * time to return
     * System.out.println((selectedFile.isDirectory() ? "d" : "f") + " " +
     * selectedFile.getAbsolutePath());
     * }
     * // -> NIO
     * Files.walkFileTree(directory, EnumSet.noneOf(FileVisitOption.class), 1, new
     * SimpleFileVisitor<Path>() {
     * 
     * @Override
     * public FileVisitResult preVisitDirectory(Path selectedPath,
     * BasicFileAttributes attrs) throws
     * IOException {
     * System.out.println("d " + selectedPath.toAbsolutePath());
     * return FileVisitResult.CONTINUE;
     * }
     * 
     * @Override
     * public FileVisitResult visitFile(Path selectedPath, BasicFileAttributes
     * attrs) throws
     * IOException {
     * System.out.println("f " + selectedPath.toAbsolutePath());
     * return FileVisitResult.CONTINUE;
     * }
     * });
     */

    // Recursive folder iteration/Iterasi folder rekursif
    /*
     * // -> IO
     * recurseFolder(folder);
     * // -> NIO
     * // Note: Symbolic links are NOT followed unless explicitly passed as an
     * argument to
     * Files.walkFileTree
     * Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
     * 
     * @Override
     * public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
     * throws
     * IOException {
     * System.out.println("d " + selectedPath.toAbsolutePath());
     * return FileVisitResult.CONTINUE;
     * }
     * 
     * @Override
     * public FileVisitResult visitFile(Path selectedPath, BasicFileAttributes
     * attrs) throws
     * IOException {
     * System.out.println("f " + selectedPath.toAbsolutePath());
     * return FileVisitResult.CONTINUE;
     * }
     * });
     * private static void recurseFolder(File folder) {
     * for (File selectedFile : folder.listFiles()) {
     * System.out.println((selectedFile.isDirectory() ? "d" : "f") + " " +
     * selectedFile.getAbsolutePath());
     * if (selectedFile.isDirectory()) {
     * // Note: Symbolic links are followed
     * recurseFolder(selectedFile);
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // File file = new File("io.txt");

        // Menampilkan informasi tentang file
        // System.out.println("Nama file: " + file.getName());
        /*
         * output:
         * Nama file: io.txt
         */

        // System.out.println("Path file: " + file.getAbsolutePath());
        /*
         * output:
         * Path file: D:\belajarJava\io.txt
         */
        // -------------------------------------
        // String folderPath = "D:/belajarJava/";
        // File folder = new File(folderPath);

        // Membuat folder jika belum ada
        // if (!folder.exists()) {
        // folder.mkdirs();
        // }

        // Menentukan nama file
        // String fileName = "io.txt";
        // File fileInFolder = new File(folder, fileName);

        // try {
        // // Membuat file jika belum ada
        // if (fileInFolder.createNewFile()) {
        // System.out.println("File baru berhasil dibuat: " +
        // fileInFolder.getAbsolutePath());
        // } else {
        // System.out.println("File sudah ada: " + fileInFolder.getAbsolutePath());
        // }
        // } catch (IOException e) {
        // System.out.println("Terjadi kesalahan saat membuat file: " + e.getMessage());
        // }
        // -------------------------------------
        // Membuat objek Path dari file "io.txt" menggunakan File
        // Path pathFromFile = new File("io.txt").toPath();

        // Membuat objek Path dari file "io.txt" menggunakan Paths
        // Path pathFromPaths = Paths.get("io.txt");

        // Menampilkan informasi Path
        // System.out.println("Path dari File: " + pathFromFile);
        /*
         * output:
         * Path dari File: io.txt
         */

        // System.out.println("Path dari Paths: " + pathFromPaths);
        /*
         * output:
         * Path dari Paths: io.txt
         */
        // -------------------------------------
        // Ganti path dengan path yang sesuai dengan file yang ingin dihapus
        // String filePath = "io.txt";
        // File file = new File(filePath);

        // try {
        // deleteFile(file);
        // System.out.println("File deleted successfully.");
        // } catch (IOException e) {
        // System.err.println("Error deleting file: " + e.getMessage());
        // }
        // -------------------------------------
        // File file = new File("example2.txt");

        // List<String> lines = Arrays.asList(
        // String.valueOf(Calendar.getInstance().getTimeInMillis()),
        // "line one",
        // "line two");

        // try {
        // writeFile(file, lines);
        // System.out.println("File has been successfully written.");
        // } catch (IOException e) {
        // System.err.println("Error writing to the file: " + e.getMessage());
        // }
        /*
         * output:
         * File has been successfully written.
         */
        // -------------------------------
        // Ganti pathFolder dengan path direktori yang ingin Anda jelajahi
        // String pathFolder = "D:/belajarJava/77_file_io/";
        // File folder = new File(pathFolder);

        // // Memastikan bahwa path yang diberikan adalah direktori
        // if (folder.isDirectory()) {
        // // Menampilkan informasi tentang setiap file dan folder dalam direktori
        // for (File selectedFile : folder.listFiles()) {
        // String fileType = selectedFile.isDirectory() ? "d" : "f";
        // String filePath = selectedFile.getAbsolutePath();
        // System.out.println(fileType + " " + filePath);
        // }
        // } else {
        // System.out.println("Path yang diberikan bukan direktori.");
        // }

        /*
         * output:
         * d D:\belajarJava\77_file_io\.vscode
         * d D:\belajarJava\77_file_io\lib
         * f D:\belajarJava\77_file_io\README.md
         * d D:\belajarJava\77_file_io\src
         */
        // -----------------------
        // Ganti pathFolder dengan path folder yang ingin Anda jelajahi
        String pathFolder = "D:/belajarJava/77_file_io/";
        recurseFolder(new File(pathFolder));
        /*
         * output:
         * Folder: D:\belajarJava\77_file_io
         * Folder: D:\belajarJava\77_file_io\.vscode
         * File: D:\belajarJava\77_file_io\.vscode\settings.json
         * Folder: D:\belajarJava\77_file_io\lib
         * File: D:\belajarJava\77_file_io\README.md
         * Folder: D:\belajarJava\77_file_io\src
         * File:
         * D:\belajarJava\77_file_io\src\Migrating_from_java_io_file_to_java7_nio.java
         */

    }

    // private static void deleteFile(File file) throws IOException {
    // if (file.exists()) {
    // boolean deleted = file.delete();
    // if (!deleted) {
    // throw new IOException("Unable to delete file");
    // }
    // } else {
    // System.out.println("File does not exist.");
    // }
    // }
    // -----------------------
    // private static void writeFile(File file, List<String> lines) throws
    // IOException {
    // if (file.exists()) {
    // throw new IOException("File already exists");
    // }

    // try (FileOutputStream outputStream = new FileOutputStream(file)) {
    // for (String line : lines) {
    // outputStream.write((line +
    // System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
    // }
    // }
    // }
    // --------------
    public static void recurseFolder(File folder) {
        if (folder.isDirectory()) {
            System.out.println("Folder: " + folder.getAbsolutePath());
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    recurseFolder(file);
                }
            }
        } else {
            System.out.println("File: " + folder.getAbsolutePath());
        }
    }
}
