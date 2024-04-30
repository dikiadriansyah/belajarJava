import java.util.*;

public class Get_enum_constant_by_name {
    // Get enum constant by name / Dapatkan konstanta enum berdasarkan nama

    // Katakanlah kita memiliki enum DayOfWeek:
    enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    /*
     * Enum dikompilasi dengan metode valueOf() statis bawaan yang dapat digunakan
     * untuk mencari konstanta berdasarkan namanya:
     */

    public static void main(String[] args) {
        // String dayName = DayOfWeek.SUNDAY.name();
        // assert dayName.equals("SUNDAY");

        // DayOfWeek day = DayOfWeek.valueOf(dayName);
        // assert day == DayOfWeek.SUNDAY;

        // System.out.println("dayName: " + dayName); // dayName: SUNDAY
        // System.out.println("day: " + day); // day: SUNDAY

        // -------------------------

        // Ini juga dimungkinkan menggunakan tipe enum dinamis:
        // Class<DayOfWeek> enumType = DayOfWeek.class;
        // DayOfWeek day = Enum.valueOf(enumType, "SUNDAY");
        // assert day == DayOfWeek.SUNDAY;
        // System.out.println("day: " + day); // day: SUNDAY

        // ----------------------------------
        /*
         * Kedua metode valueOf() ini akan memunculkan IllegalArgumentException jika
         * enum yang ditentukan tidak memiliki konstanta dengan nama yang cocok.
         * 
         * Pustaka Guava menyediakan metode pembantu Enums.getIfPresent() yang
         * mengembalikan Opsional Guava untuk menghilangkan penanganan pengecualian
         * eksplisit:
         */
        // DayOfWeek defaultDay = DayOfWeek.SUNDAY;
        // DayOfWeek day = Enums.valueOf(DayOfWeek.class, "INVALID").or(defaultDay);
        // assert day == DayOfWeek.SUNDAY;
    }

}
