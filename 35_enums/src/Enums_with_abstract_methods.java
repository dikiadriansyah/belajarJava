import java.util.*;

public class Enums_with_abstract_methods {
    // Enums with Abstract Methods / Enum dengan Metode Abstrak

    /*
     * Enum dapat menentukan metode abstrak, yang harus diterapkan oleh setiap
     * anggota enum.
     */

    // enum Action {
    // DODGE {
    // public boolean execute(Player player) {
    // return player.isAttacking();
    // }
    // },
    // ATTACK {
    // public boolean execute(Player player) {
    // return player.hasWeapon();
    // }
    // },
    // JUMP {
    // public boolean execute(Player player) {
    // return player.getCoordinates().equals(new Coordinates(0, 0));
    // }
    // };

    // public abstract boolean execute(Player player);
    // }

    /*
     * Hal ini memungkinkan setiap anggota enum untuk menentukan perilakunya sendiri
     * untuk operasi tertentu, tanpa harus mengaktifkan tipe dalam suatu metode
     * dalam definisi tingkat atas.
     * 
     * Perhatikan bahwa pola ini adalah bentuk singkat dari apa yang biasanya
     * dicapai dengan menggunakan polimorfisme dan/atau implementasi antarmuka
     */

    public static void main(String[] args) {

    }

}
