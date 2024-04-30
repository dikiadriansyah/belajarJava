public class A_simple_stack_using_a_nested_class {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Dan penggunaannya, yang (khususnya) sama sekali tidak mengakui keberadaan
        // kelas bersarang

        IntStack s = new IntStack();
        s.push(4).push(3).push(2).push(1).push(0);

        // prints: 0, 1, 2, 3, 4,
        for (int i = 0; i < 5; i++) {
            System.out.print(s.pop() + ", ");
        }

    }
}
