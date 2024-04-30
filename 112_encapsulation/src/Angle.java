public class Angle {
    private double angleInDegrees;
    private double angleInRadians;

    public static Angle angleFromDegrees(double degrees) {
        Angle a = new Angle();
        a.angleInDegrees = degrees;
        a.angleInRadians = Math.PI * degrees / 180;
        return a;
    }

    public static Angle angleFromRadians(double radians) {
        Angle a = new Angle();
        a.angleInRadians = radians;
        a.angleInDegrees = radians * 180 / Math.PI;
        return a;
    }

    public double getDegrees() {
        return angleInDegrees;
    }

    public double getRadians() {
        return angleInRadians;
    }

    public void setDegrees(double degrees) {
        this.angleInDegrees = degrees;
        this.angleInRadians = Math.PI * degrees / 180;
    }

    public void setRadians(double radians) {
        this.angleInRadians = radians;
        this.angleInDegrees = radians * 180 / Math.PI;
    }

    private Angle() {
    }
}
