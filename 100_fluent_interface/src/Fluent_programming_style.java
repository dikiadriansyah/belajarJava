public class Fluent_programming_style {
    // Fluent programming style/Gaya pemrograman yang lancar

    /*
     * Dalam gaya pemrograman yang lancar, Anda mengembalikan this dari metode
     * (penyetel) yang lancar yang tidak akan menghasilkan apa pun dalam gaya
     * pemrograman yang tidak lancar.
     * 
     * Hal ini memungkinkan Anda untuk merangkai pemanggilan metode berbeda yang
     * membuat kode Anda lebih pendek dan lebih mudah ditangani oleh pengembang.
     * 
     * Pertimbangkan kode yang tidak lancar ini:
     * public class Person {
     * private String firstName;
     * private String lastName;
     * public String getFirstName() {
     * return firstName;
     * }
     * public void setFirstName(String firstName) {
     * this.firstName = firstName;
     * }
     * public String getLastName() {
     * return lastName;
     * }
     * public void setLastName(String lastName) {
     * this.lastName = lastName;
     * }
     * public String whoAreYou() {
     * return "I am " + firstName + " " + lastName;
     * }
     * public static void main(String[] args) {
     * Person person = new Person();
     * person.setFirstName("John");
     * person.setLastName("Doe");
     * System.out.println(person.whoAreYou());
     * }
     * }
     */

    /*
     * Karena metode penyetel tidak mengembalikan apa pun, kita memerlukan 4
     * instruksi dalam metode main untuk membuat instance Person dengan
     * beberapa data dan mencetaknya. Dengan gaya yang lancar kode ini dapat diubah
     * menjadi:
     * public class Person {
     * private String firstName;
     * private String lastName;
     * public String getFirstName() {
     * return firstName;
     * }
     * public Person withFirstName(String firstName) {
     * this.firstName = firstName;
     * return this;
     * }
     * public String getLastName() {
     * return lastName;
     * }
     * public Person withLastName(String lastName) {
     * this.lastName = lastName;
     * return this;
     * }
     * public String whoAreYou() {
     * return "I am " + firstName + " " + lastName;
     * }
     * public static void main(String[] args) {
     * System.out.println(new Person().withFirstName("John")
     * .withLastName("Doe").whoAreYou());
     * }
     * }
     * 
     * 
     */

    /*
     * Idenya adalah untuk selalu mengembalikan beberapa objek untuk memungkinkan
     * pembangunan rantai pemanggilan metode dan menggunakan nama metode yang mana
     * mencerminkan pembicaraan alami. Gaya lancar ini membuat kode lebih mudah
     * dibaca.
     */

    // -----------------

    // private String firstName;
    // private String lastName;

    // public String getFirstName() {
    // return firstName;
    // }

    // public void setFirstName(String firstName) {
    // this.firstName = firstName;
    // }

    // public String getLastName() {
    // return lastName;
    // }

    // public void setLastName(String lastName) {
    // this.lastName = lastName;
    // }

    // public String whoAreYou() {
    // return "I am " + firstName + " " + lastName;
    // }
    // ---------------------------------
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public Fluent_programming_style withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Fluent_programming_style withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String whoAreYou() {
        return "I am " + firstName + " " + lastName;
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------------------------
        // Fluent_programming_style box = new Fluent_programming_style();
        // box.setFirstName("Dhiki");
        // box.setLastName("Adriansyah");
        // System.out.println(box.whoAreYou());
        // output: I am Dhiki Adriansyah
        // -----------------
        System.out.println(new Fluent_programming_style().withFirstName("Dhiki")
                .withLastName("Adriansyah").whoAreYou());
        // output: I am Dhiki Adriansyah

    }
}
