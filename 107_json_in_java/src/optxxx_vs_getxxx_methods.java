public class optxxx_vs_getxxx_methods {
    // optXXX vs getXXX methods

    /*
     * JSONObject dan JSONArray memiliki beberapa metode yang sangat berguna saat
     * menghadapi kemungkinan nilai yang Anda coba dapatkan tidak ada atau bertipe
     * lain.
     */

    /*
     * JSONObject obj = new JSONObject();
     * obj.putString("foo", "bar");
     * // For existing properties of the correct type, there is no difference
     * obj.getString("foo"); // returns "bar"
     * obj.optString("foo"); // returns "bar"
     * obj.optString("foo", "tux"); // returns "bar"
     * // However, if a value cannot be coerced to the required type, the behavior
     * differs
     * obj.getInt("foo"); // throws JSONException
     * obj.optInt("foo"); // returns 0
     * obj.optInt("foo", 123); // returns 123
     * // Same if a property does not exist
     * obj.getString("undefined"); // throws JSONException
     * obj.optString("undefined"); // returns ""
     * obj.optString("undefined", "tux"); // returns "tux"
     * 
     */

    // Aturan yang sama berlaku untuk metode getXXX / optXXX di JSONArray.

    public static void main(String[] args) throws Exception {

    }
}
