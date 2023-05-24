package ss13_thuat_toan_sap_xep.thuc_hanh;

import java.util.Arrays;

public class Test {
    public static String[] str = {"CodegymDaNang"};

    public static void main(String[] args) {
        solution(Arrays.toString(str));
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] + " ");
        }
    }

    public static void solution(String s) {
        String[] str = s.split("");
        String arr = "";
        System.out.println(Arrays.toString(str));
        String[] array = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A",
                "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (str[i] == (array[i])) {
                    arr += " " + str[i];
                }
            }
        }
    }
}

