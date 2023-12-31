package backend.service.impl;


import backend.model.dto.CourseDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Course;
import backend.service.CourseService;
import backend.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【course】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {
    @Override
    public List<CourseDto> getCourseByTeacherId(int teacher_id){
        return this.baseMapper.getCourseByTeacherId(teacher_id);
    }
}



