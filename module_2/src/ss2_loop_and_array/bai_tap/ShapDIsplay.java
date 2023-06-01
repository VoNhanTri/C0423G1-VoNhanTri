package ss2_loop_and_array.bai_tap;

import java.util.Scanner;

public class ShapDIsplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao: ");
        int height = scanner.nextInt();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1: Hình Chữ Nhật");
            System.out.println("2: Hình tam giác vuông");
            System.out.println("3: hình tam giác cân");
            System.out.println("4:EXIT");
            System.out.println("Nhập sự lựa chọn");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hình chữ nhật");
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < height; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("hình tam giác vuông");
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.print("\n");
                    }
                    for (int i = height; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (int i = 1; i <= height; i++) {
                        for (int j = height; j >= i; j--) {
                            System.out.print("+");
                        }
                        for (int k = 1; k <= i * 2 - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(4);
                    break;
                default:
                    System.out.println("không có sự lựa chọn");
            }
        }
    }
}
