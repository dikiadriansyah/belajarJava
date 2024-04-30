import java.util.*;
// import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Using_jakson_object_mapper {
    // Using Jackson Object Mapper/Menggunakan Jackson Object Mapper

    // Pojo Model

    /*
     * public class Model {
     * private String firstName;
     * private String lastName;
     * private int age;
     * //Getters and setters not shown for brevity
     * 
     * }
     */

    // Contoh: String to Object

    /*
     * Model outputObject = objectMapper.readValue(
     * "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":23}",
     * Model.class);
     * System.out.println(outputObject.getFirstName());
     * //result: John
     */

    // contoh: object to string
    /*
     * String jsonString = objectMapper.writeValueAsString(inputObject));
     * //result: {"firstName":"John","lastName":"Doe","age":23}
     */

    // Detail
    // Pernyataan impor diperlukan:

    // import com.fasterxml.jackson.databind.ObjectMapper;

    // Maven Dependency: jackson-databind

    // ObjectMapper instance
    // creating one
    // ObjectMapper objectMapper = new ObjectMapper();

    /*
     * ObjectMapper is threadsafe
     * recommended: have a shared, static instance
     */

    // Deserialization:
    // <T> T readValue(String content, Class<T> valueType)
    /*
     * valueType perlu ditentukan -- pengembaliannya akan bertipe ini
     * Melempar
     * 1. IOException - jika terjadi masalah I/O tingkat rendah
     * 2. JsonParseException - jika masukan yang mendasarinya berisi konten yang
     * tidak
     * valid
     * 3. JsonMappingException - jika struktur input JSON tidak cocok dengan
     * struktur objek
     * 
     */

    // Contoh penggunaan (jsonString adalah string input):
    // Model fromJson = objectMapper.readValue(jsonString, Model.class);

    // Metode serialisasi:
    // String writeValueAsString(Object value)
    /*
     * throws
     * JsonProcessingException jika terjadi kesalahan
     * Catatan: sebelum versi 2.1, klausa lemparan menyertakan IOException; 2.1
     * menghapusnya
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        ObjectMapper objectMapper = new ObjectMapper();

        Model outputObject = objectMapper.readValue(
                "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":23}", Model.class);
        System.out.println(outputObject.getFirstName());
    }
}
