public class Expression_evaluation_order {
    // Expression evaluation order/Urutan evaluasi ekspresi

    // Ekspresi Java dievaluasi mengikuti aturan berikut:

    /*
     * Operan dievaluasi dari kiri ke kanan.
     * Operan suatu operator dievaluasi sebelum operator.
     * Operator dievaluasi berdasarkan prioritas operator
     * Daftar argumen dievaluasi dari kiri ke kanan.
     */

    // contoh sederhana
    // Dalam contoh berikut:
    // int i = method1() + method2();

    // urutan evaluasinya adalah:
    /*
     * 1. left operand dari operator = dievaluasi ke alamat i.
     * 2. left operand dari operator + (metode1()) dievaluasi.
     * 3. right operand dari operator + (metode2()) dievaluasi.
     * 4. Operasi + dievaluasi.
     * 5. Operasi = dievaluasi, menugaskan hasil penjumlahan ke i.
     */

    /*
     * Perhatikan bahwa jika efek dari panggilan dapat diamati, Anda akan dapat
     * mengamati bahwa panggilan ke metode1 terjadi sebelum panggilan ke metode2.
     */

    // Contoh dengan operator yang memiliki efek samping
    /*
     * Dalam contoh berikut:
     * int i = 1;
     * intArray[i] = ++i + 1;
     */

    /*
     * urutan evaluasinya adalah:
     * 1. Operan kiri operator = dievaluasi. Ini memberikan alamat intArray[1].
     * 2. Kenaikan awal dievaluasi. Ini menambahkan 1 ke i, dan mengevaluasi ke 2.
     * 3. Operan sebelah kanan dari + dievaluasi.
     * 4. Operasi + dievaluasi menjadi: 2 + 1 -> 3.
     * 5. Operasi = dievaluasi, menugaskan 3 ke intArray[1].
     */

    // Perhatikan bahwa karena operan sebelah kiri dari = dievaluasi terlebih
    // dahulu, maka operan tersebut tidak dipengaruhi oleh efek samping dari
    // subekspresi ++i.

    public static void main(String[] args) throws Exception {
        int i = 1;
        int[] intArray = new int[3];
        intArray[i] = ++i + 1;
        System.out.println(intArray[1]); // Output: 3
    }
}
