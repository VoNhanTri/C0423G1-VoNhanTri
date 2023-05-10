package ss3_method.bai_tap;

import java.util.Scanner;

public class AddNewValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("nhập độ dài của mảng");
            n = scanner.nextInt();
        } while (n <= 0);
        int[] array = new int[100];
        System.out.println("nhập các phần tử của mảng");
        for (int i = 0; i < n; i++) {
            System.out.println("nhập phần tử thứ " + i + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.println("mảng ban đầu: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("nhập phần tử muốn thêm" + "\t");
        int more = scanner.nextInt();
        System.out.println("nhập vị trí muốn chèn");
        int index = scanner.nextInt();
        for (int i = n - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = more;

        n++;
        System.out.print("Mảng sau khi chèn");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i] + "\t");
        }
    }
}
