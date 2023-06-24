package backend.service.impl;

import backend.model.dto.StudentDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Student;
import backend.service.StudentService;
import backend.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-06-24 00:35:56
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{
    @Override
    public List<StudentDto> getStudentsLikeClazzName(String clazzName){
        return this.baseMapper.getStudentsLikeClazzName(clazzName);
    }
}




