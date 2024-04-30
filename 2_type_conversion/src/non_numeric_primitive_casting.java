public class non_numeric_primitive_casting { // bagian class
    public static void main(String[] args) throws Exception { // main method

        // Non-numeric primitive casting / Pengecoran primitif non-numerik

        // tipe boolean tidak dapat dilemparkan to/from tipe primitif lainnya.

        // char dapat dilemparkan to/from tipe numerik apapun dengan menggunakan
        // pemetaan titik kode yang ditentukan oleh unicode. Char direpresentasikan
        // dalam memori sebagai nilai integer 16-bit yang tidak ditandatangani(2 byte),
        // jadi transmisi ke byte (1 byte) akan menghilangkan 8 dari itu bit (ini aman
        // untuk karakter ASCII).
        // metode utilitas kelas karakter menggunakan int(4 byte) untuk mentransfer
        // to/from nilai titik kode(code-point values), tetapi short (2byte) juga cukup
        // untuk menyimpan titik kode unicode (unicode code-point).

        // int badInt = (int) true; // Compiler error: incompatible types
        char char1 = (char) 65; // A // membuat variabel bertipe char dan langsung diisi nilai
        System.out.println(char1);
        // hasil:
        // A

        // penjelasan:
        // awalnya membuat kelas yg di tulis public class
        // non_numeric_primitive_casting(){},
        // selanjutnya didalam kelas berisi main method yg ditulis public static void
        // main()throws Exception{},
        // selanjutnya masukan tipe data dan variabel char1 yang langsung diisi nilai
        // 65, dan ditulis char char1 = (char) 65;
        // selanjutnya tampilkan menggunakan System.out.println(char);
        // sehingga hasil menampilkan Unicode huruf A

        byte byte1 = (byte) 'A'; // 65
        System.out.println(byte1);
        // hasil:
        // 65

        short short1 = (short) 'A'; // 65
        System.out.println(short1);
        // hasil:
        // 65

        int int1 = (int) 'A'; // 65
        System.out.println(int1);
        // hasil:
        // 65

        char char2 = (char) 8253; // ‽
        System.out.println(char2);
        // hasil:
        // ‽

        byte byte2 = (byte) '‽'; // 61
        System.out.println(byte2);
        // hasil:

        short short2 = (short) '‽'; // 8253
        System.out.println(short2);
        // hasil:

        int int2 = (int) '?'; // 8253
        System.out.println(int2);
        // hasil:

    }
}
