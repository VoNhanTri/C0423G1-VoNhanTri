package ss14_xu_ly_ngoai_le_debug.bai_tap.bai_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException extends Throwable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int firstEdge ;

            do {
                try {
                    System.out.println("Nhap canh firstEdge");
                    firstEdge = Integer.parseInt(scanner.nextLine());
                    if (firstEdge <= 0){
                        throw new TriangleException("Canh a phải > 0");
                    }
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời bạn nhập lại");
                } catch (TriangleException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            int twoEdge;
            do {
                try {
                    System.out.println("nhap canh twoEdge");
                    twoEdge = Integer.parseInt(scanner.nextLine());
                   if (twoEdge <= 0){
                       throw new TriangleException("Cạnh b phải > 0");
                   }
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Mời bạn nhập lại");
                } catch (TriangleException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            int threeEdge;
            do {
                try {
                    System.out.println("nhap canh threeEdge");
                    threeEdge = Integer.parseInt(scanner.nextLine());
                    if ( threeEdge <= 0){
                        throw new TriangleException("cạnh c phải > 0");
                    }
                    break;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("mời bạn nhập lại");
                } catch (TriangleException e) {
                    System.out.println(e.getMessage());
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

    public static boolean checkTriangle(int firstEdge, int twoEdge, int threeEdge) throws TriangleException {
        if (firstEdge + twoEdge <= threeEdge || firstEdge + threeEdge <= twoEdge || twoEdge + threeEdge <= firstEdge) {
            throw new TriangleException("Cac canh khong hop ly ");
        }
        return true;
    }
}
