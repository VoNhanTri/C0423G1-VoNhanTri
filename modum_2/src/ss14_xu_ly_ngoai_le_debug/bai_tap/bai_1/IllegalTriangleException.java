package ss14_xu_ly_ngoai_le_debug.bai_tap.bai_1;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int firstEdge = 0;

            do {
                try {
                    System.out.println("Nhap canh firstEdge");
                    firstEdge = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời bạn nhập lại");
                }
            } while (true);
            int twoEdge = 0;
            do {
                try {
                    System.out.println("nhap canh twoEdge");
                    twoEdge = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Mời bạn nhập lại");
                }
            } while (true);
            int threeEdge = 0;
            do {
                try {
                    System.out.println("nhap canh threeEdge");
                    threeEdge = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời bạn nhập lại");
                }

            } while (true);
            try {
                checkTriangle(firstEdge, twoEdge, threeEdge);
                System.out.println("ok");
                break;
            } catch (TriangleException triangleException) {
                System.out.println(triangleException.getMessage());
                System.out.println("vui long nhap lai ");
            }
        }
    }

    public static boolean checkTriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException("Cac canh khong hop ly ");
        }
        return true;
    }
}
