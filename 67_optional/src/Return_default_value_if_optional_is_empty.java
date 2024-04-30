import java.util.Optional;

public class Return_default_value_if_optional_is_empty {
    // Return default value if Optional is empty/Kembalikan nilai default jika
    // Opsional kosong

    /*
     * Jangan hanya menggunakan Optional.get() karena hal itu dapat memunculkan
     * NoSuchElementException. Opsional.orElse(T) dan
     * Metode Optional.orElseGet(Supplier<? extends T>) menyediakan cara untuk
     * memberikan nilai default jika Opsional kosong.
     */

    /*
     * String value = "something";
     * return Optional.ofNullable(value).orElse("defaultValue");
     * // returns "something"
     * return Optional.ofNullable(value).orElseGet(() -> getDefaultValue());
     * // returns "something" (never calls the getDefaultValue() method)
     * String value = null;
     * return Optional.ofNullable(value).orElse("defaultValue");
     * // returns "defaultValue"
     * return Optional.ofNullable(value).orElseGet(() -> getDefaultValue());
     * // calls getDefaultValue() and returns its results
     */

    /*
     * Perbedaan penting antara orElse dan orElseGet adalah bahwa orElseGet hanya
     * dievaluasi ketika Opsionalnya kosong sedangkan argumen yang diberikan ke
     * orElseGet dievaluasi bahkan jika Opsionalnya tidak kosong. Oleh karena itu
     * orElse hanya boleh digunakan untuk konstanta dan tidak pernah untuk
     * memberikan nilai berdasarkan perhitungan apa pun.
     */

    public static void main(String[] args) {
        String value = "something";
        String result = getValueOrDefault(value, "defaultValue");
        System.out.println(result); // Output: something

    }

    private static String getValueOrDefault(String value, String defaultValue) {
        return Optional.ofNullable(value).orElse(defaultValue);
    }

}
