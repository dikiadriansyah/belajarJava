public class using_a_setter_or_getter_to_implement_a_constraint {

    public static void main(String[] args) {

        // Getters and Setters

        // Using a setter or getter to implement a constraint / Menggunakan setter
        // atau
        // pengambil untuk mengimplementasikan batasan

        // setter dan getter memungkinkan objek berisi variabel pribadi yang dapat
        // diakses dan diubah dengan batasan. contohnya:

        person obj = new person();
        obj.setName("Dhiki Adriansyah");

        System.out.println("Hello, World!" + obj.getName());

        // hasil:
        // Hello, World! Dhiki Adriansyah

        // penjelasan:
        // awalnya membuat 2 file java yaitu : person.java dan
        // using_a_setter_or_getter_to_implement_a_constraint.java
        // selanjutnya pada file person.java berisi private String name; public String
        // getName() {...}; public void setName(String name) {...}; arti private String
        // untuk sebagai atribut pribadi. selanjutnya public String getName(){} public
        // void setName() sebagai metode.
        // selanjutnya file using_a_setter_or_getter_to_implement_a_constraint.java
        // berisi public static void main(){} yang berisi person obj = new person();
        // obj.setName("Diki");
        // selanjutnya tampilkan menggunakan System.out.println("" + obj.getName());
        // public static void main() artinya untuk menandakan metode utama. person obj =
        // new person() artinya membuat variabel bernama obj yang berisi nilai baru
        // objek person(); obj.setName("") artinya fungsi untuk mengatur nilai yang akan
        // dimasukkan dan dikolaborasi variabel obj.

    }

}
