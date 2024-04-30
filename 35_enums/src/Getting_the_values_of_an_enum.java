public class Getting_the_values_of_an_enum {
    // Getting the values of an enum / Mendapatkan nilai enum

    /*
     * Setiap kelas enum berisi metode statis implisit bernama value(). Metode ini
     * mengembalikan array yang berisi semua nilai enum tersebut. Anda dapat
     * menggunakan metode ini untuk mengulangi nilainya. Namun penting untuk dicatat
     * bahwa metode ini mengembalikan array baru setiap kali dipanggil.
     */

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        /**
         * Print out all the values in this enum.
         */
        public static void printAllDays() {
            for (Day day : Day.values()) {
                System.out.println(day.name());
            }
        }
    }

    // Jika Anda membutuhkan Set, Anda dapat menggunakan EnumSet.allOf(Day.class)
    // juga.

    public static void main(String[] args) {
        // Memanggil metode printAllDays() dari enum Day
        Day.printAllDays();
        /*
         * output:
         * MONDAY
         * TUESDAY
         * WEDNESDAY
         * THURSDAY
         * FRIDAY
         * SATURDAY
         * SUNDAY
         */
    }
}
