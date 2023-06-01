package ss2_loop_and_array.thuc_hanh;
import java.util.Scanner;
public class LaiXuat {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner input = new Scanner(System.in);
        //nhập số tiền gửi
        System.out.println("Enter investment amount: ");
        money = input.nextDouble();
        //nhập số tháng gửi
        System.out.println("Enter number of month: ");
        month = input.nextInt();
        //nhập lại suất
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = input.nextDouble();
        double totalInterest = 0;
        totalInterest += money*(interestRate/100)/12 *month;
        System.out.println("total of Interest " + totalInterest);
    }
}
