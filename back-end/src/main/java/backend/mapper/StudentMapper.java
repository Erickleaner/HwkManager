package backend.mapper;

import backend.model.dto.StudentDto;
import backend.model.po.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-06-24 00:35:56
* @Entity backend.model.po.Student
*/
public interface StudentMapper extends BaseMapper<Student> {
    List<StudentDto> getStudentsLikeClazzName(String clazzName);
}




