public interface Printable {
    default void printString() {
        System.out.println("default implementation");
    }
}
