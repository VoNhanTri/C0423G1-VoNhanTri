package ss10_dsa_stack_queue.bai_tap.bai_1;

import java.util.Stack;

public class StackString {
    public static void main(String[] args) {
        //đảo ngược chuỗi
        Stack<Character> wStack = new Stack<>();
        String mWord = "abcdef";
        for (int i = 0; i < mWord.length(); i++) {
            wStack.push(mWord.charAt(i));
        }
        System.out.println(wStack);
        String outtp = "";
        for (int i = 0; i < mWord.length(); i++) {
            outtp += wStack.pop();
        }
        System.out.println(outtp);
    }
}
