package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền USD");
        usd = Double.parseDouble(scanner.nextLine());
        System.out.println(usd);
        double vnd = usd * 23000;
        System.out.println(vnd);
    }
}
