public class Pitfall_overloading_instead_of_overriding {
    // Pitfall - Overloading instead of overriding/Kesalahan - Membebani secara
    // berlebihan, bukannya mengesampingkan

    /*
     * Perhatikan contoh berikut:
     * 
     * public final class Person {
     * private final String firstName;
     * private final String lastName;
     * 
     * public Person(String firstName, String lastName) {
     * this.firstName = (firstName == null) ? "" : firstName;
     * this.lastName = (lastName == null) ? "" : lastName;
     * }
     * public boolean equals(String other) {
     * if (!(other instanceof Person)) {
     * return false;
     * }
     * Person p = (Person) other;
     * return firstName.equals(p.firstName) &&
     * lastName.equals(p.lastName);
     * }
     * public int hashcode() {
     * return firstName.hashCode() + 31 * lastName.hashCode();
     * }
     * }
     */

    /*
     * Kode ini tidak akan berfungsi seperti yang diharapkan. Masalahnya adalah
     * metode sama dengan dan kode hash untuk Person tidak mengesampingkan metode
     * standar yang ditentukan oleh Object.
     * 1. Metode equals memiliki tanda tangan yang salah. Itu harus
     * dideklarasikan sebagai equals(Object) bukan equals(String).
     * 2. Metode hashcode memiliki nama yang salah. Seharusnya hashCode()
     * (perhatikan huruf kapital C).
     * 
     * Kesalahan ini berarti bahwa kami telah menyatakan kelebihan beban yang tidak
     * disengaja, dan ini tidak akan digunakan jika Person digunakan dalam konteks
     * polimorfik.
     * 
     * Namun, ada cara sederhana untuk mengatasi hal ini (mulai Java 5 dan
     * seterusnya). Gunakan anotasi @Override setiap kali Anda ingin metode Anda
     * diganti:
     * Version ≥ Java SE 5
     * public final class Person {
     * ...
     * 
     * @Override
     * public boolean equals(String other) {
     * ....
     * }
     * 
     * @Override
     * public hashcode() {
     * ....
     * }
     * }
     */

    /*
     * Saat kita menambahkan anotasi @Override ke deklarasi metode, kompilator akan
     * memeriksa apakah metode tersebut mengesampingkan (atau mengimplementasikan)
     * metode yang dideklarasikan dalam superkelas atau antarmuka. Jadi pada contoh
     * di atas, kompiler akan memberi kita dua kesalahan kompilasi, yang seharusnya
     * cukup untuk mengingatkan kita akan kesalahan tersebut.
     */

    public static void main(String[] args) throws Exception {
        Person11 box1 = new Person11("Dhiki", "Adr");
        Person11 box2 = new Person11("Dhiki", "Adr");
        System.out.println("box1.equals(person2): " + box1.equals(box2));
        /*
         * output:
         * box1.equals(person2): true
         */
        System.out.println("box1.hashCode(): " + box1.hashCode());
        /*
         * output:
         * box1.hashCode(): 68038068
         */
        System.out.println("box2.hashCode(): " + box2.hashCode());
        /*
         * output:
         * box2.hashCode(): 68038068
         */
    }
}
