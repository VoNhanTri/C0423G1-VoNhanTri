package ss2_loop_and_array.bai_tap;

public class IsPrimeMin100 {
    public static void main(String[] args) {
        int n = 2;
        while (n < 100) {
            if (isPrime(n)) {
                System.out.println(" " + n);
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
