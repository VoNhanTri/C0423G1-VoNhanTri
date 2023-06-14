package bai_3.repository;

import bai_3.model.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> getAllPlayer();

    void addPlayer(Player player);

    Player getByCode(String code);

}
