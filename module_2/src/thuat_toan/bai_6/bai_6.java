package thuat_toan.bai_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bai_6 {


    public static void main(String[] args) {
        String str = "abdcef123d";
        String[] string = str.split("");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < i; j++) {
                if (string[i].equals(string[j])) {
                    stringList.add(string[i]);
                    break;
                }
            }
        }
        System.out.println(stringList);
    }
}
