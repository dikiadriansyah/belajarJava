public class Traversing_a_tree_data_structure_with_recursion {
    // Traversing a Tree data structure with recursion/Melintasi struktur data Pohon
    // dengan rekursi

    /*
     * Misalkan kelas Node memiliki 3 data anggota, penunjuk anak kiri dan penunjuk
     * anak kanan seperti di bawah ini.
     * 
     * public class Node {
     * public int data;
     * public Node left;
     * public Node right;
     * 
     * public Node(int data){
     * this.data = data;
     * }
     * }
     * 
     */

    /*
     * Kita dapat melintasi pohon yang dibangun dengan menghubungkan beberapa objek
     * kelas Node seperti di bawah ini, traversal tersebut disebut in-order
     * traversal of tree.
     */
    /*
     * public static void inOrderTraversal(Node root) {
     * if (root != null) {
     * inOrderTraversal(root.left); // traverse left sub tree
     * System.out.print(root.data + " "); // traverse current node
     * inOrderTraversal(root.right); // traverse right sub tree
     * }
     * }
     */

    /*
     * Seperti yang ditunjukkan di atas, dengan menggunakan recursion kita dapat
     * melintasi struktur data pohon tanpa menggunakan struktur data lain apa pun
     * yang tidak mungkin dilakukan dengan pendekatan berulang.
     */

    public static void main(String[] args) {
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        // Menjalankan penelusuran inorder pada pohon biner
        System.out.println("Inorder traversal of binary tree:");
        inOrderTraversal(root);

        // 1
        // / \
        // 2 3
        // / \
        // 4 5
    }

    public static void inOrderTraversal(Node4 root) {
        if (root != null) {
            inOrderTraversal(root.left); // traverse left sub tree
            System.out.print(root.data + " "); // traverse current node
            inOrderTraversal(root.right); // traverse right sub tree
        }
    }

}
