import java.util.*;

public class Stacks {
    // Stacks
    public static void main(String[] args) {
        /*
         * Apa itu Tumpukan?
         * Di Java, Stacks adalah struktur Data LIFO (Last In, First Out) untuk objek.
         * 
         * Stack API
         * Java berisi Stack API dengan metode berikut
         * Stack() //Creates an empty Stack
         * isEmpty() //Is the Stack Empty? Return Type: Boolean
         * push(Item item) //push an item onto the stack
         * pop() //removes item from top of stack Return Type: Item
         * size() //returns # of items in stack Return Type: Int
         */
        Stack st = new Stack();
        System.out.println("stack: " + st);

        st.push(10);
        System.out.println("10 didorong ke tumpukan");
        System.out.println("stack: " + st);

        st.push(15);
        System.out.println("15 didorong ke tumpukan");
        System.out.println("stack: " + st);

        st.push(80);
        System.out.println("80 didorong ke tumpukan");
        System.out.println("stack: " + st);
        st.pop();
        System.out.println("80 dikeluarkan dari tumpukan");
        System.out.println("stack: " + st);

        st.pop();
        System.out.println("15 dikeluarkan dari tumpukan");
        System.out.println("stack: " + st);

        st.pop();
        System.out.println("10 dikeluarkan dari tumpukan");
        System.out.println("stack: " + st);

        if (st.isEmpty()) {
            System.out.println("tumpukan kosong");
        }

        /*
         * output:
         * stack: []
         * 10 didorong ke tumpukan
         * stack: [10]
         * 15 didorong ke tumpukan
         * stack: [10, 15]
         * 80 didorong ke tumpukan
         * stack: [10, 15, 80]
         * 80 dikeluarkan dari tumpukan
         * stack: [10, 15]
         * 15 dikeluarkan dari tumpukan
         * stack: [10]
         * 10 dikeluarkan dari tumpukan
         * stack: []
         * empty stack
         */

    }
}
