import java.util.prefs.Preferences;

public class Getting_preferences_values {
    // Getting preferences values /Mendapatkan nilai preferensi

    /*
     * Nilai dari node Preferensi dapat bertipe String, boolean, byte[], double,
     * float, int atau long. Semua
     * pemanggilan harus memberikan nilai default, jika nilai yang ditentukan tidak
     * ada di node Preferensi.
     */

    public static void main(String[] args) {
        Preferences preferences = Preferences.userNodeForPackage(Getting_preferences_values.class);

        String someString = preferences.get("someKey", "this is the default value");
        System.out.println("String Value: " + someString);
        /*
         * output:
         * String Value: this is the default value
         */

        boolean someBoolean = preferences.getBoolean("someKey", true);
        byte[] someByteArray = preferences.getByteArray("someKey", new byte[0]);
        double someDouble = preferences.getDouble("someKey", 887284.4d);
        float someFloat = preferences.getFloat("someKey", 38723.3f);
        int someInt = preferences.getInt("someKey", 13232);
        long someLong = preferences.getLong("someKey", 2827637868234L);
    }
}
