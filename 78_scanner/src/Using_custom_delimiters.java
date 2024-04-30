import java.util.Scanner;

public class Using_custom_delimiters {
    // Using custom delimiters/Menggunakan pembatas khusus

    /*
     * Anda dapat menggunakan pembatas khusus (ekspresi reguler) dengan Pemindai,
     * dengan .useDelimiter(","), untuk menentukan cara input dibaca. Ini bekerja
     * mirip dengan String.split(...). Misalnya, Anda dapat menggunakan Pemindai
     * untuk membaca dari daftar nilai yang dipisahkan koma dalam sebuah String:
     */

    /*
     * Scanner scanner = null;
     * try{
     * scanner = new Scanner("i,like,unicorns").useDelimiter(",");;
     * while(scanner.hasNext()){
     * System.out.println(scanner.next());
     * }
     * }catch(Exception e){
     * e.printStackTrace();
     * }finally{
     * if (scanner != null)
     * scanner.close();
     * }
     */

    /*
     * Ini akan memungkinkan Anda membaca setiap elemen dalam input satu per satu.
     * Perhatikan bahwa Anda tidak boleh menggunakan ini untuk mengurai data CSV,
     * sebagai gantinya, gunakan pustaka parser CSV yang tepat, lihat parser CSV
     * untuk Java untuk mengetahui kemungkinan lainnya.
     */

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner("i,like,unicorns").useDelimiter(",");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
        /*
         * output:
         * i
         * like
         * unicorns
         */

    }
}
