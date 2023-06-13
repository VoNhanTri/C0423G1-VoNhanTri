package bai_3.repository.impl;

import bai_3.common.ReadAndWrite;
import bai_3.model.Player;
import bai_3.repository.IPlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerRepository implements IPlayerRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH_PLAYER = "src/bai_3/data/cau_thu.csv";
    private static List<Player> playerList = new ArrayList<>();

    @Override
    public List<Player> getAllPlayer() {
        List<String> strings = ReadAndWrite.readFile(PATH_PLAYER);
        playerList.clear();
        String[] info;
        for (String str : strings) {
            info = str.split(",");
            playerList.add(new Player(info[0], info[1], info[2], info[3], info[4]));
        }
        return playerList;
    }

    @Override
    public void addPlayer(Player player) {
        List<String> stringList = new ArrayList<>();
        stringList.add(player.getCode() + "," + player.getName() + "," + player.getDate() + "," + player.getDress() + "," + player.getTeam());
        ReadAndWrite.writeFile(PATH_PLAYER, stringList, true);
    }

    @Override
    public Player getByCode(String code) {
        playerList = getAllPlayer();
        for (Player find : playerList) {
            if (find.getCode().equals(code)) {
                return find;
            }
        }
        return null;
    }
}
