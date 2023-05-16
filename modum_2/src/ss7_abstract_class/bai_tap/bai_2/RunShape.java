package ss7_abstract_class.bai_tap.bai_2;

public class RunShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(5);

        System.out.println("before to change");
        System.out.println(shapes);
    }
}
