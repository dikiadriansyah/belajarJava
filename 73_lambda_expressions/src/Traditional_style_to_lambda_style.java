interface MathOperation {
    boolean unaryOperation(int num);
}

public class Traditional_style_to_lambda_style {
    // Traditional style to Lambda style/Gaya tradisional hingga gaya Lambda

    // Traditional way/Cara tradisional

    // public static void main(String[] args) {
    // MathOperation isEven = new MathOperation() {
    // @Override
    // public boolean unaryOperation(int num) {
    // return num % 2 == 0;
    // }
    // };

    // System.out.println(isEven.unaryOperation(25)); // output: false
    // System.out.println(isEven.unaryOperation(20)); // output: true
    // }

    // Lambda style/gaya Lambda
    // 1. Hapus nama kelas dan badan antarmuka fungsional
    public static void main(String[] args) {
        MathOperation isEven = (int num) -> {
            return num % 2 == 0;
        };

        // System.out.println(isEven.unaryOperation(25)); // output: false
        // System.out.println(isEven.unaryOperation(20)); // output: true
        // -----------------------
        // 2. Deklarasi tipe opsional
        MathOperation isEven2 = (num) -> {
            return num % 2 == 0;
        };

        // System.out.println(isEven2.unaryOperation(18)); // output: true

        // 3. Tanda kurung opsional di sekitar parameter, jika parameternya tunggal
        MathOperation isEven3 = num -> {
            return num % 2 == 0;
        };

        System.out.println(isEven3.unaryOperation(18)); // output: true

        /*
         * 4. Kurung kurawal opsional, jika hanya ada satu baris di fungsi body
         * 5. Kata kunci return opsional, jika hanya ada satu baris di fungsi body
         */
        // MathOperation isEven4 = num -> num % 2 == 0;
    }

}
