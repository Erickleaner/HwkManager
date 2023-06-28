package backend.model.dto;

import backend.model.po.Homework;
import lombok.Data;

import java.util.List;

@Data
public class TeamInsert {
    private Homework hmk;
    MemberDto leader;
    List<MemberDto> members;
    public TeamInsert(){}
}
