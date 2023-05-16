package ss6_inheriance.bai_tap.bai_1;

import java.util.Scanner;

public class RunCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle circle = new Circle();

        System.out.println("Nhập bán kính radius");
        circle.setRadius(Integer.parseInt(scanner.nextLine()));
        System.out.println(circle.getRadius());
        circle.setColor("blue");
        System.out.println(circle.toString());
        System.out.println("diện tích: " + circle.getArea());
        System.out.println("chu vi: " + circle.getDiameter());
        System.out.println("nhập chieeu  cao");
        double h = Integer.parseInt(scanner.nextLine());
        Cylinder cylinder = new Cylinder(circle.getRadius(), circle.getColor(), h);
        System.out.println("thể tích hình tròn: " + cylinder.getVolume());

    }
}
