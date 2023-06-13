package bai_2;

import java.util.Arrays;
import java.util.Scanner;

public class Consecutive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lenght;
        do {
            System.out.println("Nhập độ dài của mảng");
            lenght = Integer.parseInt(s.nextLine());
            if (lenght < 0 || lenght >= 200) {
                System.out.println("Mời bạn nhập Lại lenght > 0  và lenght < 200");
            }
        } while (lenght < 0 || lenght >= 200);
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            System.out.println("nhap từng phần tử");
            array[i] = Integer.parseInt(s.nextLine());
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng " + min);
        System.out.println("Phần tử lớn nhất trong mảng " + max);
    }
}
