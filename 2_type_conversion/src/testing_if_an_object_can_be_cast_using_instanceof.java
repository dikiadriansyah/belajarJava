import java.util.*;

public class testing_if_an_object_can_be_cast_using_instanceof {

    public static void main(String[] args) throws Exception { // main method

        // Testing if an object can be cast using instanceof / Menguji apakah suatu
        // objek dapat dilemparkan menggunakan instanceof

        // java menyediakan operator instanceof untuk menguji apakah suatu objek bertipe
        // tertentu, atau subclass dari tipe itu.
        // program kemudian dapat memilih untuk mentransmisikan atau tidak
        // mentransmisikan objek yang sesuai
        Object obj = Calendar.getInstance();

        long time = 0;
        if (obj instanceof Calendar) {
            time = ((Calendar) obj).getTime();
        }
        // if (obj instanceof Date) {
        // time = ((Date) obj).getTime(); // This line will never be reached, obj is not
        // a Date type / Baris ini tidak
        // // akan pernah tercapai, obj bukan tipe Tanggal.
        // }

        System.out.println("Hasil :" + obj);
    }

}
