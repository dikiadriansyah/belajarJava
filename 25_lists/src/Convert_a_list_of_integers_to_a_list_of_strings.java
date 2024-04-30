import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert_a_list_of_integers_to_a_list_of_strings {
    // Convert a list of integers to a list of strings

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<String> strings = nums.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println(strings); // [1,2,3]

        /*
         * Itu adalah:
         * 1. Buat aliran dari daftar
         * 2. Petakan setiap elemen menggunakan Object::toString
         * 3. Kumpulkan nilai String ke dalam List menggunakan Collectors.toList()
         */
    }
}
