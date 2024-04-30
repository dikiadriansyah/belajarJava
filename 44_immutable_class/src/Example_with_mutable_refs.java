public final class Example_with_mutable_refs {
    // Example with mutable refs / Contoh dengan referensi yang bisa berubah

    // Dalam hal ini kelas Point dapat diubah dan beberapa pengguna dapat mengubah
    // keadaan objek kelas ini.

    /*
     * class Point {
     * private int x, y;
     * public Point(int x, int y) {
     * this.x = x;
     * this.y = y;
     * }
     * public int getX() {
     * return x;
     * }
     * 
     * public void setX(int x) {
     * this.x = x;
     * }
     * 
     * public int getY() {
     * return y;
     * }
     * public void setY(int y) {
     * this.y = y;
     * }
     * }
     * 
     * //...
     * 
     * public final class ImmutableCircle {
     * private final Point center;
     * private final double radius;
     * public ImmutableCircle(Point center, double radius) {
     * // we create new object here because it shouldn't be changed
     * this.center = new Point(center.getX(), center.getY());
     * this.radius = radius;
     * }
     */

    private final Point center;
    private final double radius;

    public Example_with_mutable_refs(Point center, double radius) {
        // we create a new object here because it shouldn't be changed
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    public Point getCenter() {
        // Returning a copy to maintain immutability
        return new Point(center.getX(), center.getY());
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        Point center = new Point(1, 2);
        Example_with_mutable_refs circle = new Example_with_mutable_refs(center, 3.0);

        // Displaying the original values
        System.out.println("Original Center: (" + circle.getCenter().getX() + ", " + circle.getCenter().getY() + ")");
        System.out.println("Original Radius: " + circle.getRadius());

        /*
         * output:
         * Original Center: (1, 2)
         * Original Radius: 3.0
         */

        // Modifying the original center values
        center.setX(10);
        center.setY(20);

        // Displaying the values again to show immutability
        System.out.println("Modified Center: (" + circle.getCenter().getX() + ", " + circle.getCenter().getY() + ")");
        System.out.println("Original Radius: " + circle.getRadius());

        /*
         * output:
         * Modified Center: (1, 2)
         * Original Radius: 3.0
         */
    }
}
