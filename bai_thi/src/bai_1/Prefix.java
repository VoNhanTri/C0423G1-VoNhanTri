package bai_1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Prefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght;
        do {
            System.out.println("Nhập độ dài của mảng");
            lenght = Integer.parseInt(scanner.nextLine());
            if (lenght < 0 || lenght > 100) {
                System.out.println("Mời Bạn Nhập lại");
            }
        } while (lenght < 0 || lenght > 100);
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            System.out.println("Nhập từng phần tử");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(array));
        int Sum = 0;
        Set<Integer> prefixSum = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            Sum += array[i];
            prefixSum.add(Sum);
        }
        System.out.println("mảng b là prefix của mảng a là");
        System.out.println(prefixSum);
    }
}

