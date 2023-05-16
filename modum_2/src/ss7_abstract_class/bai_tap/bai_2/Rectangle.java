package ss7_abstract_class.bai_tap.bai_2;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return getWidth() * getLength();
    }

    public double getPerimeter() {
        return ((getWidth() + getLength()) * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width= " + width +
                ", height= " + length +
                ", Area= " + getArea() +
                ", Perimeter= " + getPerimeter() +
                ", subclass " + super.toString() +
                '}';
    }
}
