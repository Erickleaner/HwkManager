package backend.controller;


import backend.model.dto.AcquireDto;
import backend.model.dto.StudentDto;
import backend.model.po.Clazz;
import backend.model.po.Course;
import backend.model.po.Ctc;
import backend.model.po.Tc;
import backend.model.vo.TeaClazzVo;
import backend.model.vo.TeachVo;
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
@RequestMapping("/teaBusiness")
public class TeaBusiness {
    @Resource
    TcService tcService;
    @Resource
    CtcService ctcService;
    @Resource
    CourseService courseService;
    @Resource
    ClazzService clazzService;
    //领课
    @PostMapping("/acquire")
    public Result<Boolean> acquire(@RequestBody AcquireDto acquireDto, HttpServletRequest request) {
        int teacherId = Tool.getUserIdFromSession(request);
        int courseId = acquireDto.getCourse().getCourseId();
        if (!judgeAcquire(teacherId,courseId)) return Result.success(false);
        List<Clazz> clazzList = acquireDto.getClazzList();
        Tc tc = new Tc();
        tc.setTeacherId(teacherId);
        tc.setCourseId(courseId);
        tcService.save(tc);
        for (Clazz clazz : clazzList) {
            Ctc ctc = new Ctc();
            ctc.setClazzId(clazz.getClazzId());
            ctc.setTcId(tc.getTcId());
            ctcService.save(ctc);
        }
        return Result.success(true);
    }
    private boolean judgeAcquire(int teacherId,int courseId){
        LambdaQueryWrapper<Tc> tcQueryWrapper = new LambdaQueryWrapper<>();
        tcQueryWrapper.eq(Tc::getTeacherId,teacherId);
        tcQueryWrapper.eq(Tc::getCourseId,courseId);
        int count = (int) tcService.count(tcQueryWrapper);
        return count == 0;
    }
    @GetMapping("/teach")
    public Result<List<TeachVo>> teach(HttpServletRequest request) {
        int teacherId = Tool.getUserIdFromSession(request);
        LambdaQueryWrapper<Tc> tcQueryWrapper = new LambdaQueryWrapper<>();
        tcQueryWrapper.eq(Tc::getTeacherId,teacherId);
        List<Tc> tcList = tcService.list(tcQueryWrapper);
        List<TeachVo> teachVoList = new ArrayList<>();
        for (int i=0;i<tcList.size();i++){
            Tc tc = tcList.get(i);
            Integer courseId = tc.getCourseId();
            Course course = courseService.getById(courseId);
            LambdaQueryWrapper<Ctc> ctcQueryWrapper = new LambdaQueryWrapper<>();
            ctcQueryWrapper.eq(Ctc::getTcId,tc.getTcId());
            List<Ctc> ctcList = ctcService.list(ctcQueryWrapper);
            List<TeaClazzVo> clazzList = new ArrayList<>();
            for (int j=0;j<ctcList.size();j++){
                Ctc ctc = ctcList.get(j);
                Clazz clazz = clazzService.getById(ctc.getClazzId());
                TeaClazzVo clazzVo = new TeaClazzVo(clazz);
                clazzVo.setCtcId(ctc.getCtcId());
                clazzList.add(clazzVo);
            }
            TeachVo teachVo = new TeachVo(course,clazzList,tc);
            teachVoList.add(teachVo);
        }
        return Result.success(teachVoList);
    }
}
