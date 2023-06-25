package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.PageBean;
import model.Player;
import dao.PlayerDao;
import db.DBCon;

public class PlayerDaoImpl implements PlayerDao {

    private DBCon dbCon = new DBCon();
    private Player player;
    private PageBean pageBean;

    public int addPlayer(Player Player) {
        String sql = "insert into Player(Player_num,Player_name,Player_sex) values('"
                + Player.getPlayerNum()
                + "','"
                + Player.getPlayerName()
                + "','"
                + Player.getPlayerSex()
                + "')";
//		int rs = dbCon.query(sql);
        int rs=dbCon.query(sql);

        return rs;
    }

    public int deletePlayer(String PlayerNum) {
        String sql = "delete from Player where Player_num='" + PlayerNum + "'";
        int rs = dbCon.query(sql);
        return rs;
    }

    public int editPlayer(Player Player) {
        String sql = "update Player set Player_name='" + Player.getPlayerName()
                + "',Player_sex='" + Player.getPlayerSex() + "'";
        int rs=dbCon.query(sql);
        return rs;
    }

    public List findAll() {
        List<Player> list = new ArrayList<Player>();
        String sql = "select * from Player";
        ResultSet rs = dbCon.find(sql);
        try {
            while (rs.next()) {
                int PlayerID = rs.getInt("Player_id");
                String PlayerNum = rs.getString("Player_num");
                String PlayerName = rs.getString("Player_name");
                String PlayerSex = rs.getString("Player_sex");

                player = new Player(PlayerID, PlayerNum, PlayerName, PlayerSex);
                list.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List findOne(String playerNum) {
        List<Player> list = new ArrayList<Player>();
        String sql="select * from Player where Player_num='"+playerNum+"'";
        ResultSet rs=dbCon.find(sql);
        try {
            while(rs.next()){
                int PlayerID = rs.getInt("Player_id");
                String Playernum = rs.getString("Player_num");
                String PlayerName = rs.getString("Player_name");
                String PlayerSex = rs.getString("Player_sex");
                player = new Player(PlayerID, Playernum, PlayerName, PlayerSex);
                list.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
