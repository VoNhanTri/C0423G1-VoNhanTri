package ss3_method.bai_tap;

import java.util.Scanner;

    public class CountChar {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String string = "codegymdannang";
            System.out.println(string);
            char checkChar;
            System.out.println("nhập ký tự muốn kiểm tra ");
            checkChar = scanner.nextLine().charAt(0);
            int count = 0;
            for (int i = 0; i <string.length() ; i++) {
                if (checkChar == string.charAt(i)){
                    count ++;
                }
            }
            System.out.println("tổng kí tự có trong chuỗi  " +string.length());
            System.out.println("ký tự " + checkChar + " xuất hiên "+count);
        }
    }

