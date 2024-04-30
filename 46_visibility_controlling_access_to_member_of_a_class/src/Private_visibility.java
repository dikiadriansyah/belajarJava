import java.util.*;

public class Private_visibility {
    // Private Visibility / Visibilitas Pribadi
    /*
     * visibilitas pribadi memungkinkan suatu variabel hanya dapat diakses oleh
     * kelasnya. Mereka sering digunakan bersama dengan public
     * getter dan setter.
     */

    private int variable;

    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Private_visibility sc = new Private_visibility();

        // Pernyataan ini tidak dapat dikompilasi karena SomeClass#variable bersifat
        // pribadi:
        sc.variable = 7;
        System.out.println(sc.variable); // 7

        // Sebagai gantinya, Anda harus menggunakan pengambil dan penyetel publik:
        sc.setVariable(7);
        System.out.println(sc.getVariable()); // 7
    }
}
