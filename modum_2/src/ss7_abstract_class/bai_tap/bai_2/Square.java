package ss7_abstract_class.bai_tap.bai_2;

public class Square extends Shape implements Colorable{
    private double size;

    public Square(String color, boolean filled, double size) {
        super(color, filled);
        this.size = size;
    }

    public Square(double size) {
        this.size = size;
    }

    public Square() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getArea() {
        return getSize() * getSize();
    }

    public double getPerimeter() {
        return getSize() * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "size=" + size +
                ", Area= " + getArea() +
                ", Perimeter= " + getPerimeter() +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println(getColor() + "Color full size");
    }
}
