package backend.mapper;

import backend.model.dto.CourseDto;
import backend.model.po.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lenovo
* @description 针对表【course】的数据库操作Mapper
* @createDate 2023-06-24 00:35:56
* @Entity backend.model.po.Course
*/
public interface CourseMapper extends BaseMapper<Course> {
    List<CourseDto> getCourseByTeacherId(int teacher_id);
}




