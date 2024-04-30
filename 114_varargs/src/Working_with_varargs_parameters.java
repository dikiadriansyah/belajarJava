public class Working_with_varargs_parameters {

    // Working with Varargs parameters/Bekerja dengan parameter Varargs

    /*
     * Dengan menggunakan varargs sebagai parameter untuk definisi metode,
     * dimungkinkan untuk meneruskan array atau rangkaian argumen. Jika serangkaian
     * argumen dilewatkan, argumen tersebut akan diubah menjadi array secara
     * otomatis.
     * 
     * Contoh ini menunjukkan array dan rangkaian argumen yang diteruskan ke metode
     * printVarArgArray(), dan bagaimana keduanya diperlakukan secara identik dalam
     * kode di dalam metode:
     * 
     * public class VarArgs {
     * 
     * // this method will print the entire contents of the parameter passed in
     * 
     * void printVarArgArray(int... x) {
     * for (int i = 0; i < x.length; i++) {
     * System.out.print(x[i] + ",");
     * }
     * }
     * 
     * public static void main(String args[]) {
     * VarArgs obj = new VarArgs();
     * 
     * //Using an array:
     * int[] testArray = new int[]{10, 20};
     * obj.printVarArgArray(testArray);
     * 
     * System.out.println(" ");
     * 
     * //Using a sequence of arguments
     * obj.printVarArgArray(5, 6, 5, 8, 6, 31);
     * }
     * }
     * 
     */

    // hasil:
    /*
     * 10,20,
     * 5,6,5,8,6,31
     */

    // Jika Anda mendefinisikan metode seperti ini, ini akan menghasilkan kesalahan
    // waktu kompilasi.
    /*
     * void method(String... a, int... b , int c){} //Compile time error (multiple
     * varargs )
     * 
     * void method(int... a, String b){} //Compile time error (varargs must be the
     * last argument
     */

    // ------------------
    void printVarArgArray(int... x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------------------------------------
        Working_with_varargs_parameters box = new Working_with_varargs_parameters();

        // Gunakan array:
        int[] cobaArray = new int[] { 10, 20 };
        box.printVarArgArray(cobaArray);

        System.out.println(" ");

        // Using a sequence of arguments
        box.printVarArgArray(5, 6, 5, 8, 6, 31);

        /*
         * output:
         * 10,20,
         * 5,6,5,8,6,31,
         */

    }
}
