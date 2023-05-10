package ss3_method.bai_tap;

import java.util.Scanner;

public class DeleteValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i;
        int count = 0;
        do {
            System.out.println("nhập độ dài của mảng");
            n = scanner.nextInt();
        } while (n <= 0);
        int[] array = new int[n];
        System.out.println("nhập phần tử cho mảng ");
        for (i = 0; i < n; i++) {
            System.out.println("nhập phần tử thứ: " + i + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.println("mảng ban đầu");
        for (i = 0; i < n; i++) {
            System.out.println(array[i] + "\t");
        }
        System.out.println("nhập số nguyên muốn xóa: ");
        int numDel = scanner.nextInt();
        for (i = 0; i < array.length; i++) {
            if (array[i] != numDel) {
                array[count] = array[i];
                count++;
            }
        }
        n = count;
        System.out.println("mảng còn laại sau khi xoá " + numDel + " là");
        for (i = 0; i < n; i++) {
            System.out.println(array[i] + "\t");
        }
    }
}
