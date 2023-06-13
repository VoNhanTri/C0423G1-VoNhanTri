package bai_3.service.impl;

import bai_3.model.Player;
import bai_3.repository.IPlayerRepository;
import bai_3.repository.impl.PlayerRepository;
import bai_3.service.IPlayerService;

import java.util.List;
import java.util.Scanner;

public class PlayerService implements IPlayerService {
    private static Scanner scanner = new Scanner(System.in);
    private static IPlayerRepository playerRepository = new PlayerRepository();


    @Override
    public void addPlayer() {
        System.out.println("Mời Nhập Mã Cầu Thủ Bạn Muốn Thêm");
        String code = scanner.nextLine();
        System.out.println("Nhập Tên Cầu Thủ Bạn Muốn Thêm");
        String name = scanner.nextLine();
        System.out.println("Nhập Ngày Tháng Năm Sinh Bạn Muốn Thêm");
        String date = scanner.nextLine();
        System.out.println("Nhập Địa Chỉ Bạn Muốn thêm");
        String dress = scanner.nextLine();
        System.out.println("Nhập Đội Tuyển Bạn Muốn Thêm");
        String team = scanner.nextLine();
        Player player = new Player(code, name, date, dress, team);
        playerRepository.addPlayer(player);
    }

    @Override
    public void displayPlayer() {
        List<Player> players = playerRepository.getAllPlayer();
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
