package backend.controller;


import backend.model.dto.CourseDto;
import backend.model.dto.LoginDto;
import backend.model.dto.LoginTeaDto;
import backend.model.dto.StudentDto;
import backend.model.po.Course;
import backend.model.vo.InsertVo;
import backend.model.vo.LoginVo;
import backend.self_service.AccountBusiness;
import backend.service.CourseService;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    CourseService courseService;
    @GetMapping("/list")
    public Result<List<Course>> list() {
        List<Course> courseList = courseService.list();
        return Result.success(courseList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody Course course) {
        course.setCourseId(null);
        boolean save = courseService.save(course);
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(save);
        if (save){
            insertVo.setInsertId(course.getCourseId());
        }
        return Result.success(insertVo);
    }
    @GetMapping("/remove")
    public Result<Boolean> remove(int courseId) {
        boolean removeById = courseService.removeById(courseId);
        return Result.success(removeById);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody Course course) {
        boolean updateById = courseService.updateById(course);
        return Result.success(updateById);
    }

    //by teacher_id
    @GetMapping("/searchList")
    public Result<List<CourseDto>> searchList(HttpServletRequest request) {
        LoginVo loginVo = (LoginVo) request.getSession().getAttribute("localUser");
        LoginTeaDto loginTeaDto = (LoginTeaDto) loginVo.getUser();
        int teacherId = loginTeaDto.getTeacherId();
        List<CourseDto> courseList = courseService.getCourseByTeacherId(teacherId);
        return Result.success(courseList);
    }
}
