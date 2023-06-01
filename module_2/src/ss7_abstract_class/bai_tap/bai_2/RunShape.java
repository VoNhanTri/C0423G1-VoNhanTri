package ss7_abstract_class.bai_tap.bai_2;

public class RunShape {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(5,8);
        for (int i = 0; i < shapes.length ; i++) {
            System.out.println(shapes[i].toString());
            if(shapes[i] instanceof Colorable) {
                shapes[i].howToColor();
            }
        }

    }
}
