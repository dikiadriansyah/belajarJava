public class Jsonarray_to_javalist {
    // JsonArray to Java List (Gson Library)/JsonArray ke Daftar Java (Perpustakaan
    // Gson)

    /*
     * {
     * "list": [
     * "Test_String_1",
     * "Test_String_2"
     * ]
     * }
     */

    // Sekarang teruskan 'list' JsonArray ke metode berikut yang mengembalikan
    // Java ArrayList yang sesuai:

    /*
     * public ArrayList<String> getListString(String jsonList){
     * Type listType = new TypeToken<List<String>>() {}.getType();
     * //make sure the name 'list' matches the name of 'JsonArray' in your 'Json'.
     * ArrayList<String> list = new Gson().fromJson(jsonList, listType);
     * return list;
     * }
     * 
     */

    // Anda harus menambahkan ketergantungan maven berikut ke file POM.xml Anda:
    /*
     * <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
     * <dependency>
     * <groupId>com.google.code.gson</groupId>
     * <artifactId>gson</artifactId>
     * <version>2.7</version>
     * </dependency>
     */

    // Atau Anda harus memiliki toples com.google.code.gson:gson:jar:<version> di
    // classpath Anda.

    public static void main(String[] args) throws Exception {
    }
}
