public class Static {
    // Static

    /*
     * Kata kunci statis digunakan pada kelas, metode, atau bidang untuk membuatnya
     * bekerja secara independen dari instance kelas mana pun.
     * 1. Bidang statis umum terjadi pada semua instance kelas. Mereka tidak
     * memerlukan sebuah instance untuk mengaksesnya.
     * 2. Metode statis dapat dijalankan tanpa turunan kelas tempat mereka berada.
     * Namun, metode statis hanya dapat mengakses bidang statis kelas tersebut.
     * 3. Kelas statis dapat dideklarasikan di dalam kelas lain. Mereka tidak
     * memerlukan instance dari kelas tempat mereka berada untuk dipakai.
     */

    /*
     * public class TestStatic
     * {
     * static int staticVariable;
     * static {
     * // This block of code is run when the class first loads
     * staticVariable = 11;
     * }
     * int nonStaticVariable = 5;
     * static void doSomething() {
     * // We can access static variables from static methods
     * staticVariable = 10;
     * }
     * void add() {
     * // We can access both static and non-static variables from non-static methods
     * nonStaticVariable += staticVariable;
     * }
     * static class StaticInnerClass {
     * int number;
     * public StaticInnerClass(int _number) {
     * number = _number;
     * }
     * void doSomething() {
     * // We can access number and staticVariable, but not nonStaticVariable
     * number += staticVariable;
     * }
     * int getNumber() {
     * return number;
     * }
     * }
     * }
     * // Static fields and methods
     * TestStatic object1 = new TestStatic();
     * System.out.println(object1.staticVariable); // 11
     * System.out.println(TestStatic.staticVariable); // 11
     * TestStatic.doSomething();
     * TestStatic object2 = new TestStatic();
     * System.out.println(object1.staticVariable); // 10
     * System.out.println(object2.staticVariable); // 10
     * System.out.println(TestStatic.staticVariable); // 10
     * object1.add();
     * System.out.println(object1.nonStaticVariable); // 15
     * System.out.println(object2.nonStaticVariable); // 10
     * // Static inner classes
     * StaticInnerClass object3 = new TestStatic.StaticInnerClass(100);
     * StaticInnerClass object4 = new TestStatic.StaticInnerClass(200);
     * System.out.println(object3.getNumber()); // 100
     * System.out.println(object4.getNumber()); // 200
     * object3.doSomething();
     * System.out.println(object3.getNumber()); // 110
     * System.out.println(object4.getNumber()); // 200
     * 
     */
    // ------------------
    static int staticVariable;
    static {
        // This block of code is run when the class first loads
        staticVariable = 11;
    }
    int nonStaticVariable = 5;

    static void doSomething() {
        // We can access static variables from static methods
        staticVariable = 10;
    }

    void add() {
        // We can access both static and non-static variables from non-static methods
        nonStaticVariable += staticVariable;
    }

    static class StaticInnerClass {
        int number;

        public StaticInnerClass(int _number) {
            number = _number;
        }

        void doSomething() {
            // We can access number and staticVariable, but not nonStaticVariable
            number += staticVariable;
        }

        int getNumber() {
            return number;
        }
    }

    public static void main(String[] args) throws Exception {
        Static box = new Static();
        System.out.println(box.staticVariable); // 11
        System.out.println(Static.staticVariable); // 11

        Static.doSomething();
        Static object2 = new Static();
        System.out.println(box.staticVariable); // 10
        System.out.println(object2.staticVariable); // 10
        System.out.println(Static.staticVariable); // 10

        box.add();
        System.out.println(box.nonStaticVariable); // 15
        System.out.println(object2.nonStaticVariable); // 10

        // Static inner classes
        StaticInnerClass object3 = new Static.StaticInnerClass(100);
        StaticInnerClass object4 = new Static.StaticInnerClass(200);
        System.out.println(object3.getNumber()); // 100
        System.out.println(object4.getNumber()); // 200

        object3.doSomething();
        System.out.println(object3.getNumber()); // 110
        System.out.println(object4.getNumber()); // 200
    }
}
