public class Angle2 {
    private double angleInDegrees;

    public static Angle2 angleFromDegrees(double degrees) {
        Angle2 a = new Angle2();
        a.angleInDegrees = degrees;
        return a;
    }

    public static Angle2 angleFromRadians(double radians) {
        Angle2 a = new Angle2();
        a.angleInDegrees = radians * 180 / Math.PI;
        return a;
    }

    public double getDegrees() {
        return angleInDegrees;
    }

    public double getRadians() {
        return angleInDegrees * Math.PI / 180;
    }

    public void setDegrees(double degrees) {
        this.angleInDegrees = degrees;
    }

    public void setRadians(double radians) {
        this.angleInDegrees = radians * 180 / Math.PI;
    }

    private Angle2() {
    }
}
