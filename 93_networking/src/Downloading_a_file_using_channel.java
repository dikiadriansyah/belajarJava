import java.io.*;
import java.net.*;
import java.nio.channels.*;

public class Downloading_a_file_using_channel {
    // Downloading a file using Channel/Mengunduh file menggunakan Channel

    // Jika file sudah ada, maka akan ditimpa!

    /*
     * String fileName = "file.zip"; // name of the file
     * String urlToGetFrom = "http://www.mywebsite.com/"; // URL to get it from
     * String pathToSaveTo = "C:\\Users\\user\\"; // where to put it
     * //If the file already exists, it will be overwritten!
     * //Opening OutputStream to the destination file
     * 
     * try (ReadableByteChannel rbc =
     * Channels.newChannel(new URL(urlToGetFrom + fileName).openStream()) ) {
     * try ( FileChannel channel =
     * new FileOutputStream(pathToSaveTo + fileName).getChannel(); ) {
     * channel.transferFrom(rbc, 0, Long.MAX_VALUE);
     * }
     * catch (FileNotFoundException e) { //Output directory not found }
     * catch (IOException e) { // File IO error }
     * }
     * catch (MalformedURLException e) { // URL is malformed }
     * catch (IOException e) { // IO error connecting to website }
     * 
     * Catatan
     * 1. Jangan biarkan blok tangkapan kosong!
     * 2. Jika terjadi kesalahan, periksa apakah file jarak jauh ada
     * 3. Ini adalah operasi pemblokiran, bisa memakan waktu lama dengan file besar
     */

    public static void main(String[] args) {
        String fileName = "test.zip"; // nama file
        String urlToGetFrom = "https://cobaphpp.diksgroup.com/"; // URL untuk mengunduh file
        String pathToSaveTo = "D:\\box\\"; // tempat penyimpanan file

        // Membuka OutputStream untuk file tujuan
        try (ReadableByteChannel rbc = Channels.newChannel(new URL(urlToGetFrom + fileName).openStream())) {
            try (FileChannel channel = new FileOutputStream(pathToSaveTo + fileName).getChannel()) {
                channel.transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("File berhasil diunduh dan disimpan ke: " + pathToSaveTo + fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Direktori output tidak ditemukan.");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan IO pada file.");
            }
        } catch (MalformedURLException e) {
            System.out.println("URL tidak valid.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan IO saat menghubungkan ke website.");
        }
        /*
         * output:
         * File berhasil diunduh dan disimpan ke: D:\box\test.zip
         */
    }
}
