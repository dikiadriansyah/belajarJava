public class Week {

    static int daysOfTheWeek = 7; // static variable
    int dayOfTheWeek; // instance variable

    public static int getDaysLeftInWeek() {
        // Mengakses variabel statis secara langsung dari metode statis
        return daysOfTheWeek;
    }

    public int getDaysLeftInWeek2() {
        // Mengakses variabel instance dari objek
        return daysOfTheWeek - this.dayOfTheWeek;
    }

    public static int getDaysLeftInTheWeek(int today) {
        // Mengakses variabel statis dan parameter
        return daysOfTheWeek - today;
    }
}
