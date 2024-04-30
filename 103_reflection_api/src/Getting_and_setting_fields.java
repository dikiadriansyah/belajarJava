import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Getting_and_setting_fields {
    // Getting and Setting fields/Mendapatkan dan Mengatur bidang

    /*
     * Dengan menggunakan Reflection API, dimungkinkan untuk mengubah atau
     * mendapatkan nilai suatu bidang saat runtime. Misalnya, Anda dapat
     * menggunakannya di API untuk mengambil bidang berbeda berdasarkan suatu
     * faktor, seperti OS. Anda juga dapat menghapus pengubah seperti final untuk
     * mengizinkan pengubahan bidang yang bersifat final.
     */

    // Untuk melakukannya, Anda perlu menggunakan metode Class#getField() dengan
    // cara seperti yang ditunjukkan di bawah ini:

    /*
     * // Get the field in class SomeClass "NAME".
     * Field nameField = SomeClass.class.getDeclaredField("NAME");
     * // Get the field in class Field "modifiers". Note that it does not
     * // need to be static
     * Field modifiersField = Field.class.getDeclaredField("modifiers");
     * // Allow access from anyone even if it's declared private
     * modifiersField.setAccessible(true);
     * // Get the modifiers on the "NAME" field as an int.
     * int existingModifiersOnNameField = nameField.getModifiers();
     * // Bitwise AND NOT Modifier.FINAL (16) on the existing modifiers
     * // Readup here https://en.wikipedia.org/wiki/Bitwise_operations_in_C
     * // if you're unsure what bitwise operations are.
     * int newModifiersOnNameField = existingModifiersOnNameField & ~Modifier.FINAL;
     * // Set the value of the modifiers field under an object for non-static fields
     * modifiersField.setInt(nameField, newModifiersOnNameField);
     * // Set it to be accessible. This overrides normal Java
     * // private/protected/package/etc access control checks.
     * nameField.setAccessible(true);
     * // Set the value of "NAME" here. Note the null argument.
     * // Pass null when modifying static fields, as there is no instance object
     * nameField.set(null, "Hacked by reflection...");
     * // Here I can directly access it. If needed, use reflection to get it.
     * (Below)
     * System.out.println(SomeClass.NAME);
     */

    // Mendapatkan ladang jauh lebih mudah. Kita dapat menggunakan Field#get() dan
    // variannya untuk mendapatkan nilainya:

    /*
     * // Get the field in class SomeClass "NAME".
     * Field nameField = SomeClass.class.getDeclaredField("NAME");
     * // Set accessible for private fields
     * nameField.setAccessible(true);
     * // Pass null as there is no instance, remember?
     * String name = (String) nameField.get(null);
     */

    // Perhatikan ini:
    /*
     * Saat menggunakan Class#getDeclaredField, gunakan untuk mendapatkan bidang di
     * kelas itu sendiri:
     * class HackMe extends Hacked {
     * public String iAmDeclared;
     * }
     * class Hacked {
     * public String someState;
     * }
     * 
     */

    /*
     * Di sini, HackMe#iAmDeclared dinyatakan sebagai bidang. Namun,
     * HackMe#someState bukanlah bidang yang dideklarasikan karena merupakan warisan
     * dari superkelasnya, Hacked.
     */

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Get the field in class SomeClass "NAME".
        // Field nameField = SomeClass2.class.getDeclaredField("NAME");
        // Get the field in class Field "modifiers". Note that it does not
        // need to be static
        // Field modifiersField = Field.class.getDeclaredField("modifiers");
        // Allow access from anyone even if it's declared private
        // modifiersField.setAccessible(true);
        // Get the modifiers on the "NAME" field as an int.
        // int existingModifiersOnNameField = nameField.getModifiers();
        // Bitwise AND NOT Modifier.FINAL (16) on the existing modifiers
        // Readup here https://en.wikipedia.org/wiki/Bitwise_operations_in_C
        // if you're unsure what bitwise operations are.
        // int newModifiersOnNameField = existingModifiersOnNameField & ~Modifier.FINAL;
        // Set the value of the modifiers field under an object for non-static fields
        // modifiersField.setInt(nameField, newModifiersOnNameField);
        // Set it to be accessible. This overrides normal Java
        // private/protected/package/etc access control checks.
        // nameField.setAccessible(true);
        // Set the value of "NAME" here. Note the null argument.
        // Pass null when modifying static fields, as there is no instance object
        // nameField.set(null, "Hacked by reflection...");
        // Here I can directly access it. If needed, use reflection to get it. (Below)
        // System.out.println(SomeClass2.NAME);
        // hasil:
        // Original Value

        // --------------------------------
        // Get the field in class SomeClass "NAME".
        // Field nameField = SomeClass3.class.getDeclaredField("NAME");
        // Set accessible for private fields
        // nameField.setAccessible(true);
        // Pass null as there is no instance, remember?
        // String name = (String) nameField.get(null);
        // System.out.println("Name: " + name);
        // output: Name: John Doe
        // -------------------------------
        HackMe hackMe = new HackMe();
        hackMe.someState = "This is some state.";
        hackMe.iAmDeclared = "I am declared.";

        System.out.println("someState: " + hackMe.someState);
        /*
         * output
         * someState: This is some state.
         * 
         */
        System.out.println("iAmDeclared: " + hackMe.iAmDeclared);
        // output: iAmDeclared: I am declared.
    }
}
