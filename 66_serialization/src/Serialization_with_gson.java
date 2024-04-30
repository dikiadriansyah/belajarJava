import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
// import com.google.gson.Gson;

public class Serialization_with_gson {
    // Serialization with Gson/Serialisasi dengan Gson

    /*
     * Serialisasi dengan Gson mudah dan akan menghasilkan JSON yang benar.
     */

    /*
     * public class Employe {
     * private String firstName;
     * private String lastName;
     * private int age;
     * private BigDecimal salary;
     * private List<String> skills;
     * //getters and setters
     * }
     * (Serialization)
     * //Skills
     * List<String> skills = new LinkedList<String>();
     * skills.add("leadership");
     * skills.add("Java Experience");
     * 
     * //Employe
     * Employe obj = new Employe();
     * obj.setFirstName("Christian");
     * obj.setLastName("Lusardi");
     * obj.setAge(25);
     * obj.setSalary(new BigDecimal("10000"));
     * obj.setSkills(skills);
     * 
     * //Serialization process
     * Gson gson = new Gson();
     * String json = gson.toJson(obj);
     * //{"firstName":"Christian","lastName":"Lusardi","age":25,"salary":10000,
     * "skills":["leadership","Java
     * Experience"]}
     */

    // Perhatikan bahwa Anda tidak dapat membuat serial objek dengan referensi
    // melingkar karena hal itu akan menghasilkan rekursi tak terbatas.

    /*
     * (Deserialization)
     * //it's very simple...
     * //Assuming that json is the previous String object....
     * Employe obj2 = gson.fromJson(json, Employe.class); // obj2 is just like obj
     */

    public static void main(String[] args) {
        // Skills
        List<String> skills = new LinkedList<String>();
        skills.add("leadership");
        skills.add("Java Experience");

        // Employee
        Employe obj = new Employe();
        obj.setFirstName("Christian");
        obj.setLastName("Lusardi");
        obj.setAge(25);
        obj.setSalary(new BigDecimal("10000"));
        obj.setSkills(skills);
        System.out.println("Deserialized Object: " + obj.toString());
        /*
         * output:
         * Deserialized Object: Employe{firstName='Christian', lastName='Lusardi',
         * age=25, salary=10000, skills=[leadership, Java Experience]}
         */

        // Serialization process
        // Gson gson = new Gson();
        // String json = gson.toJson(obj);
        // System.out.println(json);

        // Deserialization process
        // Employe obj2 = gson.fromJson(json, Employe.class);

        // obj2 is just like obj
        // System.out.println("Deserialized Object: " + obj2.toString());

    }
}
