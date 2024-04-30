public class numeric_primitive_casting { // bagian class
    public static void main(String[] args) throws Exception { // main method

        // Numeric Primitive Casting / Pengecoran Primitif Numerik

        // primitif numerik dapat dilemparkan dengan 2 cara. pengecoran implisit
        // (implicit casting) terjadi
        // ketika tipe sumber memiliki jangkauan yang lebih kecil dari tipe target.

        // Implicit casting
        // byte byteVar = 42; // membuat variabel bertipe byte dan langsung diisi
        // nilai
        // short shortVar = byteVar;
        // int intVar = shortVar;
        // long longVar = intVar;
        // float floatVar = longVar;
        // double doubleVar = floatVar;

        // pengecoran eksplisit(Explicit casting) harus dilakukan ketika tipe sumber
        // memiliki jangkauan
        // yang lebih besar daripada tipe target.

        double doubleVar = 42.0d; // membuat variabel bertipe double dan langsung diisi nilai
        float floatVar = (float) doubleVar;
        long longVar = (long) floatVar;
        int intVar = (int) longVar;
        short shortVar = (short) intVar;
        byte byteVar = (byte) shortVar;

        System.out.println("Hello, World! Umurku sekarang " + byteVar);

        // hasil:
        // Hello, World! umurku sekarang 42

        // penjelasan:
        // awalnya membuat kelas yg di tulis public class numeric_primitive_casting(){},
        // selanjutnya didalam kelas berisi main method yg ditulis public static void
        // main(){},
        // selanjutnya didalam main method berisi 2 cara casting yaitu:
        // pertama, implicit casting yg berisi tipe data seperti: byte, short, int,
        // long, float, double,
        // kedua, explicit casting yg berisi tipe data seperti: double, float, long,
        // int, short, byte,
        // selanjutnya kita coba tampilkan dengan menulis System.out.println("") yg
        // berisi string ditambah variabel byteVar;
        // sehingga hasil menampilkan kalimat Hello, World! umurku sekarang 42

        // saat mentransmisikan primitif floating point(float, double) ke primitif
        // bilangan bulat (number primitive), jumlahnya dibulatkan ke bawah (rounded
        // down).

    }
}
