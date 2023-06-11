package thuat_toan.bai_5;

import java.util.Arrays;

public class bai_5 {

    public static void main(String[] args) {
        int[] arr = {1, 150, 190, 170, -1, -1, 160, 180};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j] && arr[i] != -1 && arr[j] != -1) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
