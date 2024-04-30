public class Decoding_json_data {
    // Decoding JSON data/Mendekode data JSON

    // Jika Anda perlu mendapatkan data dari JSONObject, pertimbangkan contoh
    // berikut:

    public static void main(String[] args) throws Exception {
        String json = "{\"foo\":\"bar\",\"temperature\":21.5,\"year\":2016,\"message\":{\"Hello\":\"world\"},\"months\":[\"January\",\"February\",\"March\",null,\"May\"]}";

        // Decode the JSON-encoded string
        JSONObject object = new JSONObject(json);
        // Retrieve some values
        String foo = object.getString("foo");
        double temperature = object.getDouble("temperature");
        int year = object.getInt("year");
        // Retrieve another object
        JSONObject secondary = object.getJSONObject("message");
        String world = secondary.getString("Hello");
        // Retrieve an array
        JSONArray someMonths = object.getJSONArray("months");
        // Get some values from the array
        int nMonths = someMonths.length();
        String february = someMonths.getString(1);
    }
}
