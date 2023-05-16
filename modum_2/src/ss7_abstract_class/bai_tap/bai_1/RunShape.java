package ss7_abstract_class.bai_tap.bai_1;

import java.util.Arrays;

public class RunShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        Circle circles = new Circle("blue", true, 3.5);
        Rectangle rectangles = new Rectangle("red", true, 7, 4);
        Square square = new Square("yellow", true, 5);
        shapes[0] = circles;
        shapes[1] = rectangles;
        shapes[2] = square;
        System.out.println("before to change");
        for (Shape sh: shapes  ) {
            System.out.println(sh);
        }
        for (Shape shape : shapes) {
            shape.resize(Math.random()*100);
        }
        System.out.println("to change");
        System.out.println(Arrays.toString(shapes));
    }
}
