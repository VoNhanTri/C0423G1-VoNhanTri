package ss3_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxTwoWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số hàng: ");
        int r = scanner.nextInt();
        System.out.println("nhập số cột: ");
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("nhập " + matrix.length + " row and " + matrix[0].length + "column: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("số lớn nhất trong mảng: " + max);
    }
}
