public class Static_vs_non_static_nested_classes {
    // Static vs Non Static Nested Classes / Kelas Bersarang Statis vs Non Statis

    /*
     * Saat membuat kelas bersarang, Anda menghadapi pilihan untuk menjadikan kelas
     * bersarang itu statis:
     * public class OuterClass1 {
     * private static class StaticNestedClass {
     * }
     * }
     */

    // atau non-static:
    /*
     * public class OuterClass2 {
     * private class NestedClass {
     * }
     * }
     */

    /*
     * Pada intinya, kelas bersarang statis tidak memiliki instance kelas luar di
     * sekitarnya, sedangkan kelas bersarang non-statis
     * kelas melakukannya. Hal ini mempengaruhi di mana/kapan seseorang diizinkan
     * untuk membuat instance kelas bersarang, dan instance kelas bersarang mana
     * yang boleh diakses. Menambahkan contoh di atas:
     */

    /*
     * public class OuterClass1 {
     * private int aField;
     * public void aMethod(){}
     * private static class StaticNestedClass {
     * private int innerField;
     * private StaticNestedClass() {
     * innerField = aField; //Illegal, can't access aField from static context
     * aMethod(); //Illegal, can't call aMethod from static context
     * }
     * private StaticNestedClass(OuterClass1 instance) {
     * innerField = instance.aField; //Legal
     * }
     * }
     * public static void aStaticMethod() {
     * StaticNestedClass s = new StaticNestedClass(); //Legal, able to construct in
     * static context
     * //Do stuff involving s...
     * }
     * }
     * public class OuterClass2 {
     * private int aField;
     * public void aMethod() {}
     * private class NestedClass {
     * private int innerField;
     * private NestedClass() {
     * innerField = aField; //Legal
     * aMethod(); //Legal
     * }
     * }
     * public void aNonStaticMethod() {
     * NestedClass s = new NestedClass(); //Legal
     * }
     * public static void aStaticMethod() {
     * NestedClass s = new NestedClass(); //Illegal. Can't construct without
     * surrounding
     * OuterClass2 instance.
     * //As this is a static context, there is no surrounding
     * OuterClass2 instance
     * }
     * }
     */

    /*
     * Oleh karena itu, keputusan Anda untuk memilih statis vs non-statis terutama
     * bergantung pada apakah Anda harus dapat mengakses bidang dan metode kelas
     * luar secara langsung atau tidak, meskipun hal ini juga memiliki konsekuensi
     * terhadap kapan dan di mana Anda dapat membangun kelas bertingkat.
     * 
     * Sebagai aturan praktis, buat kelas bersarang Anda statis kecuali Anda perlu
     * mengakses bidang dan metode luar
     * kelas. Mirip dengan menjadikan bidang Anda pribadi kecuali Anda
     * membutuhkannya publik, hal ini mengurangi visibilitas yang tersedia untuk
     * kelas yang disarangkan (dengan tidak mengizinkan akses ke instance luar),
     * mengurangi kemungkinan kesalahan
     */

    private int aField;

    public void aMethod() {
        // Implementation of aMethod
    }

    private static class StaticNestedClass {
        private int innerField;

        private StaticNestedClass() {
            // Illegal, can't access aField from static context
            // aField = 10; // Uncommenting this line will result in a compilation error
            // aMethod(); // Illegal, can't call aMethod from static context
        }

        private StaticNestedClass(Static_vs_non_static_nested_classes instance) {
            // Legal, accessing aField through an instance of OuterClass1
            innerField = instance.aField;
        }
    }

    public static void main(String[] args) {
        Static_vs_non_static_nested_classes outerInstance = new Static_vs_non_static_nested_classes();
        outerInstance.aField = 42;

        // Creating an instance of the static nested class and passing the outerInstance
        StaticNestedClass nestedInstance = new StaticNestedClass(outerInstance);
        System.out.println("InnerField: " + nestedInstance.innerField);
        /*
         * output: InnerField: 42
         */
    }
}
