public class Encoding_data_as_json {
    // Encoding data as JSON/Mengkodekan data sebagai JSON

    /*
     * Jika Anda perlu membuat JSONObject dan memasukkan data ke dalamnya,
     * pertimbangkan contoh berikut:
     * 
     * // Create a new javax.json.JSONObject instance.
     * JSONObject first = new JSONObject();
     * first.put("foo", "bar");
     * first.put("temperature", 21.5);
     * first.put("year", 2016);
     * // Add a second object.
     * JSONObject second = new JSONObject();
     * second.put("Hello", "world");
     * first.put("message", second);
     * // Create a new JSONArray with some values
     * JSONArray someMonths = new JSONArray(new String[] { "January", "February" });
     * someMonths.put("March");
     * // Add another month as the fifth element, leaving the 4th element unset.
     * someMonths.put(4, "May");
     * // Add the array to our object
     * object.put("months", someMonths);
     * // Encode
     * String json = object.toString();
     * // An exercise for the reader: Add pretty-printing!
     * /* {
     * "foo":"bar",
     * "temperature":21.5,
     * "year":2016,
     * "message":{"Hello":"world"},
     * "months":["January","February","March",null,"May"]
     * }
     * 
     */

    public static void main(String[] args) throws Exception {
    }
}
