package ss4_class_object.bai_tap.bai_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số a");
        double a = scanner.nextDouble();
        System.out.println("Nhập số b");
        double b = scanner.nextDouble();
        System.out.println("nhập số c");
        double c = scanner.nextDouble();
        QuadraticEquation delta = new QuadraticEquation(a, b, c);
        double result = delta.getDiscriminant();
        if (result >= 0) {
            System.out.println("phương trình có nghiệm 1 là : "+delta.getRoot1());
            System.out.println("phương trình có nghiệm 2 là : "+delta.getRoot2());
        }else {
            System.out.println("phương trình vô nghiệm");
        }
    }
}
