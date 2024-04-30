public class Nested_break_continue {
    // Nested break / continue

    /*
     * Dimungkinkan untuk break/continue ke loop luar dengan menggunakan
     * pernyataan label:
     * 
     * outerloop:
     * for(...) {
     * innerloop:
     * for(...) {
     * if(condition1)
     * break outerloop;
     * if(condition2)
     * continue innerloop; // equivalent to: continue;
     * }
     * }
     * 
     */

    // Tidak ada kegunaan lain untuk label di Java
    public static void main(String[] args) {
        outerLoop: for (int i = 1; i <= 3; i++) {
            innerLoop: for (int j = 1; j <= 3; j++) {
                if (i * j == 6) {
                    System.out.println("Breaking outer loop at i=" + i + " and j=" + j);
                    break outerLoop;
                }

                if (i + j == 5) {
                    System.out.println("Continuing inner loop at i=" + i + " and j=" + j);
                    continue innerLoop;
                }

                System.out.println("i=" + i + ", j=" + j);
            }
        }

        /*
         * output:
         * i=1, j=1
         * i=1, j=2
         * i=1, j=3
         * i=2, j=1
         * i=2, j=2
         * Breaking outer loop at i=2 and j=3
         */

    }
}
