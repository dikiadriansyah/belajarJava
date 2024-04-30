import java.util.*;

public class Declaring_an_arraylist_and_adding_objects {
    // Declaring an ArrayList and adding objects
    /*
     * Kita dapat membuat ArrayList (mengikuti List interface):
     */
    public static void main(String[] args) {
        List aListOfFruits = new ArrayList();

        // Version ≥ Java SE 5
        List<String> aListOfFruits2 = new ArrayList<String>();

        // Version ≥ Java SE 7
        List<String> aListOfFruits3 = new ArrayList<>();

        /*
         * Sekarang, gunakan metode add untuk menambahkan String:
         */

        aListOfFruits.add("Melon");
        aListOfFruits.add("Strawberry");
        /*
         * Pada contoh di atas, ArrayList akan berisi String "Melon" pada indeks 0 dan
         * String "Strawberry" pada indeks 1.
         * 
         * Kita juga dapat menambahkan beberapa elemen dengan metode addAll(Collection<?
         * extends E> c).
         */
        // System.out.println(aListOfFruits); // [Melon, Strawberry]

        List<String> aListOfFruitsAndVeggies = new ArrayList<String>();
        aListOfFruitsAndVeggies.add("Onion");
        aListOfFruitsAndVeggies.addAll(aListOfFruits);
        System.out.println(aListOfFruitsAndVeggies); // [Onion, Melon, Strawberry]
        /*
         * Sekarang "Onion" ditempatkan pada indeks 0 di aListOfFruitsAndVeggies,
         * "Melon" di indeks 1 dan "Strawberry" di indeks 2
         */

    }
}
