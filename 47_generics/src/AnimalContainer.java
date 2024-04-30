import java.util.*;

public class AnimalContainer<T> {
    private Collection<T> col;

    public AnimalContainer() {
        col = new ArrayList<T>();
    }

    public void add(T t) {
        col.add(t);
    }

    public void printAllSounds() {
        for (T t : col) {
            // Illegal, type T doesn't have makeSound()
            // it is used as an java.lang.Object here
            // System.out.println(t.makeSound());

            // Berubah dari makeSound() menjadi getSound()
            // karena metode ini didefinisikan sebagai getSound() di kelas Animal
            System.out.println(((Animal) t).getSound());

        }
    }

}
