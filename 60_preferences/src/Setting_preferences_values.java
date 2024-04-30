import java.util.prefs.Preferences;

public class Setting_preferences_values {
    // Setting preferences values/Menetapkan nilai preferensi

    /*
     * Untuk menyimpan nilai ke dalam node Preferensi, salah satu metode putXXX()
     * digunakan. Nilai dari node Preferensi
     * dapat bertipe String, boolean, byte[], double, float, int atau long
     */

    /*
     * Preferences preferences = Preferences.userNodeForPackage(getClass());
     * preferences.put("someKey", "some String value");
     * preferences.putBoolean("someKey", false);
     * preferences.putByteArray("someKey", new byte[0]);
     * preferences.putDouble("someKey", 187398123.4454d);
     * preferences.putFloat("someKey", 298321.445f);
     * preferences.putInt("someKey", 77637);
     * preferences.putLong("someKey", 2873984729834L);
     */

    public static void main(String[] args) {

        Preferences preferences = Preferences.userNodeForPackage(Setting_preferences_values.class);
        preferences.put("someKey", "some String value");
        preferences.putBoolean("someKey", false);
        preferences.putByteArray("someKey", new byte[0]);
        preferences.putDouble("someKey", 187398123.4454d);
        preferences.putFloat("someKey", 298321.445f);
        preferences.putInt("someKey", 77637);
        preferences.putLong("someKey", 2873984729834L);

        // Menampilkan nilai yang disimpan
        System.out.println("someKeyString: " + preferences.get("someKeyString", ""));
        System.out.println("someKeyBoolean: " + preferences.getBoolean("someKeyBoolean", true));
        System.out
                .println("someKeyByteArray: " + new String(preferences.getByteArray("someKeyByteArray", new byte[0])));
        System.out.println("someKeyDouble: " + preferences.getDouble("someKeyDouble", 0.0d));
        System.out.println("someKeyFloat: " + preferences.getFloat("someKeyFloat", 0.0f));
        System.out.println("someKeyInt: " + preferences.getInt("someKeyInt", 0));
        System.out.println("someKeyLong: " + preferences.getLong("someKeyLong", 0L));

        /*
         * output:
         * someKeyString:
         * someKeyBoolean: true
         * someKeyByteArray:
         * someKeyDouble: 0.0
         * someKeyFloat: 0.0
         * someKeyInt: 0
         * someKeyLong: 0
         */

    }
}
