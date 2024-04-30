public class Creating_a_generic_class {
    // Creating a Generic Class / Membuat Kelas Generik

    /*
     * Generik memungkinkan class, interfaces, dan methods untuk mengambil kelas dan
     * antarmuka lain sebagai parameter tipe.
     */

    // Contoh ini menggunakan kelas generik Param untuk mengambil parameter tipe
    // tunggal T, dibatasi oleh tanda kurung sudut (<>):

    /*
     * public class Param<T> {
     * private T value;
     * public T getValue() {
     * return value;
     * }
     * public void setValue(T value) {
     * this.value = value;
     * }
     * }
     */

    // Untuk membuat instance kelas ini, berikan argumen tipe sebagai pengganti T.
    // Misalnya, Integer:
    // Param<Integer> integerParam = new Param<Integer>();

    // Argumen tipe dapat berupa tipe referensi apa pun, termasuk array dan tipe
    // generik lainnya:

    /*
     * Param<String[]> stringArrayParam;
     * Param<int[][]> int2dArrayParam;
     * Param<Param<Object>> objectNestedParam;
     */

    /*
     * Di Java SE 7 dan yang lebih baru, argumen tipe bisa diganti dengan sekumpulan
     * argumen tipe kosong (<>) yang disebut berlian:
     */

    /*
     * Version ≥ Java SE 7
     * Param<Integer> integerParam = new Param<>();
     */

    /*
     * Tidak seperti pengidentifikasi lainnya, parameter tipe tidak memiliki batasan
     * penamaan. Namun nama mereka biasanya berada di urutan pertama
     * surat tujuannya dalam huruf besar. (Hal ini berlaku bahkan di seluruh
     * JavaDocs resmi.)
     * Contohnya termasuk T untuk "tipe", E untuk "elemen" dan K/V untuk
     * "kunci"/"nilai".
     */

    // Memperluas kelas generik
    /*
     * public abstract class AbstractParam<T> {
     * private T value;
     * public T getValue() {
     * return value;
     * }
     * public void setValue(T value) {
     * this.value = value;
     * }
     * }
     */

    /*
     * AbstractParam adalah kelas abstrak yang dideklarasikan dengan parameter tipe
     * T. Saat memperluas kelas ini, parameter tipe tersebut dapat diganti dengan
     * argumen tipe yang ditulis di dalam <>, atau parameter tipe tidak dapat
     * diubah. Pada contoh pertama dan kedua di bawah, String dan Integer
     * menggantikan parameter tipe. Pada contoh ketiga, parameter tipe tetap tidak
     * berubah. Contoh keempat tidak menggunakan obat generik sama sekali, jadi
     * mirip dengan jika kelas memiliki parameter Object. Kompilator akan
     * memperingatkan tentang AbstrakParam sebagai tipe mentah, tetapi ia akan
     * mengkompilasinya
     * kelas ObjectParam. Contoh kelima memiliki 2 parameter tipe (lihat
     * "beberapa parameter tipe" di bawah), memilih parameter kedua sebagai
     * parameter tipe yang diteruskan ke superclass.
     */

    /*
     * public class Email extends AbstractParam<String> {
     * // ...
     * }
     * public class Age extends AbstractParam<Integer> {
     * // ...
     * }
     * public class Height<T> extends AbstractParam<T> {
     * // ...
     * }
     * public class ObjectParam extends AbstractParam {
     * // ...
     * }
     * public class MultiParam<T, E> extends AbstractParam<E> {
     * // ...
     * }
     */

    // Berikut kegunaannya:
    /*
     * Email email = new Email();
     * email.setValue("test@example.com");
     * String retrievedEmail = email.getValue();
     * Age age = new Age();
     * age.setValue(25);
     * Integer retrievedAge = age.getValue();
     * int autounboxedAge = age.getValue();
     * Height<Integer> heightInInt = new Height<>();
     * heightInInt.setValue(125);
     * Height<Float> heightInFloat = new Height<>();
     * heightInFloat.setValue(120.3f);
     * MultiParam<String, Double> multiParam = new MultiParam<>();
     * multiParam.setValue(3.3);
     */

    /*
     * Perhatikan bahwa di kelas Email, metode T getValue() bertindak seolah-olah ia
     * memiliki tanda tangan dari String getValue(), dan
     * metode void setValue(T) bertindak seolah-olah dideklarasikan void
     * setValue(String).
     */

    // Dimungkinkan juga untuk membuat instance dengan kelas dalam anonim dengan
    // kurung kurawal kosong ({}):
    /*
     * AbstractParam<Double> height = new AbstractParam<Double>(){};
     * height.setValue(198.6);
     */

    // Perhatikan bahwa penggunaan berlian dengan kelas dalam anonim tidak
    // diperbolehkan

    // Multiple type parameters / Beberapa parameter tipe

    /*
     * Java menyediakan kemampuan untuk menggunakan lebih dari satu parameter tipe
     * dalam kelas atau antarmuka generik. Beberapa parameter tipe dapat digunakan
     * di kelas atau antarmuka dengan menempatkan daftar tipe yang dipisahkan koma
     * di antara tanda kurung siku. Contoh:
     * public class MultiGenericParam<T, S> {
     * private T firstParam;
     * private S secondParam;
     * 
     * public MultiGenericParam(T firstParam, S secondParam) {
     * this.firstParam = firstParam;
     * this.secondParam = secondParam;
     * }
     * 
     * public T getFirstParam() {
     * return firstParam;
     * }
     * 
     * public void setFirstParam(T firstParam) {
     * this.firstParam = firstParam;
     * }
     * 
     * public S getSecondParam() {
     * return secondParam;
     * }
     * 
     * public void setSecondParam(S secondParam) {
     * this.secondParam = secondParam;
     * }
     * }
     */

    // Penggunaannya dapat dilakukan seperti di bawah ini:
    /*
     * MultiGenericParam<String, String> aParam = new MultiGenericParam<String,
     * String>("value1",
     * "value2");
     * MultiGenericParam<Integer, Double> dayOfWeekDegrees = new
     * MultiGenericParam<Integer, Double>(1,
     * 2.6);
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        MultiGenericParam<String, String> aParam = new MultiGenericParam<String, String>("value1",
                "value2");
        MultiGenericParam<Integer, Double> dayOfWeekDegrees = new MultiGenericParam<Integer, Double>(1,
                2.6);
        // Menampilkan hasil
        System.out.println("aParam First Param: " + aParam.getFirstParam());
        System.out.println("aParam Second Param: " + aParam.getSecondParam());

        /*
         * output:
         * aParam First Param: value1
         * aParam Second Param: value2
         */

        System.out.println("dayOfWeekDegrees First Param: " + dayOfWeekDegrees.getFirstParam());
        System.out.println("dayOfWeekDegrees Second Param: " + dayOfWeekDegrees.getSecondParam());
        /*
         * output:
         * dayOfWeekDegrees First Param: 1
         * dayOfWeekDegrees Second Param: 2.6
         */
    }
}
