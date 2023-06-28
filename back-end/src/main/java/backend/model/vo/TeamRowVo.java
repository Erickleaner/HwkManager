package backend.model.vo;

import backend.model.dto.MemberDto;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;

import java.util.List;

@Data
public class TeamRowVo {
    MemberDto leader;
    List<MemberDto> members;
    public TeamRowVo(){ }

}
