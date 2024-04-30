public class Json_to_object {
    // JSON To Object (Gson Library)/JSON Ke Objek (Perpustakaan Gson)

    // Anggaplah Anda memiliki kelas bernama Person hanya dengan name

    /*
     * private class Person {
     * public String name;
     * public Person(String name) {
     * this.name = name;
     * }
     * }
     */

    // kode

    /*
     * Gson gson = new Gson();
     * String json = "{\"name\": \"John\"}";
     * Person person = gson.fromJson(json, Person.class);
     * System.out.println(person.name); //John
     * 
     */

    // Anda harus memiliki gson library di classpath Anda

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        String json = "{\"name\": \"John\"}";
        Person person = gson.fromJson(json, Person.class);
        System.out.println(person.name); // John
    }
}
