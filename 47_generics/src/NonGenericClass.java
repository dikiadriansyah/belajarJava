public class NonGenericClass implements MyGenericInterface<String> {
    public void foo(String t) {
        System.out.println("Value: " + t);
    } // type T has been replaced by String
}
