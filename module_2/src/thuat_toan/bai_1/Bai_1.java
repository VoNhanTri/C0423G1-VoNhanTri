package thuat_toan.bai_1;

import java.util.Map;
import java.util.TreeMap;

public class Bai_1 {
    //Cho một mảng số nguyên Hãy kiểm tra xem tần số xuất hiện
    // của tất cả các số nguyên trong mảng có bằng nhau hay không
    public static void main(String[] args) {
        int[] array = {1,2,2,1};
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length ; i++) {
            if (map.containsKey(array)){

            }
        }
    }
}
