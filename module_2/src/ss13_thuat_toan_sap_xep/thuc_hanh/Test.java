package ss13_thuat_toan_sap_xep.thuc_hanh;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String str = "CodegymDaNang";
        System.out.println(solution(str));
    }

    public static String solution(String s) {
        String[] str = s.split("");
        String arr = "";
        String list = "";
        System.out.println(Arrays.toString(str));
//        String[] array = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A",
//                "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
        for (int i = 0; i < str.length; i++) {
//            for (int j = 0; j < array.length; j++) {
                if (str[i].equals(str[i].toUpperCase())) {
                    arr += " " + str[i];
                } else {
                    arr += str[i];
                }
            }
//        }
        list = arr.toLowerCase().trim();
        return list;
    }
}

