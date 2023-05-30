package ss17_string_regex.bai_tap.bai_1_class;

import ss17_string_regex.bai_tap.bai_1_class.Validate;

import java.util.Scanner;

public class ValidateClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String classes;
        String regexClass = "^[CAP]\\d{4}[GHIK]$";
        do {
            System.out.println("Nhập tên lớp ");
            classes = scanner.nextLine();
        }while (!(Validate.checkClass(classes, regexClass)));
        System.out.println("ok");
    }
}
