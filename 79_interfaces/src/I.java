interface I {
    int VARIABLE = 0;

    void method();

    static void staticMethod() {
        System.out.println("Static method in interface I");
    }

    default void defaultMethod() {
        System.out.println("Default method in interface I");
    }
}