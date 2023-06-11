package thuat_toan.bai_3;

public class bai_3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3};
        System.out.println(check(arr));
    }
    public static boolean check(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int sumFirst = 0;
            int sumSecond = 0;
            for (int j = 0; j < i; j++) {
                sumFirst += arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                sumSecond += arr[j];
            }
            if (sumFirst==sumSecond){
                return true;
            }
        }
        return false;
    }
}
