package backend.controller;


import backend.model.dto.HmkTeaDto;
import backend.model.dto.StudentDto;
import backend.model.po.*;
import backend.model.vo.*;
import backend.service.*;
import backend.tool.Tool;
import backend.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/hmk")
public class HmkController {
    @Resource
    HomeworkService homeworkService;
    @Resource
    CtcService ctcService;
    @Resource
    ClazzService clazzService;
    @Resource
    StudentService studentService;
    @Resource
    TeamAssignService teamAssignService;
    @Resource
    TeamService teamService;
    @Resource
    TeamLeaderService teamLeaderService;
    @PostMapping ("/teachList")
    public Result<List<HomeworkVo>> teaHmkList(@RequestBody HmkTeaDto hmkTeaDto, HttpServletRequest request) {
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
        List<HomeworkVo> homeworkVoList = new ArrayList<>();
        for (Homework homework:homeworkList){
            HomeworkVo homeworkVo = new HomeworkVo();
            Integer homeworkId = homework.getHomeworkId();
            homeworkVo.setHomeworkId(homeworkId);
            homeworkVo.setCtcId(homework.getCtcId());
            homeworkVo.setStartTime(homework.getStartTime());
            homeworkVo.setEndTime(homework.getEndTime());
            homeworkVo.setName(homework.getName());
            homeworkVo.setDetail(homework.getDetail());
            homeworkVo.setPublish(homework.getPublish());
            LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
            teamQueryWrapper.eq(Team::getHomeworkId,homeworkId);
            int count = (int) teamService.count(teamQueryWrapper);
            homeworkVo.setGroupNum(count);
            homeworkVoList.add(homeworkVo);
        }
        return Result.success(homeworkVoList);
    }
    @GetMapping("/list")
    public Result<List<Homework>> list() {
        List<Homework> homeworkList = homeworkService.list();
        return Result.success(homeworkList);
    }
    @GetMapping("/memList")
    public Result<List<MemHomeworkVo>> memList(int ctcId,HttpServletRequest request) {
        Integer currentId = Tool.getUserIdFromSession(request);
        LambdaQueryWrapper<Homework> hmkQueryWrapper = new LambdaQueryWrapper<>();
        hmkQueryWrapper.eq(Homework::getCtcId,ctcId);
        hmkQueryWrapper.eq(Homework::getPublish,1);
        List<Homework> homeworkList = homeworkService.list(hmkQueryWrapper);
        List<MemHomeworkVo> homeworkVoList = new ArrayList<>();
        for (Homework homework:homeworkList){
            MemHomeworkVo homeworkVo = getMemHomeworkVo(homework);
            LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
            teamQueryWrapper.eq(Team::getHomeworkId,homeworkVo.getHomeworkId());
            Team team = teamService.getOne(teamQueryWrapper);
            Integer teamId = team.getTeamId();
            TeamLeader teamLeader = teamLeaderService.getById(teamId);
            Integer teamAssignId = teamLeader.getTeamAssignId();
            TeamAssign teamAssign = teamAssignService.getById(teamAssignId);
            Integer studentId = teamAssign.getStudentId();
            if (Objects.equals(studentId, currentId)) homeworkVo.setIfLeader(true);
            else homeworkVo.setIfLeader(false);
        }
        return Result.success(homeworkVoList);
    }
    private MemHomeworkVo getMemHomeworkVo(Homework homework){
        MemHomeworkVo memHomeworkVo = new MemHomeworkVo();
        memHomeworkVo.setHomeworkId(homework.getHomeworkId());
        memHomeworkVo.setCtcId(homework.getCtcId());
        memHomeworkVo.setStartTime(homework.getStartTime());
        memHomeworkVo.setEndTime(homework.getEndTime());
        memHomeworkVo.setName(homework.getName());
        memHomeworkVo.setDetail(homework.getDetail());
        memHomeworkVo.setPublish(homework.getPublish());
        return memHomeworkVo;
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
    @PostMapping("/save")
    public Result<Boolean> update(@RequestBody Homework homework) {
        int homeworkId = homework.getHomeworkId();
        Homework target = homeworkService.getById(homeworkId);
        target.setStartTime(homework.getStartTime());
        target.setEndTime(homework.getEndTime());
        target.setName(homework.getName());
        target.setDetail(homework.getDetail());
        target.setPublish(homework.getPublish());
        boolean save = homeworkService.saveOrUpdate(target);
        return Result.success(save);
    }
    @GetMapping("/submit")
    public Result<Boolean> submit(int homeworkId) {
        if (!submitJudge(homeworkId)) return Result.success(false);
        Homework target = homeworkService.getById(homeworkId);
        target.setPublish(1);
        boolean save = homeworkService.saveOrUpdate(target);
        return Result.success(save);
    }
    private boolean submitJudge(int homeworkId){
        Homework homework = homeworkService.getById(homeworkId);
        Ctc ctc = ctcService.getById(homework.getCtcId());
        Integer clazzId = ctc.getClazzId();
        LambdaQueryWrapper<Student> stuQueryWrapper = new LambdaQueryWrapper<>();
        stuQueryWrapper.eq(Student::getClazzId,clazzId);
        int total = (int) studentService.count(stuQueryWrapper);
        LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
        teamQueryWrapper.eq(Team::getHomeworkId,homeworkId);
        List<Team> teamList = teamService.list(teamQueryWrapper);
        int count = 0;
        for (Team team:teamList){
            LambdaQueryWrapper<TeamAssign> teamAssignQueryWrapper = new LambdaQueryWrapper<>();
            teamAssignQueryWrapper.eq(TeamAssign::getTeamId,team.getTeamId());
            int teamNum = (int) teamAssignService.count(teamAssignQueryWrapper);
            count += teamNum;
        }
        return count == total;
    }
}
