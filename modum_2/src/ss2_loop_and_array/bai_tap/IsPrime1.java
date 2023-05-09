package ss2_loop_and_array.bai_tap;

public class IsPrime1 {
    public static void main(String[] args) {
        int count = 0;
        int n = 2;
        while (count < 20) {
            if (isPrime(n)) {
                System.out.println(" " + n);
                count++;
            }
            n++;
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
