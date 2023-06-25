package dao;

import java.util.List;

import model.PageBean;
import model.Player;

public interface PlayerDao {

    int addPlayer(Player player);

    int deletePlayer(String playerNum);

    int editPlayer(Player player);

    List findAll();

    List findOne(String userNum);


}
