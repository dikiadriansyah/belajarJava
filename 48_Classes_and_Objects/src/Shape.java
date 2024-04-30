import java.util.*;

// --------------------------------
// Method Overriding
// public abstract class Shape {
// public Double area() {
// return 0.0;
// }
// }

// --------------------------------
// Method Overloading
public class Shape {
    // It could be a circle or rectangle or square
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    // To calculate area of rectangle
    public Double area(Long length, Long breadth) {
        return (double) (length * breadth);
    }

    // To calculate area of a circle
    public Double area2(Long radius) {
        return (Double) 3.14 * radius * radius;
    }

}