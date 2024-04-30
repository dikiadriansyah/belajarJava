public class Basic_usage_of_default_methods {
    // Basic usage of default methods / Penggunaan dasar metode default

    /*
     * 
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        WithDefault withDefault = new WithDefault();
        withDefault.printString(); // Output: default implementation

        OverrideDefault overrideDefault = new OverrideDefault();
        overrideDefault.printString(); // Output: overridden implementation

    }
}
