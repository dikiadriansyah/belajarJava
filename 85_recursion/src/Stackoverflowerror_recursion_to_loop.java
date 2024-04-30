import java.util.*;

public class Stackoverflowerror_recursion_to_loop {
    // StackOverflowError & recursion to loop/StackOverflowError & rekursi ke loop

    /*
     * Jika panggilan rekursif berjalan "terlalu dalam", ini akan menghasilkan
     * StackOverflowError. Java mengalokasikan frame baru untuk setiap pemanggilan
     * metode pada tumpukan threadnya. Namun, ruang tumpukan setiap thread terbatas.
     * Terlalu banyak frame pada tumpukan menyebabkan Stack Overflow (SO).
     */

    // Contoh
    /*
     * public static void recursion(int depth) {
     * if (depth > 0) {
     * recursion(depth-1);
     * }
     * }
     */

    /*
     * Memanggil metode ini dengan parameter besar (misalnya recursion (50000)
     * mungkin akan menghasilkan stack overflow. Nilai pastinya bergantung pada
     * ukuran tumpukan thread, yang pada gilirannya bergantung pada konstruksi
     * thread, parameter baris perintah seperti -Xss, atau ukuran default untuk JVM.
     */

    // Solusi
    /*
     * Rekursi dapat diubah menjadi loop dengan menyimpan data untuk setiap
     * panggilan rekursif dalam struktur data. data ini
     * struktur dapat disimpan di heap daripada di thread stack.
     * 
     * Secara umum data yang diperlukan untuk memulihkan keadaan pemanggilan metode
     * dapat disimpan dalam tumpukan dan perulangan while
     * dapat digunakan untuk "mensimulasikan" panggilan rekursif. Data yang mungkin
     * diperlukan meliputi:
     * 1.objek tempat metode dipanggil (hanya metode instance)
     * 2. parameter metode
     * 3. variabel lokal
     * 4. posisi saat ini dalam eksekusi atau metode
     */

    // contoh
    // Kelas berikut memungkinkan pencetakan struktur pohon secara rekursif hingga
    // kedalaman tertentu.

    /*
     * public class Node {
     * public int data;
     * public Node left;
     * public Node right;
     * public Node(int data) {
     * this(data, null, null);
     * }
     * public Node(int data, Node left, Node right) {
     * this.data = data;
     * this.left = left;
     * this.right = right;
     * }
     * public void print(final int maxDepth) {
     * if (maxDepth <= 0) {
     * System.out.print("(...)");
     * } else {
     * System.out.print("(");
     * if (left != null) {
     * left.print(maxDepth-1);
     * }
     * System.out.print(data);
     * if (right != null) {
     * right.print(maxDepth-1);
     * }
     * System.out.print(")");
     * }
     * }
     * }
     */

    // contoh:
    /*
     * Node n = new Node(10, new Node(20, new Node(50), new Node(1)), new Node(30,
     * new Node(42), null));
     * n.print(2);
     * System.out.println();
     * 
     */

    // cetak:
    // (((...)20(...))10((...)30))

    // Ini dapat dikonversi ke loop berikut:
    /*
     * public class Frame {
     * public final Node node;
     * // 0: before printing anything
     * // 1: before printing data
     * // 2: before printing ")"
     * public int state = 0;
     * public final int maxDepth;
     * public Frame(Node node, int maxDepth) {
     * this.node = node;
     * this.maxDepth = maxDepth;
     * }
     * }
     * List<Frame> stack = new ArrayList<>();
     * stack.add(new Frame(n, 2)); // first frame = initial call
     * while (!stack.isEmpty()) {
     * // get topmost stack element
     * int index = stack.size() - 1;
     * Frame frame = stack.get(index); // get topmost frame
     * if (frame.maxDepth <= 0) {
     * // termial case (too deep)
     * System.out.print("(...)");
     * stack.remove(index); // drop frame
     * } else {
     * switch (frame.state) {
     * case 0:
     * frame.state++;
     * // do everything done before the first recursive call
     * System.out.print("(");
     * if (frame.node.left != null) {
     * // add new frame (recursive call to left and stop)
     * stack.add(new Frame(frame.node.left, frame.maxDepth - 1));
     * break;
     * }
     * case 1:
     * frame.state++;
     * // do everything done before the second recursive call
     * System.out.print(frame.node.data);
     * if (frame.node.right != null) {
     * // add new frame (recursive call to right and stop)
     * stack.add(new Frame(frame.node.right, frame.maxDepth - 1));
     * break;
     * }
     * case 2:
     * // do everything after the second recursive call & drop frame
     * System.out.print(")");
     * stack.remove(index);
     * }
     * }
     * }
     * System.out.println();
     */

    /*
     * Catatan: Ini hanyalah contoh pendekatan umum. Seringkali Anda dapat menemukan
     * cara yang lebih baik untuk merepresentasikan sebuah frame dan/atau menyimpan
     * data frame.
     */

    public static void main(String[] args) {
        Node n = new Node(10, new Node(20, new Node(50), new Node(1)), new Node(30, new Node(42), null));
        n.print(2);
        // System.out.println();
        /*
         * output:
         * (((...)20(...))10((...)30))
         */
        // -------------------------
        List<Frame> stack = new ArrayList<>();
        stack.add(new Frame(n, 2)); // first frame = initial call
        while (!stack.isEmpty()) {
            // get topmost stack element
            int index = stack.size() - 1;
            Frame frame = stack.get(index); // get topmost frame
            if (frame.maxDepth <= 0) {
                // termial case (too deep)
                System.out.print("(...)");
                stack.remove(index); // drop frame
            } else {
                switch (frame.state) {
                    case 0:
                        frame.state++;
                        // do everything done before the first recursive call
                        System.out.print("(");
                        if (frame.node.left != null) {
                            // add new frame (recursive call to left and stop)
                            stack.add(new Frame(frame.node.left, frame.maxDepth - 1));
                            break;
                        }
                    case 1:
                        frame.state++;
                        // do everything done before the second recursive call
                        System.out.print(frame.node.data);
                        if (frame.node.right != null) {
                            // add new frame (recursive call to right and stop)
                            stack.add(new Frame(frame.node.right, frame.maxDepth - 1));
                            break;
                        }
                    case 2:
                        // do everything after the second recursive call & drop frame
                        System.out.print(")");
                        stack.remove(index);
                }
            }
        }
        System.out.println();
        /*
         * output:
         * (((...)20(...))10((...)30))(((...)20(...))10((...)30))
         */
    }
}
