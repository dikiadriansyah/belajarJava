public class Explaining_what_is_method_overloading_and_overriding {
    // Explaining what is method overloading and overriding / Menjelaskan apa itu
    // metode yang membebani dan mengesampingkan

    // Metode Overriding dan Overloading adalah dua bentuk polimorfisme yang
    // didukung oleh Java.

    // Method Overloading
    /*
     * Kelebihan metode (juga dikenal sebagai Polimorfisme statis) adalah cara Anda
     * dapat memiliki dua (atau lebih) metode (fungsi) dengan nama yang sama dalam
     * satu kelas. Ya, sesederhana itu.
     */

    /*
     * public class Shape{
     * //It could be a circle or rectangle or square
     * private String type;
     * 
     * //To calculate area of rectangle
     * public Double area(Long length, Long breadth){
     * return (Double) length * breadth;
     * }
     * 
     * //To calculate area of a circle
     * public Double area(Long radius){
     * return (Double) 3.14 * r * r;
     * }
     * }
     */

    /*
     * Dengan cara ini pengguna dapat memanggil metode yang sama untuk luas
     * tergantung pada jenis bentuk yang dimilikinya.
     * 
     * Tetapi pertanyaan sebenarnya sekarang adalah, bagaimana kompiler Java akan
     * membedakan badan metode mana yang akan dieksekusi?
     * 
     * Ya, Java telah memperjelas bahwa meskipun nama metode (area() dalam kasus
     * kami) bisa sama tetapi argumen yang digunakan metode harus berbeda.
     * 
     * Metode yang kelebihan beban harus memiliki daftar argumen yang berbeda
     * (kuantitas dan jenis).
     * 
     */

    /*
     * Meskipun demikian, kita tidak dapat menambahkan metode lain untuk menghitung
     * luas persegi seperti ini: public Double area(Long samping) karena dalam hal
     * ini akan bertentangan dengan metode area lingkaran
     * dan akan menyebabkan ambiguitas pada kompiler Java.
     * 
     * Alhamdulillah, ada beberapa relaksasi saat menulis metode yang kelebihan
     * beban seperti
     * Mungkin memiliki tipe pengembalian yang berbeda.
     * Mungkin memiliki pengubah akses yang berbeda.
     * Mungkin memberikan pengecualian yang berbeda.
     */

    // Mengapa ini disebut polimorfisme statis?
    /*
     * Itu karena metode kelebihan beban mana yang akan dipanggil ditentukan pada
     * waktu kompilasi, berdasarkan jumlah argumen sebenarnya dan tipe argumen pada
     * waktu kompilasi.
     * 
     * Salah satu alasan umum penggunaan metode kelebihan beban adalah kesederhanaan
     * kode yang disediakannya. Misalnya ingat String.valueOf() yang membutuhkan
     * hampir semua jenis argumen? Apa yang tertulis di balik layar mungkin seperti
     * ini:
     * static String valueOf(boolean b)
     * static String valueOf(char c)
     * static String valueOf(char[] data)
     * static String valueOf(char[] data, int offset, int count)
     * static String valueOf(double d)
     * static String valueOf(float f)
     * static String valueOf(int i)
     * static String valueOf(long l)
     * static String valueOf(Object obj)
     */

    // Method Overriding
    /*
     * Nah, metode overriding (ya, Anda dapat menebaknya dengan benar, ini juga
     * dikenal sebagai polimorfisme dinamis) adalah topik yang lebih menarik dan
     * kompleks.
     * 
     * Dalam penggantian metode, kami menimpa isi metode yang disediakan oleh kelas
     * induk. Mengerti? TIDAK? Mari kita lihat sebuah contoh.
     * 
     * public abstract class Shape{
     * 
     * public abstract Double area(){
     * return 0.0;
     * }
     * }
     */

    /*
     * Jadi kita mempunyai kelas bernama Shape dan mempunyai metode bernama area
     * yang mungkin akan mengembalikan luas dari bentuk tersebut.
     * 
     * Katakanlah sekarang kita mempunyai dua kelas bernama Lingkaran dan Persegi
     * Panjang.
     * 
     * public class Circle extends Shape {
     * private Double radius = 5.0;
     * // See this annotation @Override, it is telling that this method is from
     * parent
     * // class Shape and is overridden here
     * 
     * @Override
     * public Double area(){
     * return 3.14 * radius * radius;
     * }
     * }
     */

    // Demikian pula kelas persegi panjang:
    /*
     * public class Rectangle extends Shape {
     * private Double length = 5.0;
     * private Double breadth= 10.0;
     * // See this annotation @Override, it is telling that this method is from
     * parent
     * // class Shape and is overridden here
     * 
     * @Override
     * public Double area(){
     * return length * breadth;
     * }
     * }
     */

    /*
     * Jadi, sekarang kedua kelas anak Anda telah memperbarui isi metode yang
     * disediakan oleh kelas induk (Bentuk). Sekarang
     * pertanyaannya adalah bagaimana melihat hasilnya? Mari kita lakukan dengan
     * cara psvm yang lama
     */
    /*
     * public class AreaFinder{
     * 
     * public static void main(String[] args){
     * //This will create an object of circle class
     * Shape circle = new Circle();
     * //This will create an object of Rectangle class
     * Shape rectangle = new Rectangle();
     * 
     * // Drumbeats ......
     * //This should print 78.5
     * System.out.println("Shape of circle : "+circle.area());
     * //This should print 50.0
     * System.out.println("Shape of rectangle: "+rectangle.area());
     * 
     * }
     * }
     */

    /*
     * Wow! bukankah itu bagus? Dua objek dengan tipe yang sama memanggil metode
     * yang sama dan mengembalikan nilai yang berbeda. Sobat, itulah kekuatan
     * polimorfisme dinamis.
     * Berikut bagan untuk membandingkan perbedaan antara keduanya dengan lebih
     * baik:
     */

    /*
     * Method Overloading
     * 1. Metode kelebihan beban digunakan untuk meningkatkan keterbacaan
     * program.
     * 
     * 2. Metode kelebihan beban dilakukan di dalam kelas.
     * 
     * 3. Jika metode kelebihan beban, parameter harus
     * berbeda.
     * 
     * 4. Metode yang berlebihan adalah contoh waktu kompilasi
     * polimorfisme.
     * 
     * 5. Di java, metode kelebihan beban tidak dapat dilakukan oleh
     * mengubah tipe pengembalian metode saja. Tipe pengembalian bisa
     * sama atau berbeda dalam metode kelebihan beban. Namun Anda harus mengubah
     * parameternya.
     */

    /*
     * Method Overriding
     * 1. Metode overriding digunakan untuk memberikan yang spesifik
     * implementasi metode yang sudah disediakan oleh kelas supernya.
     * 2. Penggantian metode terjadi di dua kelas yang memiliki IS-A
     * hubungan (warisan).
     * 3. Dalam hal penggantian metode, parameter harus sama.
     * 4. Penggantian metode adalah contoh run time polimorfisme.
     * 5.Tipe pengembalian harus sama atau kovarian dalam penggantian metode.
     */

    public static void main(String[] args) {

        // --------------------------------
        // Method Overriding
        // This will create an object of circle class
        // Shape circle = new Circle();
        // This will create an object of Rectangle class
        // Shape rectangle = new Rectangle();

        // Drumbeats ......
        // This should print 78.5
        // System.out.println("Shape of circle : " + circle.area());

        // This should print 50.0
        // System.out.println("Shape of rectangle: " + rectangle.area());
        /*
         * output:
         * Shape of circle : 78.5
         * Shape of rectangle: 50.0
         */

        // -----------------
        Shape rectangle = new Shape("rectangle");
        Double rectangleArea = rectangle.area(5L, 8L);
        if (rectangleArea != null) {
            System.out.println("Area of rectangle: " + rectangleArea);
            // output:
            // Area of rectangle: 40.0
        }

        Shape circle = new Shape("circle");
        Double circleArea = circle.area2(4L);
        if (circleArea != null) {
            System.out.println("Area of circle: " + circleArea);
            // output:
            // Area of circle: 50.24
        }

    }
}
