public class basic_numeric_promotion { // bagian class
    public static void main(String[] args) throws Exception { // main method

        // Basic Numeric Promotion / promosi numerik dasar

        // format pembuatan variabel dibawah:
        // <tipe data> namaVariabel;
        char char1 = 1, char2 = 2; // membuat variabel bertipe byte dan langsung diisi
        // short short1 = 1, short2 = 2;
        int int1 = 1, int2 = 2;
        // float float1 = 1.0f, float2 = 2.0f;

        // char1 = char1 + char2; // Error: Cannot convert from int to char; /
        // Kesalahan: Tidak dapat mengonversi dari int ke char;

        // short1 = short1 + short2; // Error: Cannot convert from int to short;
        int1 = char1 + char2; // char is promoted to int.
        // int1 = short1 + short2; // short is promoted to int.
        // int1 = char1 + short2; // both char and short promoted to int.
        // float1 = short1 + float2; // short is promoted to float.
        // int1 = int1 + int2; // int is unchanged.
        System.out.println("Bagian Basic Numeric Promotion!" + int1);
        // hasil:
        // Bagian Basic Numeric promotion 3

        // penjelasan:
        // awalnya membuat kelas yg di tulis public class basic_numeric_promotion(){},
        // selanjutnya didalam kelas berisi main method yg ditulis public static void
        // main(){},
        // selanjutnya di dalam main method berisi tipe data char,short, int, float,
        // selanjutnya variabel int1 berisi penjumlahan yang ditulis char1+char2,
        // selanjutnya tampilkan menggunakan System.out.println("")
    }
}