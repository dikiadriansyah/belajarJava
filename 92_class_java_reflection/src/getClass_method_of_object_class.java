public class getClass_method_of_object_class {
    // getClass() method of Object class/getClass() metode kelas Objek

    void printName(Object obj) {
        Class c = obj.getClass();
        System.out.println(c.getName());
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -----------------------
        Simple s = new Simple();

        getClass_method_of_object_class t = new getClass_method_of_object_class();
        t.printName(s);
        // output:
        // simple
    }
}
