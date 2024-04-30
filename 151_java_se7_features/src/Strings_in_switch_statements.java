public class Strings_in_switch_statements {
    // Strings in switch Statements/String dalam pernyataan saklar

    /*
     * public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
     * String typeOfDay;
     * switch (dayOfWeekArg) {
     * case "Monday":
     * typeOfDay = "Start of work week";
     * break;
     * case "Tuesday":
     * case "Wednesday":
     * case "Thursday":
     * typeOfDay = "Midweek";
     * break;
     * case "Friday":
     * typeOfDay = "End of work week";
     * break;
     * case "Saturday":
     * case "Sunday":
     * typeOfDay = "Weekend";
     * break;
     * default:
     * throw new IllegalArgumentException("Invalid day of the week: " +
     * dayOfWeekArg);
     * }
     * return typeOfDay;
     * }
     */

    public static void main(String[] args) throws Exception {
        Strings_in_switch_statements box = new Strings_in_switch_statements();

        System.out.println(box.getTypeOfDayWithSwitchStatement("Monday")); // Start of work week
        System.out.println(box.getTypeOfDayWithSwitchStatement("Wednesday")); // Midweek
        System.out.println(box.getTypeOfDayWithSwitchStatement("Friday")); // End of work week
        System.out.println(box.getTypeOfDayWithSwitchStatement("Sunday")); // Weekend

    }

    public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }

}
