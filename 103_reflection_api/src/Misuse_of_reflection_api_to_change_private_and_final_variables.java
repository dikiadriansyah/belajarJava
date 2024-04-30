import java.lang.reflect.*;

public class Misuse_of_reflection_api_to_change_private_and_final_variables {
    // Misuse of Reflection API to change private and final variables /
    // Penyalahgunaan API Refleksi untuk mengubah variabel pribadi dan final

    /*
     * Refleksi berguna bila digunakan dengan benar untuk tujuan yang benar. Dengan
     * menggunakan refleksi, Anda dapat mengakses private variabel
     * dan menginisialisasi ulang variabel akhir.
     */

    // Di bawah ini cuplikan kode yang tidak disarankan.
    /*
     * import java.lang.reflect.*;
     * public class ReflectionDemo{
     * public static void main(String args[]){
     * try{
     * Field[] fields = A.class.getDeclaredFields();
     * A a = new A();
     * for ( Field field:fields ) {
     * if(field.getName().equalsIgnoreCase("name")){
     * field.setAccessible(true);
     * field.set(a, "StackOverFlow");
     * System.out.println("A.name="+field.get(a));
     * }
     * if(field.getName().equalsIgnoreCase("age")){
     * field.set(a, 20);
     * System.out.println("A.age="+field.get(a));
     * }
     * if(field.getName().equalsIgnoreCase("rep")){
     * field.setAccessible(true);
     * field.set(a,"New Reputation");
     * System.out.println("A.rep="+field.get(a));
     * }
     * if(field.getName().equalsIgnoreCase("count")){
     * field.set(a,25);
     * System.out.println("A.count="+field.get(a));
     * }
     * }
     * }catch(Exception err){
     * err.printStackTrace();
     * }
     * }
     * }
     * class A {
     * private String name;
     * public int age;
     * public final String rep;
     * public static int count=0;
     * 
     * public A(){
     * name = "Unset";
     * age = 0;
     * rep = "Reputation";
     * count++;
     * }
     * }
     * 
     */

    // hasil:
    /*
     * A.name=StackOverFlow
     * A.age=20
     * A.rep=New Reputation
     * A.count=25
     */

    // Penjelasan:
    /*
     * Dalam skenario normal, variabel private tidak dapat diakses di luar kelas
     * yang dideklarasikan (tanpa metode getter dan setter ). variabel final tidak
     * dapat ditugaskan kembali setelah inisialisasi.
     * 
     * Pemecahan refleksi dari kedua hambatan tersebut dapat disalahgunakan untuk
     * mengubah variabel privat dan variabel final seperti dijelaskan di atas.
     * 
     * field.setAccessible(true) adalah kunci untuk mencapai fungsionalitas yang
     * diinginkan.
     */

    public static void main(String[] args) throws Exception {
        try {
            Field[] fields = Example.class.getDeclaredFields();
            Example a = new Example();
            for (Field field : fields) {
                if (field.getName().equalsIgnoreCase("name")) {
                    field.setAccessible(true);
                    field.set(a, "StackOverFlow");
                    System.out.println("A.name=" + field.get(a));
                }
                if (field.getName().equalsIgnoreCase("age")) {
                    field.set(a, 20);
                    System.out.println("A.age=" + field.get(a));
                }
                if (field.getName().equalsIgnoreCase("rep")) {
                    field.setAccessible(true);
                    field.set(a, "New Reputation");
                    System.out.println("A.rep=" + field.get(a));
                }
                if (field.getName().equalsIgnoreCase("count")) {
                    field.set(a, 25);
                    System.out.println("A.count=" + field.get(a));
                }
            }
        } catch (Exception err) {
            err.printStackTrace();
        }

        // Output:
        /*
         * A.name=StackOverFlow
         * A.age=20
         * A.rep=New Reputation
         * A.count=25
         */

    }
}
