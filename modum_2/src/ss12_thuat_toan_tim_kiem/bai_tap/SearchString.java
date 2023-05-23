package ss12_thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chuỗi để kiểm tra ");
        String str = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character s : max) {
            System.out.print(s);
        }
//        Scanner input = new Scanner(System.in);
//        System.out.println("nhập chuỗi để kiểm tra ");
//        String str = input.nextLine();
//        LinkedList<Character> max = new LinkedList<>();
//        LinkedList<Character> list = new LinkedList<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (list.size() >= 1 && str.charAt(i) <= list.getLast()) {
//                list.clear();
//            }
//            list.add(str.charAt(i));
//            if (list.size() > max.size()) {
//                max.clear();
//                max.addAll(list);
//            }
//        }
//        for (Character s : max) {
//            System.out.println(s);
//        }
    }
}
