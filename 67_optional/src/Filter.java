import java.util.Optional;

public class Filter {
    // Filter / Saring

    // filter() digunakan untuk menunjukkan bahwa Anda menginginkan suatu nilai
    // hanya jika nilai tersebut cocok dengan predikat Anda.

    // Anggap saja seperti if (!somePredicate(x)) { x = null; }.

    // Contoh kode:
    /*
     * String value = null;
     * Optional.ofNullable(value) // nothing
     * .filter(x -> x.equals("cool string"))// this is never run since value is null
     * .isPresent(); // false
     * 
     * String value = "cool string";
     * Optional.ofNullable(value) // something
     * .filter(x -> x.equals("cool string"))// this is run and passes
     * .isPresent(); // true
     * 
     * String value = "hot string";
     * Optional.ofNullable(value) // something
     * .filter(x -> x.equals("cool string"))// this is run and fails
     * .isPresent(); // false
     */

    public static void main(String[] args) {
        String value = "cool string";

        boolean isCoolString = Optional.ofNullable(value)
                .filter(x -> x.equals("cool string"))
                .isPresent();

        System.out.println("Is it a cool string? " + isCoolString); // output: Is it a cool string? true
    }
}
