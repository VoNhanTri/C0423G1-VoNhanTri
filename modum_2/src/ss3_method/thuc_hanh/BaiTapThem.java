package ss3_method.thuc_hanh;

import java.util.Scanner;

public class BaiTapThem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập h");
        int height = scanner.nextInt();
        for (int i = 0; i <= height; i++) {
            for (int j = height; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                if (i == 1 || i == height || k == i * 2 - 1 || k==1) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= height; j++) {
                System.out.print(" ");
            }
            for (int k =1 ; k <= i*2-1; k++) {
                if (i == 1 || i == height || k == i * 2 - 1 || k==1) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
}
