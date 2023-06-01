package ss3_method.thuc_hanh;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        String[] student = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name is student");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i <student.length ; i++) {
            if (student[i].equals(input_name)){
                System.out.println("Position of the students in the list " + input_name + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (isExist){
            System.out.println("Not found " + input_name + " in the list.");
        }
    }
}
