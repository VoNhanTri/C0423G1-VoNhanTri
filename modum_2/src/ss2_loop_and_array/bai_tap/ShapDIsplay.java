package ss2_loop_and_array.bai_tap;

import java.util.Scanner;

public class ShapDIsplay {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("*  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.println(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print(" * ");
            }
            System.out.println("");
        }
        System.out.println("");

    }
}
