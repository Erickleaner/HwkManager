package backend.service;

import backend.model.dto.StudentDto;
import backend.model.po.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Service
* @createDate 2023-06-24 00:35:56
*/
public interface StudentService extends IService<Student> {

    List<StudentDto> getStudentsLikeClazzName(String clazzName);
}
