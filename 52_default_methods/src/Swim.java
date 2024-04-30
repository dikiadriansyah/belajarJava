public interface Swim {
    void backStroke();

    default void sideStroke() {
        System.out.println("Default sidestroke implementation. Can be overridden");
    }
}