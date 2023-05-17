package ss8_clean_code.bai_tap;

import java.util.Scanner;

public class RunTennis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời bạn nhập điểm người chơi đầu tiên");
        int scoreFirst = Integer.parseInt(scanner.nextLine());
        System.out.println("mời bạn nhập điểm người chơi tứ hai");
        int scoreSecond = Integer.parseInt(scanner.nextLine());
        System.out.println(TennisGame.getScore( scoreFirst, scoreSecond));
    }
}
