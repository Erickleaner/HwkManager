package backend.controller;


import backend.model.dto.CourseDto;
import backend.model.dto.LoginDto;
import backend.model.dto.LoginTeaDto;
import backend.model.dto.StudentDto;
import backend.model.po.*;
import backend.model.vo.InsertVo;
import backend.model.vo.LoginVo;
import backend.model.vo.MemCourseVo;
import backend.service.*;
import backend.tool.Tool;
import backend.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    CourseService courseService;
    @Resource
    TcService tcService;
    @Resource
    CtcService ctcService;
    @Resource
    ClazzService clazzService;

    @Resource
    StudentService studentService;
    @Resource
    TeacherService teacherService;
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
    //
    @GetMapping("/ownList")
    public Result<List<CourseDto>> ownList(HttpServletRequest request) {
        int teacherId = Tool.teaIdFromSession(request);
        List<CourseDto> courseList = courseService.getCourseByTeacherId(teacherId);
        for (CourseDto courseDto:courseList){
            //find target tc
            LambdaQueryWrapper<Tc> tcQueryWrapper = new LambdaQueryWrapper<>();
            tcQueryWrapper.eq(Tc::getCourseId,courseDto.getCourseId());
            tcQueryWrapper.eq(Tc::getTeacherId,teacherId);
            Tc tc = tcService.getOne(tcQueryWrapper);
            //find count of ctc
            LambdaQueryWrapper<Ctc> ctcQueryWrapper = new LambdaQueryWrapper<>();
            ctcQueryWrapper.eq(Ctc::getTcId,tc.getTcId());
            int clazzNum = (int) ctcService.count(ctcQueryWrapper);
            courseDto.setClazzNum(clazzNum);
        }
        return Result.success(courseList);
    }
    @GetMapping("/memList")
    public Result<List<MemCourseVo>> memList(HttpServletRequest request) {
        int studentId = Tool.stuIdFromSession(request);
        List<MemCourseVo> memCourseVoList = new ArrayList<>();
        Student student = studentService.getById(studentId);
        Clazz clazz = clazzService.getById(student.getClazzId());
        Integer clazzId = clazz.getClazzId();
        LambdaQueryWrapper<Ctc> ctcQueryWrapper = new LambdaQueryWrapper<>();
        ctcQueryWrapper.eq(Ctc::getClazzId,clazzId);
        List<Ctc> ctcList = ctcService.list(ctcQueryWrapper);
        for (Ctc ctc:ctcList){
            int tcId = ctc.getTcId();
            Tc tc = tcService.getById(tcId);
            Teacher teacher = teacherService.getById(tc.getTeacherId());
            Course course = courseService.getById(tc.getCourseId());
        }
        return Result.success(null);
    }
}
