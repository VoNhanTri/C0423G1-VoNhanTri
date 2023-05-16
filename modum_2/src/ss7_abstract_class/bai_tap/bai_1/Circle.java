package ss7_abstract_class.bai_tap.bai_1;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }

    public double getPerimeter() {
        return getRadius() * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius= " + getRadius() +
                ", Area= " + getArea() +
                ", Perimeter= " + getPerimeter() +
                ", sublass " + super.toString() +
                '}';
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() * (100/percent));
    }
}
