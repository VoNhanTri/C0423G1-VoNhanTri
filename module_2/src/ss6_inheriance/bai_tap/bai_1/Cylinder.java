package ss6_inheriance.bai_tap.bai_1;

public class Cylinder extends Circle {
    double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.getRadius() * this.getRadius() * this.height * 3.14;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "h=" + height +
                '}';
    }
}
