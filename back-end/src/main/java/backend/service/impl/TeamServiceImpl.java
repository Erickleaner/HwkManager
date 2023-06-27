package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Team;
import backend.service.TeamService;
import backend.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【team】的数据库操作Service实现
* @createDate 2023-06-27 10:30:51
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{

}




