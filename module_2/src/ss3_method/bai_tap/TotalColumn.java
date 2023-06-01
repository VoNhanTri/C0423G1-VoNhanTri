package ss3_method.bai_tap;

import java.util.Scanner;

public class TotalColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap số hàng");
        int row = scanner.nextInt();
        System.out.println("nhập số cột");
        int column = scanner.nextInt();
        int[][] matrix = new int[row][column];
        System.out.println("nhập " + matrix.length + " hàng " + matrix[0].length + " cột");
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        double sum = 0;
        int indexColumn;
        System.out.println("nhập cột muốn cộng");
        indexColumn = scanner.nextShort();
            for (int c = 0; c < matrix.length; c++) {
                sum += matrix[c][indexColumn];
            }System.out.println("Sum for column " + " is " + sum);
        }

    }
