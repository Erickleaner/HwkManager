package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Teacher;
import backend.service.TeacherService;
import backend.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}




