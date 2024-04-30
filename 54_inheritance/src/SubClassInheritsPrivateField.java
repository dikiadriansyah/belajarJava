public class SubClassInheritsPrivateField extends BaseClassWithPrivateField {
    public void printX() {
        // System.out.println(x); // Illegal, can't access private field x
        System.out.println(getX()); // Legal, prints 5
    }

    public static void main(String[] args) throws Exception {
        SubClassInheritsPrivateField s = new SubClassInheritsPrivateField();
        int x = s.getX(); // x will have a value of 5.
        System.out.println("Maka hasil adalah " + x); // Maka hasil adalah 5
    }
}
