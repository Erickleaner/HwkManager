package model;

public class Player {
    private int playerID;
    private String playerNum;
    private String playerName;
    private String playerSex;

    public int getplayerID() {
        return playerID;
    }
    public void setplayerID(int playerID) {
        this.playerID = playerID;
    }
    public String getplayerNum() {
        return playerNum;
    }
    public void setplayerNum(String playerNum) {
        this.playerNum = playerNum;
    }
    public String getplayerName() {
        return playerName;
    }
    public void setplayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getplayerSex() {
        return playerSex;
    }
    public void setplayerSex(String playerSex) {
        this.playerSex = playerSex;
    }

    public Player() {
        super();
    }

    public Player(String playerNum, String playerName, String playerSex) {
        super();
        this.playerNum = playerNum;
        this.playerName = playerName;
        this.playerSex = playerSex;
    }
    public Player(int playerID, String playerNum, String playerName, String playerSex) {
        super();
        this.playerID = playerID;
        this.playerNum = playerNum;
        this.playerName = playerName;
        this.playerSex = playerSex;
    }


}

