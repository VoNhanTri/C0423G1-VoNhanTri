package ss12_thuat_toan_tim_kiem.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SearchBinary {
    public static int binarySearch(int[] array, int value) {
       int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
               left = middle + 1;
            } else {
               right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("nhập độ dài của mảng");
            num = Integer.parseInt(scanner.nextLine());
        } while (num <= 0);
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("nhập phần tử của mảng " + i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < num; i++) {
            System.out.print(array[i] + "\t");
        }
//        int[] array = {1,2,3,4,5};
        Arrays.sort(array);
        System.out.println("Nhập số cần tìm");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(binarySearch(array, number));
    }
}
