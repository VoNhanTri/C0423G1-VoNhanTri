package thuat_toan.bai_7;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class bai_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số hàng");
        int r = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập số cột");
        int c = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[r][c];
        System.out.println("Nhập " + matrix.length + " số hàng va " + matrix[0].length + " số cột");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
        Set<Integer> array = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (checkPrime(matrix[i][j])) {
                    array.add(matrix[i][j]);
                }
            }
        }
        System.out.println(array);
    }

    public static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
