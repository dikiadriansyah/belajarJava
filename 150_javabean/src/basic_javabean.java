public class basic_javabean {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Membuat objek BasicJavaBean
        BasicJavaBean bean = new BasicJavaBean();

        // Mengatur nilai untuk properti-propertinya
        bean.setValue1(10);
        bean.setValue2("Hello, world!");
        bean.setValue3(true);

        // Mendapatkan nilai dari properti-propertinya
        int value1 = bean.getValue1();
        String value2 = bean.getValue2();
        boolean value3 = bean.isValue3();

        // Menampilkan nilai properti-properti
        System.out.println("Value 1: " + value1);// output: Value 1: 10
        System.out.println("Value 2: " + value2);// output: Value 2: Hello, world!
        System.out.println("Value 3: " + value3);// output: Value 3: true
    }
}
