import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Using_lambda_expressions_and_predicate_to_get_a_certain_values_from_a_list {
    // Using lambda expressions & predicates to get a certain value(s) from a list /
    // Menggunakan ekspresi dan predikat lambda untuk mendapatkan nilai tertentu
    // dari daftar

    /*
     * Dimulai dengan Java 8, Anda dapat menggunakan ekspresi & predikat lambda.
     * 
     * Contoh: Gunakan ekspresi lambda & predikat untuk mendapatkan nilai tertentu
     * dari daftar. Dalam contoh ini setiap orang
     * akan dicetak dengan fakta apakah mereka berusia 18 tahun ke atas atau tidak.
     */

    // Person Class:
    /*
     * public class Person {
     * private String name;
     * private int age;
     * public Person(String name, int age) {
     * this.name = name;
     * this.age = age;
     * }
     * public int getAge() { return age; }
     * public String getName() { return name; }
     * }
     */

    /*
     * Antarmuka bawaan Predikat dari paket java.util.function.Predicate adalah
     * antarmuka fungsional dengan metode boolean test(T t).
     */

    // Contoh Penggunaan:
    /*
     * import java.util.ArrayList;
     * import java.util.List;
     * import java.util.function.Predicate;
     * public class LambdaExample {
     * public static void main(String[] args) {
     * List<Person> personList = new ArrayList<Person>();
     * personList.add(new Person("Jeroen", 20));
     * personList.add(new Person("Jack", 5));
     * personList.add(new Person("Lisa", 19));
     * print(personList, p -> p.getAge() >= 18);
     * }
     * private static void print(List<Person> personList, Predicate<Person> checker)
     * {
     * for (Person person : personList) {
     * if (checker.test(person)) {
     * System.out.print(person + " matches your expression.");
     * } else {
     * System.out.println(person + " doesn't match your expression.");
     * }
     * }
     * }
     * }
     */

    /*
     * print(personList, p -> p.getAge() >= 18); metode mengambil ekspresi lambda
     * (karena Predikat digunakan sebagai parameter) di mana Anda dapat menentukan
     * ekspresi yang diperlukan. Metode pengujian pemeriksa memeriksa apakah
     * ekspresi ini benar atau tidak: checker.test(person).
     */

    /*
     * Anda dapat dengan mudah mengubahnya ke sesuatu yang lain, misalnya ke
     * print(personList, p -> p.getName().startsWith("J"));. Ini akan memeriksa
     * apakah nama orang tersebut dimulai dengan huruf "J".
     */

    public static void main(String[] args) {
        List<Person6> personList = new ArrayList<Person6>();
        personList.add(new Person6("Jeroen", 20));
        personList.add(new Person6("Jack", 5));
        personList.add(new Person6("Lisa", 19));
        print(personList, p -> p.getAge() >= 18);
        /*
         * output:
         * Person6@7a46a697 matches your expression.Person6@6fdb1f78 doesn't match your
         * expression.
         * Person6@51016012 matches your expression.
         */
    }

    private static void print(List<Person6> personList, Predicate<Person6> checker) {
        for (Person6 person : personList) {
            if (checker.test(person)) {
                System.out.print(person + " matches your expression.");
            } else {
                System.out.println(person + " doesn't match your expression.");
            }
        }
    }

}
