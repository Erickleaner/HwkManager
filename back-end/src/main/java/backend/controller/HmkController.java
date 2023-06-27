package backend.controller;


import backend.model.dto.HmkTeaDto;
import backend.model.dto.StudentDto;
import backend.model.po.Clazz;
import backend.model.po.Ctc;
import backend.model.po.Homework;
import backend.model.po.Tc;
import backend.model.vo.InsertVo;
import backend.model.vo.OptionVo;
import backend.service.CtcService;
import backend.service.HomeworkService;
import backend.service.MajorService;
import backend.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hmk")
public class HmkController {
    @Resource
    HomeworkService homeworkService;
    @Resource
    CtcService ctcService;
    @PostMapping ("/teachList")
    public Result<List<Homework>> teaHmkList(@RequestBody HmkTeaDto hmkTeaDto, HttpServletRequest request) {
        //找到唯一的Ctc
        Clazz clazz = hmkTeaDto.getClazz();
        Tc tc = hmkTeaDto.getTc();
        LambdaQueryWrapper<Ctc> ctcQueryWrapper = new LambdaQueryWrapper<>();
        ctcQueryWrapper.eq(Ctc::getTcId,tc.getTcId());
        ctcQueryWrapper.eq(Ctc::getClazzId,clazz.getClazzId());
        Ctc ctc = ctcService.getOne(ctcQueryWrapper);
        //对应的任务列表
        LambdaQueryWrapper<Homework> hmkQueryWrapper = new LambdaQueryWrapper<>();
        hmkQueryWrapper.eq(Homework::getCtcId,ctc.getCtcId());
        if (homeworkService.count(hmkQueryWrapper)==0) return Result.success(new ArrayList<>());
        List<Homework> homeworkList = homeworkService.list(hmkQueryWrapper);
        return Result.success(homeworkList);
    }
    @GetMapping("/list")
    public Result<List<Homework>> list() {
        List<Homework> homeworkList = homeworkService.list();
        return Result.success(homeworkList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody Homework homework) {
        InsertVo insertVo = new InsertVo();
        boolean save = homeworkService.save(homework);
        insertVo.setInsert(save);
        if (!save) return Result.success(insertVo);
        insertVo.setInsertId(homework.getHomeworkId());
        return Result.success(insertVo);
    }
}
