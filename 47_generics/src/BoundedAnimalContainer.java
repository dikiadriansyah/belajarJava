import java.util.*;

public class BoundedAnimalContainer<T extends Animal> {
    private Collection<T> col;

    public BoundedAnimalContainer() {
        col = new ArrayList<T>();
    }

    public void add(T t) {
        col.add(t);
    }

    public void printAllSounds() {
        for (T t : col) {
            // Now works because T is extending Animal
            // System.out.println(t.makeSound());

            // Berubah dari makeSound() menjadi getSound()
            // karena metode ini didefinisikan sebagai getSound() di kelas Hewan
            System.out.println(t.getSound());

        }
    }

}
