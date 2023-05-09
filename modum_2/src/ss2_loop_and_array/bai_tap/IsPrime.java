package ss2_loop_and_array.bai_tap;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        int count = 0;
        int n = 2;
        while (count < 20) {
            if (isPrimeNumber(n)) {
                System.out.println(" " + n);
                count++;
            }
            n++;
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
