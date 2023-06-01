package ss10_dsa_stack_queue.bai_tap.bai_3;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập một số bất kỳ để chuyển đổi t thập phân sang nhị phân");
        int num = Integer.parseInt(scanner.nextLine());
        while ((num != 0)) {
            int display = num % 2;
            stack.push(display);
            num /= 2;
        }
        System.out.println(stack);
    }
}
