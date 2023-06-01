package ss10_dsa_stack_queue.bai_tap.bai_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String string = "Able was I ere I saw Elba";
        String[] array = string.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
            queue.add(array[i]);
        }
        System.out.println(stack);
        System.out.println(queue);
        boolean flag = false;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (stack.pop() != queue.poll()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("chuỗi Palindrome" + stack + queue);
        } else {
            System.out.println("ko là chuỗi Palindrome");
        }
    }
}
