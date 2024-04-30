public class Extract_single_element_from_json {
    // Extract single element from JSON/Ekstrak elemen tunggal dari JSON

    /*
     * String json = "{\"name\": \"John\", \"age\":21}";
     * JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
     * System.out.println(jsonObject.get("name").getAsString()); //John
     * System.out.println(jsonObject.get("age").getAsInt()); //21
     */

    public static void main(String[] args) throws Exception {
        String json = "{\"name\": \"John\", \"age\":21}";
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        System.out.println(jsonObject.get("name").getAsString()); // John
        System.out.println(jsonObject.get("age").getAsInt()); // 21

    }
}
