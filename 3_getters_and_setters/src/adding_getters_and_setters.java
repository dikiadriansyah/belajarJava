public class adding_getters_and_setters {

    // adding getters and setters / menambahkan getters dan setters
    public static void main(String[] args) {
        sample obj = new sample();
        obj.setName("Dhiki Adriansyah");
        obj.setAge(23);
        System.out.println(
                "Hai, Dunia! Perkenalkan nama saya adalah " + obj.getName() + ", umur saya adalah " + obj.getAge());
    }

    // hasil:
    // Hai, Dunia! Perkenalkan nama saya adalah Dhiki Adriansyah, umur saya adalah
    // 23

    // penjelasan:
    // awalnya membuat 2 file yaitu: adding_getters_and_setters.java, dan
    // sample.java,
    // selanjuta file sample.java berisi private String name;
    // private int age; public int getAge() {..} public void setAge(int age) {..}
    // public String getName() {..} public void setName(String name) {..}
    // selanjutnya file adding_getter_and_setters berisi public static void
    // main(){...} yang berisi variabel bernama obj dengan nilai keyword new
    // sample(),
    // serta berisi obj yang dikolaborasi metode .setName("") dan .setAge(),
    // selanjutnya tampilkan menggunakan System.out.println("")

}
