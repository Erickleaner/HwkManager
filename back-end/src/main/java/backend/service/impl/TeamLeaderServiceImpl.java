package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.TeamLeader;
import backend.service.TeamLeaderService;
import backend.mapper.TeamLeaderMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【team_leader】的数据库操作Service实现
* @createDate 2023-06-27 10:30:51
*/
@Service
public class TeamLeaderServiceImpl extends ServiceImpl<TeamLeaderMapper, TeamLeader>
    implements TeamLeaderService{

}




