package ss3_method.bai_tap;

import java.util.Arrays;

public class ConnectArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int length = array1.length + array2.length;
        int[] array3 = new int[length];
        int i ;
        for (i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (i = 0; i < array2.length; i++) {
            array3[i] = array2[i];
        }
        System.out.println("Mảng sau khi nối: ");
        System.out.println(Arrays.toString(array3));
        int pout = 0;
        for (int element: array1) {
            array3[pout] = element;
            pout++;
        }
        for (int element: array2) {
            array3[pout] = element;
            pout++;
        }
        System.out.println("mảng sau khi nối 1");
        System.out.println(Arrays.toString(array3));
    }
}
