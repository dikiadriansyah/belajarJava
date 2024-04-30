public class object_casting {

    public static void main(String[] args) throws Exception { // main method

        // Object Casting / Pengecoran Objek

        // seperti primitif, objek dapat dilemparkan baik secara eksplisit(explicitly)
        // dan implisit(implicitly)

        // pengecoran implisit terjadi ketika tipe sumber memperluas atau
        // mengimplementasikan tipe target(casting ke superclass atau interface)

        // pengecoran eksplisit harus dilakukan ketika tipe sumber diperluas atau
        // diimplementasikan oleh tipe target (casting ke subtipe).
        // ini dapat menghasilkan pengecualian runtime (ClassCastException) ketika objek
        // dilemparkan bukan dari jenis target(atau subtipe target).

        Float caraFloat = new Float(42.0f);
        // new Float() artinya untuk membuat sebuah instance dari sebuah kelas atau
        // array

        // System.out.println(caraFloat);
        // hasil:
        // 42.0

        // penjelasan:
        // awalnya membuat kelas yg di tulis public class object_casting(){},
        // selanjutnya didalam kelas berisi main method yg ditulis public static void
        // main(){},
        // selanjutnya dalam main method berisi tipe data dan variabel yang langsung
        // diisi dan ditulis Float caraFloat = new Float(42.0f),
        // selanjutnya tampilkan menggunakan System.out.println()

        Number caraNumber = caraFloat; // Implicit (float implement Number)
        // System.out.println(caraNumber);
        // hasil:
        // 42.0

        // penjelasan:
        //

        Float caraFloatDua = (Float) caraNumber; // Explicit
        System.out.println(caraFloatDua);
        // hasil:
        // 42.0

        Double caraDouble = (Double) caraNumber; // Throws Exception (objeknya tidak Ganda)
        // System.out.println(caraFloatDua);
        // hasil:
        // Exception in thread "main" java.lang.ClassCastException: java.lang.Float
        // cannot be cast to java.lang.Double
    }

}
