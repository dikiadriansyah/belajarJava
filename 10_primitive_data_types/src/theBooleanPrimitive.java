public class theBooleanPrimitive {
    public static void main(String[] args) {
        // Boolean dapat menyimpan salah satu dari dua nilai, benar atau salah
        boolean bil = true;
        // System.out.println("Bilangan = " + bil); // Bilangan = true

        boolean bil2 = false;
        // System.out.println("Bilangan = " + bil2); // Bilangan = false

        boolean notBil = !bil;
        // System.out.println("Bilangan = " + notBil); // Bilangan = false

        boolean bil2Andbil = bil2 && bil;
        // System.out.println("Bilangan = " + bil2Danbil); // Bilangan = false

        boolean bil2Orbil = bil2 || bil;
        // System.out.println("Bilangan = " + bil2Orbil); // Bilangan = true

        boolean bil2Xorbil = bil2 ^ bil;
        System.out.println("Bilangan = " + bil2Xorbil); // Bilangan = true

        // Nilai default boolean adalah false
        boolean defaultBoolean; // defaultBoolean == false

    }
}
