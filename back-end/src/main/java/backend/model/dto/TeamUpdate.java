package backend.model.dto;


import backend.model.po.Homework;
import lombok.Data;

import java.util.List;

@Data
public class TeamUpdate {
    private Homework hmk;
    int teamId;
    MemberDto leader;
    List<MemberDto> members;
    public TeamUpdate(){ }
}
