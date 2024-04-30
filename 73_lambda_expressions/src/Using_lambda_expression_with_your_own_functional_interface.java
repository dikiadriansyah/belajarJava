interface TwoArgInterface {
    int operate(int a, int b);
}

public class Using_lambda_expression_with_your_own_functional_interface {
    // Using lambda expression with your own functional interface/ Menggunakan
    // ekspresi lambda dengan antarmuka fungsional Anda sendiri

    /*
     * Lambdas dimaksudkan untuk menyediakan kode implementasi inline untuk
     * antarmuka metode tunggal dan kemampuan untuk menyebarkannya seperti yang
     * telah kita lakukan dengan variabel normal. Kami menyebutnya Antarmuka
     * Fungsional.
     * 
     * Misalnya, menulis Runnable di kelas anonim dan memulai Thread terlihat
     * seperti:
     * 
     * //Old way
     * new Thread(
     * new Runnable(){
     * public void run(){
     * System.out.println("run logic...");
     * }
     * }
     * ).start();
     * //lambdas, from Java 8
     * new Thread(
     * ()-> System.out.println("run logic...")
     * ).start();
     */

    /*
     * Sekarang, sejalan dengan di atas, katakanlah Anda memiliki beberapa antarmuka
     * khusus:
     * interface TwoArgInterface {
     * int operate(int a, int b);
     * }
     */

    /*
     * Bagaimana Anda menggunakan lambda untuk mengimplementasikan antarmuka ini
     * dalam kode Anda? Sama seperti contoh Runnable yang ditunjukkan di atas. Lihat
     * program drivernya di bawah ini:
     * 
     * public class CustomLambda {
     * public static void main(String[] args) {
     * TwoArgInterface plusOperation = (a, b) -> a + b;
     * TwoArgInterface divideOperation = (a,b)->{
     * if (b==0) throw new IllegalArgumentException("Divisor can not be 0");
     * return a/b;
     * };
     * System.out.println("Plus operation of 3 and 5 is: " +
     * plusOperation.operate(3, 5));
     * System.out.println("Divide operation 50 by 25 is: " +
     * divideOperation.operate(50, 25));
     * }
     * }
     * 
     */

    public static void main(String[] args) {
        TwoArgInterface plusOperation = (a, b) -> a + b;
        TwoArgInterface divideOperation = (a, b) -> {
            if (b == 0)
                throw new IllegalArgumentException("Divisor can not be 0");
            return a / b;
        };
        System.out.println("Plus operation of 3 and 5 is: " + plusOperation.operate(3, 5));
        /*
         * output:
         * Plus operation of 3 and 5 is: 8
         */

        System.out.println("Divide operation 50 by 25 is: " + divideOperation.operate(50, 25));
        /*
         * output:
         * Divide operation 50 by 25 is: 2
         */
    }
}
