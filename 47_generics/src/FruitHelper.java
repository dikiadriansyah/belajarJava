import java.util.*;

class Shoe {
    private String brand;

    public Shoe(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

class IPhone {
    private String model;

    public IPhone(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

interface Fruit {
    void display();
}

class Apple implements Fruit {
    @Override
    public void display() {
        System.out.println("This is an Apple.");
    }

    @Override
    public String toString() {
        return "Apple";
    }

}

class Banana implements Fruit {
    @Override
    public void display() {
        System.out.println("This is a Banana.");
    }

    @Override
    public String toString() {
        return "Banana";
    }

}

class GrannySmith extends Apple {
    public void display() {
        System.out.println("This is a Granny Smith Apple.");
    }
}

public class FruitHelper {
    public void eatAll(Collection<? extends Fruit> fruits) {
        for (Fruit fruit : fruits) {
            System.out.println("Eating: " + fruit);
        }
    }

    public void addApple(Collection<? super Apple> apples) {
        apples.add(new Apple());
        System.out.println("Added an Apple");
    }
}
