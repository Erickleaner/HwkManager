package backend.model.vo;

import lombok.Data;

@Data
public class TeamVo {
    int teamId;
    String leaderNo;
    String leaderName;
    int groupNum;
    TeamRowVo teamRowVo;
    public TeamVo(){ }
}
