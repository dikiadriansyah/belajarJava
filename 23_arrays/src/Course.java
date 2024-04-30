import java.util.Arrays;
import java.util.Comparator;

class Course implements Comparable<Course> {
    private int id;
    private String name;
    private int price;

    public Course(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter methods for id, name, and price

    @Override
    public int compareTo(Course otherCourse) {
        // Implement natural order sorting based on id
        return Integer.compare(this.id, otherCourse.id);
    }

    // Comparator for sorting by price
    static class PriceComparator implements Comparator<Course> {
        @Override
        public int compare(Course course1, Course course2) {
            return Integer.compare(course1.price, course2.price);
        }
    }

    // Comparator for sorting by name
    static class NameComparator implements Comparator<Course> {
        @Override
        public int compare(Course course1, Course course2) {
            return course1.name.compareTo(course2.name);
        }
    }

    @Override
    public String toString() {
        return "#" + id + " " + name + "@" + price;
    }
}