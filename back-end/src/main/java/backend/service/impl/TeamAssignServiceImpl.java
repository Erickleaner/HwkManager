package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.TeamAssign;
import backend.service.TeamAssignService;
import backend.mapper.TeamAssignMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【team_assign】的数据库操作Service实现
* @createDate 2023-06-27 10:30:51
*/
@Service
public class TeamAssignServiceImpl extends ServiceImpl<TeamAssignMapper, TeamAssign>
    implements TeamAssignService{

}




