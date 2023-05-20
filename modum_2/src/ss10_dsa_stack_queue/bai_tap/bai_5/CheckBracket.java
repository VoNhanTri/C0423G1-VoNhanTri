package ss10_dsa_stack_queue.bai_tap.bai_5;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap một biểu thức để kiểm tra dấu ngoặc");
        String str = scanner.nextLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                right.push(str.charAt(i));
            } else if (str.charAt(i) == '(') {
                left.push(str.charAt(i));
            }
            if (right.size() > left.size()) {
                flag = false;
                break;
            }
        }
        System.out.println(flag && left.size() == right.size());
    }
}
