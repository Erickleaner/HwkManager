package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Homework;
import backend.service.HomeworkService;
import backend.mapper.HomeworkMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【homework】的数据库操作Service实现
* @createDate 2023-06-27 10:30:51
*/
@Service
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework>
    implements HomeworkService{

}




