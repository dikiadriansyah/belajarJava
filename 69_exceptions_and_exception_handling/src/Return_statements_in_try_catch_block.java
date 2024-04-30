public class Return_statements_in_try_catch_block {
    // Return statements in try catch block/Kembalikan pernyataan di blok coba
    // tangkap

    /*
     * Meskipun ini merupakan praktik yang buruk, dimungkinkan untuk menambahkan
     * beberapa pernyataan pengembalian dalam blok penanganan pengecualian:
     * 
     * public static int returnTest(int number){
     * try{
     * if(number%2 == 0) throw new Exception("Exception thrown");
     * else return x;
     * }
     * catch(Exception e){
     * return 3;
     * }
     * finally{
     * return 7;
     * }
     * }
     * 
     */

    /*
     * Metode ini akan selalu mengembalikan 7 karena blok akhirnya yang terkait
     * dengan blok try/catch dieksekusi sebelumnya
     * semuanya dikembalikan. Sekarang, karena akhirnya return 7;, nilai ini
     * menggantikan nilai kembalian try/catch.
     * 
     * Jika blok catch mengembalikan nilai primitif dan nilai primitif tersebut
     * selanjutnya diubah di blok akhirnya, maka
     * nilai yang dikembalikan di blok catch akan dikembalikan dan perubahan dari
     * blok akhirnya akan diabaikan.
     */

    // Contoh di bawah ini akan mencetak "0", bukan "1"

    /*
     * public class FinallyExample {
     * public static void main(String[] args) {
     * int n = returnTest(4);
     * 
     * System.out.println(n);
     * }
     * public static int returnTest(int number) {
     * 
     * int returnNumber = 0;
     * 
     * try {
     * if (number % 2 == 0)
     * throw new Exception("Exception thrown");
     * else
     * return returnNumber;
     * } catch (Exception e) {
     * return returnNumber;
     * } finally {
     * returnNumber = 1;
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        int n = returnTest(4);

        System.out.println(n); // output: 0
    }

    public static int returnTest(int number) {

        int returnNumber = 0;

        try {
            if (number % 2 == 0)
                throw new Exception("Exception thrown");
            else
                return returnNumber;
        } catch (Exception e) {
            return returnNumber;
        } finally {
            returnNumber = 1;
        }
    }

}
