package ss5_access_modifier_static.bai_tap.bai_tap1;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius() +" "+ circle.getColor());
        System.out.println(circle.getArea() + " " + circle.getColor());
    }
}
