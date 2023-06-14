package bai_3.controller;

import bai_3.service.IPlayerService;
import bai_3.service.impl.PlayerService;

import java.util.Scanner;

public class PlayerController {
    private static Scanner scanner = new Scanner(System.in);
    private  static IPlayerService playerService = new PlayerService();

    public static void menu(){
        do {
            System.out.println("---Hệ Thống Quản Lý Cầu Thủ---");
            System.out.println("1. Thêm Cầu Thủ");
            System.out.println("2. Hiển Thị Danh Sách Cầu Thủ");
            System.out.println("3. Sút Penalty");
            System.out.println("4. Thoát");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    playerService.addPlayer();
                    break;
                case "2":
                    playerService.displayPlayer();
                    break;
                case "3":
                    break;
                case "4":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Mời Bạn Nhập từ 1 đến 4");
            }
        }while (true);

    }
}
