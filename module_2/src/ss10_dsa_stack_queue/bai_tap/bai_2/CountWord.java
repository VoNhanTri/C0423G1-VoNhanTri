package ss10_dsa_stack_queue.bai_tap.bai_2;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi để kiểm tra ");
        String string = scanner.nextLine();
        String[] array = string.split(" ");
        for (String s : array) {
            String str = s.toLowerCase(Locale.ROOT);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }else {
                map.put(str, 1);
            }
        }
        System.out.println(map);
    }
}
