package backend.service;

import backend.model.dto.CourseDto;
import backend.model.dto.StudentDto;
import backend.model.po.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【course】的数据库操作Service
* @createDate 2023-06-24 00:35:56
*/
public interface CourseService extends IService<Course> {
    List<CourseDto> getCourseByTeacherId(int teacher_id);
}
