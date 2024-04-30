import java.util.*;

public class Enum_as_a_bound_type_parameter<T extends Enum<T>> {
    // Enum as a bounded type parameter / Enum sebagai parameter tipe terbatas

    /*
     * Saat menulis kelas dengan obat generik di java, dimungkinkan untuk memastikan
     * bahwa parameter tipe adalah enum. Karena semua enum memperluas kelas Enum,
     * sintaks berikut dapat digunakan.
     */
    public final T value;

    public Enum_as_a_bound_type_parameter(T init) {
        this.value = init;
    }

    // Dalam contoh ini, tipe T harus berupa enum

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        Enum_as_a_bound_type_parameter<Day> dayHolder = new Enum_as_a_bound_type_parameter<>(Day.MONDAY);

        System.out.println("Nilai dari Holder: " + dayHolder.value); // Nilai dari Holder: MONDAY
    }

}
