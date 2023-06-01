package ss17_string_regex.bai_tap.bai_2_number_phone;

import java.util.Scanner;

public class ValidateNumberPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberPhone;
        String regexNumberPhone = "^\\d{2}[-][0]\\d{9}$";
        do {
            System.out.println("Nhâp số điện thoại");
            numberPhone = scanner.nextLine();
        }while (!Validate.checkNumberPhone(numberPhone, regexNumberPhone));
        System.out.println("ok");
    }
}
