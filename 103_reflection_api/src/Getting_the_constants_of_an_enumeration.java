import java.lang.reflect.*;

public class Getting_the_constants_of_an_enumeration {
    // Getting the Constants of an Enumeration/Mendapatkan Konstanta Pencacahan

    // Memberikan enumerasi ini sebagai Contoh:
    /*
     * enum Compass {
     * NORTH(0),
     * EAST(90),
     * SOUTH(180),
     * WEST(270);
     * private int degree;
     * Compass(int deg){
     * degree = deg;
     * }
     * public int getDegree(){
     * return degree;
     * }
     * }
     */

    /*
     * Di Java, kelas enum sama seperti kelas lainnya tetapi memiliki beberapa
     * konstanta yang ditentukan untuk nilai enum. Selain itu ia memiliki bidang
     * yaitu array yang menampung semua nilai dan dua metode statis dengan nama
     * value() dan valueOf(String).
     * Kita dapat melihat ini jika kita menggunakan Reflection untuk mencetak semua
     * field di kelas ini.
     * 
     * for(Field f : Compass.class.getDeclaredFields())
     * System.out.println(f.getName());
     */

    /*
     * hasil:
     * NORTH
     * EAST
     * SOUTH
     * WEST
     * degree
     * ENUM$VALUES
     */

    /*
     * Jadi kita bisa memeriksa kelas enum dengan Refleksi seperti kelas lainnya.
     * Namun Reflection API menawarkan tiga metode spesifik.
     */

    // enum check/pemeriksaan enum
    // Compass.class.isEnum();

    // Mengembalikan nilai true untuk kelas yang mewakili tipe enum

    // retrieving values/mengambil nilai
    // Object[] values = Compass.class.getEnumConstants();

    // Mengembalikan array semua nilai enum seperti Compass.values() tetapi tanpa
    // memerlukan sebuah instance.

    // enum constant check/pemeriksaan konstan enum

    /*
     * for(Field f : Compass.class.getDeclaredFields()){
     * if(f.isEnumConstant())
     * System.out.println(f.getName());
     * }
     */

    // Mencantumkan semua bidang kelas yang merupakan nilai enum.

    public static void main(String[] args) throws Exception {
        // for (Field f : Compass.class.getDeclaredFields())
        // System.out.println(f.getName());
        /*
         * output:
         * NORTH
         * EAST
         * SOUTH
         * WEST
         * degree
         * ENUM$VALUES
         */
        // ----------------
        for (Field f : Compass.class.getDeclaredFields()) {
            if (f.isEnumConstant())
                System.out.println(f.getName());
        }
        /*
         * output:
         * NORTH
         * EAST
         * SOUTH
         * WEST
         */
    }
}
