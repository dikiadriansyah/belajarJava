public class Different_cases_when_integer_and_int_can_be_used_interchangeably {
    // Different Cases When Integer and int can be used interchangeably / Kasus
    // Berbeda Ketika Integer dan int dapat digunakan secara bergantian

    /*
     * Kasus 1: Saat menggunakan argumen metode.
     * Jika suatu metode memerlukan objek kelas pembungkus sebagai argumen. Kemudian
     * argumen tersebut dapat diteruskan ke variabel dari tipe primitifnya
     * masing-masing dan sebaliknya.
     * 
     * contoh:
     * int i;
     * Integer j;
     * void ex_method(Integer i)//Is a valid statement
     * void ex_method1(int j)//Is a valid statement
     * 
     * 
     * Kasus 2: Saat meneruskan nilai pengembalian:
     * Ketika suatu metode mengembalikan variabel tipe primitif maka objek dari
     * kelas pembungkus yang sesuai dapat diteruskan sebagai
     * nilai kembalian secara bergantian dan sebaliknya.
     * 
     * contoh:
     * int i;
     * Integer j;
     * int ex_method()
     * {...
     * return j;}//Is a valid statement
     * Integer ex_method1()
     * {...
     * return i;//Is a valid statement
     * }
     * 
     * 
     * 
     */

    /*
     * Kasus 3: Saat melakukan operasi.
     * Setiap kali melakukan operasi pada angka, variabel tipe primitif dan objek
     * dari kelas pembungkus masing-masing dapat digunakan secara bergantian.
     * 
     * int i=5;
     * Integer j=new Integer(7);
     * int k=i+j;//Is a valid statement
     * Integer m=i+j;//Is also a valid statement
     * 
     * Kesalahan: Ingatlah untuk menginisialisasi atau memberikan nilai pada objek
     * kelas wrapper.
     */

    /*
     * Saat menggunakan objek kelas wrapper dan variabel primitif secara bergantian,
     * jangan pernah lupa atau melewatkan untuk menginisialisasi atau menetapkan
     * nilai ke objek kelas wrapper, jika tidak, hal ini dapat menyebabkan
     * pengecualian penunjuk nol saat runtime.
     * 
     * contoh:
     * public class Test{
     * Integer i;
     * int j;
     * public void met()
     * {j=i;//Null pointer exception
     * SOP(j);
     * SOP(i);}
     * public static void main(String[] args)
     * {Test t=new Test();
     * t.go();//Null pointer exception
     * }
     * 
     * Dalam contoh di atas, nilai objek belum ditetapkan dan tidak diinisialisasi
     * sehingga pada saat runtime program akan mengalami pengecualian penunjuk nol.
     * Jadi, seperti jelas dari contoh di atas, nilai objek tidak boleh dibiarkan
     * tidak diinisialisasi dan tidak ditetapkan.
     * 
     */
    // -------------
    // int i;
    // Integer j;

    // void ex_method(Integer i) {
    // System.out.println("ex_method(Integer i) is called");
    // }// Is a valid statement

    // void ex_method1(int j) {
    // System.out.println("ex_method1(int j) is called");
    // }// Is a valid statement

    // --------
    // int i;
    // Integer j;

    // int ex_method() {
    // return j;
    // }// Is a valid statement

    // Integer ex_method1() {
    // return i;// Is a valid statement
    // }
    // ----------------------------

    // Integer i;
    // int j;

    // public void met() {
    // j = i;// Null pointer exception
    // SOP(j);
    // SOP(i);
    // }

    public static void main(String[] args) {
        Different_cases_when_integer_and_int_can_be_used_interchangeably box = new Different_cases_when_integer_and_int_can_be_used_interchangeably();

        // Testing method with Integer parameter
        // Integer integerObject = 10;
        // box.ex_method(integerObject); // output: ex_method(Integer i) is called

        // Testing method with int parameter
        // int intValue = 20;
        // box.ex_method1(intValue); // output: ex_method1(int j) is called

        // -------------
        // box.i = 5;
        // box.j = 10;

        // System.out.println("Result of ex_method(): " + box.ex_method()); // output:
        // Result of ex_method(): 10
        // System.out.println("Result of ex_method1(): " + box.ex_method1()); // output:
        // Result of ex_method1(): 5

        // -------------
        // int i = 5;
        // Integer j = new Integer(7);
        // int k = i + j;// Is a valid statement
        // Integer m = i + j;// Is also a valid statement

        // System.out.println("k: " + k); // Output: k: 12
        // System.out.println("m: " + m); // Output: m: 12
        // ---------------------------------------

        // Different_cases_when_integer_and_int_can_be_used_interchangeably t = new
        // Different_cases_when_integer_and_int_can_be_used_interchangeably();
        // t.go();// Null pointer exception
    }
}
