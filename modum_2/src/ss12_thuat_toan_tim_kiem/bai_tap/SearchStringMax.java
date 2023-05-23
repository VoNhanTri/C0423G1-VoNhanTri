package ss12_thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchStringMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chuỗi để kiểm tra");
        String string = scanner.nextLine();
        LinkedList<Character> lits = new LinkedList<>();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            if (lits.size() > 1 && string.charAt(i) <= lits.getLast()) {
                lits.clear();
            }
            lits.add(string.charAt(i));
            if (lits.size() > max.size()) {
                max.clear();
                max.addAll(lits);
            }
        }

        for (Character s : max) {
            System.out.print(s);
        }
    }
}
