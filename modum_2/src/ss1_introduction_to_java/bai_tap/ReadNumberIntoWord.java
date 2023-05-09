package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ReadNumberIntoWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số muốn đọc dưới ba chữ số: ");
        int num = Integer.parseInt(scanner.nextLine());
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arrayUnits = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] arrayTens = {" ", "one", "twen", "thir", "for", "fif", "six", "seven", "eight", "nine"};
        switch ((num + "").length()) {
            case 1:
                for (int i = 0; i < number.length; i++) {
                    if (num == number[i]) {
                        System.out.println(arrayUnits[i]);
                    }
                }
                break;
            case 2:
                if (num == 10) {
                    System.out.println("ten");
                    break;
                } else if (num == 11) {
                    System.out.println("eleven");
                    break;
                } else if (num == 12) {
                    System.out.println("twelve");
                    break;
                } else if (num == 13) {
                    System.out.println("thirteen");
                    break;
                } else if (num == 14) {
                    System.out.println("fourteen");
                    break;
                } else if (num == 15) {
                    System.out.println("fifteen");
                    break;
                } else if (num == 16) {
                    System.out.println("sixteen");
                    break;
                } else if (num == 17) {
                    System.out.println("seventeen");
                    break;
                } else if (num == 18) {
                    System.out.println("eighteen");
                    break;
                } else if (num == 19) {
                    System.out.println("nineteen");
                    break;
                } else {
                    System.out.println(arrayTens[num / 10] + "ty" + arrayUnits[num % 10]);
                    break;
                }
            case 3:
                if ((num - (num / 100 * 100) == 11)) {
                    System.out.println(arrayUnits[num / 100] + "hundred" + "eleven");
                    break;
                } else if ((num - (num / 100 * 100) == 12)) {
                    System.out.println(arrayUnits[num / 100] + "hundred" + "Twelve");
                    break;
                } else if ((num - (num / 100 * 100) == 13)) {
                    System.out.println(arrayUnits[num / 100] + "hundred" + "thirteen");
                    break;
                } else {
                    System.out.println(arrayUnits[num / 100] + "hundred" + arrayTens[(num % 100) / 10] + arrayUnits[(num%100)%10]);
                    break;
                }
        }

    }
}

