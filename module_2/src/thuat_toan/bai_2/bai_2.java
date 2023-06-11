package thuat_toan.bai_2;

import java.util.ArrayList;
import java.util.List;

public class bai_2 {
    public static void main(String[] args) {
        String string1 = "Abcdef";
        String string2 = "Adghjklbc";
        List<Character> characters = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        int count =0;
        for (int i = 0; i <string1.length() ; i++) {
          characters.add(string1.charAt(i));
        }
        for (int i = 0; i <string2.length() ; i++) {
            characterList.add(string2.charAt(i));
        }
        for (int i = 0; i <characters.size() ; i++) {
            for (int j = 0; j <characterList.size() ; j++) {
                if (characters.get(i).equals(characterList.get(j))){
                    characterList.remove(characterList.get(j));
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
