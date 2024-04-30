public class Super_keyword_use_with_examples extends Parentclass {
    // Super keyword use with examples/Penggunaan kata kunci super dengan contoh

    /*
     * kata kunci super memainkan peran penting di tiga tempat
     * 1. Constructor Level
     * 2. Method Level
     * 3. Variable Level
     */

    // Constructor Level
    /*
     * kata kunci super digunakan untuk memanggil konstruktor kelas induk.
     * Konstruktor ini dapat berupa konstruktor default atau
     * konstruktor berparameter.
     * 
     * Default constructor : super();
     * Parameterized constructor : super(int no, double amount, String name);
     */

    /*
     * class Parentclass
     * {
     * Parentclass(){
     * System.out.println("Constructor of Superclass");
     * }
     * }
     * class Subclass extends Parentclass
     * {
     * Subclass(){
     * System.out.println("Constructor of Subclass");
     * }
     * Subclass(int n1){
     * System.out.println("Constructor with arg");
     * }
     * void display(){
     * System.out.println("Hello");
     * }
     * public static void main(String args[]){
     * // Creating object using default constructor
     * Subclass obj= new Subclass();
     * //Calling sub class method
     * obj.display();
     * //Creating object 2 using arg constructor
     * Subclass obj2= new Subclass(10);
     * obj2.display();
     * }
     * }
     * 
     * 
     */

    // Catatan: super() harus menjadi pernyataan pertama dalam konstruktor jika
    // tidak kita akan mendapatkan pesan kesalahan kompilasi.

    // Method Level
    /*
     * kata kunci super juga dapat digunakan jika terjadi penggantian metode. kata
     * kunci super dapat digunakan untuk memanggil atau memanggil metode kelas
     * induk.
     */

    /*
     * class Parentclass
     * {
     * //Overridden method
     * void display(){
     * System.out.println("Parent class method");
     * }
     * }
     * class Subclass extends Parentclass
     * {
     * //Overriding method
     * void display(){
     * System.out.println("Child class method");
     * }
     * void printMsg(){
     * //This would call Overriding method
     * display();
     * //This would call Overridden method
     * super.display();
     * }
     * public static void main(String args[]){
     * Subclass obj= new Subclass();
     * obj.printMsg();
     * }
     * }
     * 
     */

    // Catatan: Jika tidak ada metode overriding maka kita tidak perlu menggunakan
    // kata kunci super untuk memanggil metode kelas induk

    // Variable level

    /*
     * super digunakan untuk merujuk variabel instan kelas induk langsung. Dalam hal
     * warisan, mungkin ada kemungkinan
     * kelas dasar dan kelas turunan mungkin memiliki anggota data yang serupa.
     * Untuk membedakan anggota data
     * kelas dasar/induk dan kelas turunan/anak, dalam konteks kelas turunan,
     * anggota data kelas dasar harus berada
     * didahului dengan kata kunci super.
     */

    /*
     * //Parent class or Superclass
     * class Parentclass
     * {
     * int num=100;
     * }
     * //Child class or subclass
     * class Subclass extends Parentclass
     * {
     * int num=110;
     * void printNumber(){
     * System.out.println(num); //It will print value 110
     * System.out.println(super.num); //It will print value 100
     * }
     * public static void main(String args[]){
     * Subclass obj= new Subclass();
     * obj.printNumber();
     * }
     * }
     */

    /*
     * Catatan: Jika kita tidak menuliskan kata kunci super sebelum nama anggota
     * data kelas dasar maka akan disebut sebagai
     * anggota data kelas saat ini dan anggota data kelas dasar disembunyikan dalam
     * konteks kelas turunan.
     */

    // Super_keyword_use_with_examples() {
    // System.out.println("Constructor of Subclass");
    // }

    // Super_keyword_use_with_examples(int n1) {
    // System.out.println("Constructor with arg");
    // }

    // void display() {
    // System.out.println("Hello");
    // }

    int num = 110;

    void printNumber() {
        System.out.println(num); // It will print value 110
        System.out.println(super.num); // It will print value 100
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Super_keyword_use_with_examples box1 = new Super_keyword_use_with_examples();
        // Calling sub class method
        // box1.display();

        // Creating object 2 using arg constructor
        // Super_keyword_use_with_examples obj2 = new
        // Super_keyword_use_with_examples(10);
        // obj2.display();

        /*
         * output:
         * Constructor of Superclass
         * Constructor of Subclass
         * Hello
         * Constructor of Superclass
         * Constructor with arg
         * Hello
         */
        // -------------
        Super_keyword_use_with_examples box1 = new Super_keyword_use_with_examples();
        box1.printNumber();
        /*
         * output:
         * 110
         * 100
         */
    }
}
