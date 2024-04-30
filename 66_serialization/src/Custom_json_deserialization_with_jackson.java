// import com.fasterxml.jackson.databind.ObjectMapper;

public class Custom_json_deserialization_with_jackson {
    // Custom JSON Deserialization with Jackson/Deserialisasi JSON Kustom dengan
    // Jackson

    /*
     * Kami menggunakan API lainnya sebagai format JSON dan kemudian membatalkan
     * marshalnya ke POJO. milik Jackson
     * org.codehaus.jackson.map.ObjectMapper "hanya berfungsi" dan kami benar-benar
     * tidak melakukan apa pun dalam banyak kasus.
     * Namun terkadang kami memerlukan deserializer khusus untuk memenuhi kebutuhan
     * khusus kami dan tutorial ini akan memandu Anda melalui proses pembuatan
     * deserializer khusus Anda sendiri.
     */

    // Katakanlah kita memiliki entitas berikut.

    /*
     * public class User {
     * private Long id;
     * private String name;
     * private String email;
     * //getter setter are omitted for clarity
     * }
     * 
     * dan
     * 
     * public class Program {
     * private Long id;
     * private String name;
     * private User createdBy;
     * private String contents;
     * //getter setter are omitted for clarity
     * }
     * 
     */

    // Mari kita membuat serial/menyusun suatu objek terlebih dahulu.

    /*
     * User user = new User();
     * user.setId(1L);
     * user.setEmail("example@example.com");
     * user.setName("Bazlur Rahman");
     * Program program = new Program();
     * program.setId(1L);
     * program.setName("Program @# 1");
     * program.setCreatedBy(user);
     * program.setContents("Some contents");
     * ObjectMapper objectMapper = new ObjectMapper();
     * final String json = objectMapper.writeValueAsString(program);
     * System.out.println(json);
     */

    // Kode di atas akan menghasilkan JSON-

    /*
     * {
     * "id": 1,
     * "name": "Program @# 1",
     * "createdBy": {
     * "id": 1,
     * "name": "Bazlur Rahman",
     * "email": "example@example.com"
     * },
     * "contents": "Some contents"
     * }
     */

    /*
     * Sekarang dapat melakukan hal sebaliknya dengan sangat mudah. Jika kita
     * memiliki JSON ini, kita dapat melakukan unmarshal ke objek program
     * menggunakan ObjectMapper sebagai berikut –
     */

    /*
     * Sekarang katakanlah, ini bukan kasus sebenarnya, kita akan memiliki JSON yang
     * berbeda dari API yang tidak cocok dengan kelas Program kami.
     */

    /*
     * {
     * "id": 1,
     * "name": "Program @# 1",
     * "ownerId": 1
     * "contents": "Some contents"
     * }
     */

    /*
     * Lihatlah string JSON, Anda dapat melihat, ia memiliki bidang berbeda yaitu
     * owenerId.
     * 
     * Sekarang jika Anda ingin membuat serialisasi JSON ini seperti yang kami
     * lakukan sebelumnya, Anda akan memiliki pengecualian.
     * 
     * Ada dua cara untuk menghindari pengecualian dan menjadikannya serial –
     */

    // Abaikan bidang yang tidak diketahui

    // Abaikan onwerId. Tambahkan anotasi berikut di kelas Program

    /*
     * @JsonIgnoreProperties(ignoreUnknown = true)
     * public class Program {}
     * 
     */

    // Tulis deserializer khusus

    /*
     * Namun ada kalanya Anda benar-benar membutuhkan bidang owerId ini. Katakanlah
     * Anda ingin menghubungkannya sebagai id kelas Pengguna.
     * 
     * Dalam hal ini, Anda perlu menulis deserializer khusus
     */

    /*
     * Seperti yang Anda lihat, pertama-tama Anda harus mengakses JsonNode dari
     * JonsParser. Dan kemudian Anda dapat dengan mudah mengekstrak informasi dari
     * JsonNode menggunakan metode get(). dan Anda harus memastikan tentang nama
     * bidangnya. Itu harus nama yang tepat, kesalahan ejaan akan menyebabkan
     * pengecualian.
     */

    // Dan terakhir, Anda harus mendaftarkan ProgramDeserializer Anda ke
    // ObjectMapper.

    /*
     * ObjectMapper mapper = new ObjectMapper();
     * SimpleModule module = new SimpleModule();
     * module.addDeserializer(Program.class, new ProgramDeserializer());
     * mapper.registerModule(module);
     * String newJsonString =
     * "{\"id\":1,\"name\":\"Program @# 1\",\"ownerId\":1,\"contents\":\"Some
     * contents\"}";
     * final Program program2 = mapper.readValue(newJsonString, Program.class);
     */

    // Alternatifnya, Anda dapat menggunakan anotasi untuk mendaftarkan deserializer
    // secara langsung –

    /*
     * @JsonDeserialize(using = ProgramDeserializer.class)
     * public class Program {
     * }
     */

    public static void main(String[] args) {
        User user = new User(1L, "Bazlur Rahman", "example@example.com");

        Program program = new Program(1L, "Program @# 1", user, "Some contents");

        // ObjectMapper objectMapper = new ObjectMapper();
        // final String json = objectMapper.writeValueAsString(program);
        // System.out.println(json);
    }
}
