public class Abstract_methods_classes {
    // Abstract Methods & Classes / Metode & Kelas Abstrak

    // Abstract Method
    // dideklarasikan tanpa implementasi

    // C++
    // metode virtual murni
    // virtual void eat(void) = 0;

    // java
    // abstract method
    // abstract void draw();

    // Abstract Class
    // tidak dapat diinstansiasi

    // C++
    // tidak dapat dipakai; memiliki setidaknya 1 metode virtual murni
    // class AB {public: virtual void f() = 0;};

    // java
    // tidak dapat dipakai; dapat memiliki metode non-abstrak

    // abstract class GraphicObject {}
    // interface
    // tidak ada bidang contoh

    // C++
    // tidak ada yang sebanding dengan Java

    // Java
    // sangat mirip dengan kelas abstrak, tetapi 1) mendukung pewarisan berganda; 2)
    // tidak ada bidang contoh
    // interface TestInterface {}
    public static void main(String[] args) {
        Shape3 circle = new Circle4();
        Shape3 rectangle = new Rectangle2();

        circle.draw();
        rectangle.draw();
        /*
         * output:
         * Drawing a circle
         * Drawing a rectangle
         */
    }
}
