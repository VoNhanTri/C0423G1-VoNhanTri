package ss4_class_object.bai_tap.bai_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.star();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập bất kì: ");
            int num = scanner.nextInt();
        System.out.println(num);
        watch.stop();
        System.out.println(watch.getElapsedTime());
    }
}
