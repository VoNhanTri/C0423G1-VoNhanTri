package ss3_method.thuc_hanh;

import java.util.Scanner;

public class FindMaxArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 20) {
                System.out.println("Size shout not exceed 20 ");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Property list ");
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int k = 0; k < array.length; k++) {
            if (array[k] > max) {
                max = array[k];
                index = k + 1;
            }
        }
        System.out.println("the max " + max + " the index" + index);
    }
}

