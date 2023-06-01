package ss10_dsa_stack_queue.bai_tap.bai_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackInterger {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập độ dài của mảng: ");
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.println("nhập phần tử : " + i);
            array[i] = scanner.nextInt();
            stack.push(array[i]);
        }
        System.out.println(stack);
        for (int i = 0; i <array.length ; i++) {
            array[i] = stack.pop();
        }
        for (int i = 0; i < array.length ; i++) {
            stack.push(array[i]);
        }
        System.out.println(stack);
    }
}
