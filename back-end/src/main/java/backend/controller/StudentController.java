package backend.controller;


import backend.model.dto.StudentDto;
import backend.model.vo.InsertVo;
import backend.self_service.StudentBusiness;
import backend.service.StudentService;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentService studentService;
    @Resource
    StudentService accountService;
    @Resource
    StudentBusiness studentBusiness;
    @GetMapping("/list")
    public Result<List<StudentDto>> list() {
        List<StudentDto> StudentList = studentService.getStudentsLikeClazzName("");
        return Result.success(StudentList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody StudentDto studentDto) {
        InsertVo insertVo = studentBusiness.insert(studentDto);
        return Result.success(insertVo);
    }
    @GetMapping("/remove")
    public Result<Boolean> remove(int studentId) {
        boolean isRemove = studentBusiness.remove(studentId);
        return Result.success(isRemove);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody StudentDto studentDto) {
        boolean isUpdate = studentBusiness.update(studentDto);
        return Result.success(isUpdate);
    }
    //by clazzName
    @GetMapping("/searchList")
    public Result<List<StudentDto>> searchList(String clazzName) {
        List<StudentDto> studentList = studentService.getStudentsLikeClazzName(clazzName);
        return Result.success(studentList);
    }
}
