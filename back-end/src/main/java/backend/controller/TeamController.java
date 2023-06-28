package backend.controller;

import backend.model.dto.*;
import backend.model.po.*;
import backend.model.vo.InsertVo;
import backend.model.vo.TeamRowVo;
import backend.model.vo.TeamVo;
import backend.service.StudentService;
import backend.service.TeamAssignService;
import backend.service.TeamLeaderService;
import backend.service.TeamService;
import backend.tool.Tool;
import backend.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//删除写完更新自然比较简单
@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    TeamService teamService;
    @Resource
    StudentService studentService;
    @Resource
    TeamAssignService teamAssignService;
    @Resource
    TeamLeaderService teamLeaderService;
    @GetMapping("/list")
    public Result<List<TeamVo>> list(int homeworkId) {
        List<TeamVo> teamVoList = new ArrayList<>();
        LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
        teamQueryWrapper.eq(Team::getHomeworkId, homeworkId);
        List<Team> teamList = teamService.list(teamQueryWrapper);
        for (Team team:teamList){
            TeamVo teamVo = new TeamVo();
            int teamId = team.getTeamId();
            //getLeader
            TeamLeader teamLeader = teamLeaderService.getById(teamId);
            Integer teamAssignId = teamLeader.getTeamAssignId();
            TeamAssign teamAssign = teamAssignService.getById(teamAssignId);
            Integer studentId = teamAssign.getStudentId();
            Student student = studentService.getById(studentId);
            teamVo.setLeaderName(student.getName());
            teamVo.setLeaderNo(student.getNo());
            LambdaQueryWrapper<TeamAssign> teamAssignQueryWrapper = new LambdaQueryWrapper<>();
            teamAssignQueryWrapper.eq(TeamAssign::getTeamId, teamId);
            List<TeamAssign> teamAssignList = teamAssignService.list(teamAssignQueryWrapper);
            int groupNum = teamAssignList.size();
            teamVo.setGroupNum(groupNum);
            teamVo.setTeamId(teamId);
            TeamRowVo teamRowVo = new TeamRowVo();
            teamRowVo.setLeader(new MemberDto(student.getNo(),student.getName()));
            List<MemberDto> members = new ArrayList<>();
            for (TeamAssign assign:teamAssignList){
                Integer stuMemberId = assign.getStudentId();
                if (!Objects.equals(stuMemberId, studentId)){
                    Student stuMember = studentService.getById(stuMemberId);
                    members.add(new MemberDto(stuMember.getNo(),stuMember.getName()));
                }
            }
            teamRowVo.setMembers(members);
            teamVo.setTeamRowVo(teamRowVo);
            teamVoList.add(teamVo);
        }
        return Result.success(teamVoList);
    }
    @GetMapping("/remove")
    public Result<Boolean> remove(int teamId) {
        teamLeaderService.removeById(teamId);
        LambdaQueryWrapper<TeamAssign> teamAssignQueryWrapper = new LambdaQueryWrapper<>();
        teamAssignQueryWrapper.eq(TeamAssign::getTeamId,teamId);
        teamAssignService.remove(teamAssignQueryWrapper);
        teamService.removeById(teamId);
        return Result.success(true);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody TeamInsert teamInsert, HttpServletRequest request) {
        return Result.success(judgeInsert(teamInsert));
    }
    private void removeTemple(List<TeamAssign> teamAssignList,TeamLeader leader){
        teamLeaderService.removeById(leader.getTeamLeaderId());
        for (TeamAssign teamAssign:teamAssignList){
            teamAssignService.removeById(teamAssign.getTeamAssignId());
        }
    }
    private void recoverTemple(List<TeamAssign> teamAssignList,TeamLeader leader){
        for (TeamAssign teamAssign:teamAssignList){
            teamAssignService.save(teamAssign);
        }
        teamLeaderService.save(leader);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody TeamUpdate teamUpdate, HttpServletRequest request) {
        //还是得先删除leader
        int teamId = teamUpdate.getTeamId();
        LambdaQueryWrapper<TeamAssign> teamAssignQueryWrapper = new LambdaQueryWrapper<>();
        teamAssignQueryWrapper.eq(TeamAssign::getTeamId,teamId);
        List<TeamAssign> teamAssignList = teamAssignService.list(teamAssignQueryWrapper);
        TeamLeader teamLeader = teamLeaderService.getById(teamId);
        removeTemple(teamAssignList,teamLeader);
        //先把这些现有的TaskAssign找出来删除
        //删除这些后判断是否能够合理的修改
        //若可以则继续这些操作
        //否则将删除的加回去
        //这其中不涉及ID的改变？
        Boolean update = judgeUpdate(teamUpdate);
        if (update){
            return Result.success(true);
        }else {
            recoverTemple(teamAssignList,teamLeader);
            return Result.success(false);
        }
    }
    private Boolean judgeUpdate(TeamUpdate teamUpdate){
        int homeworkId = teamUpdate.getHmk().getHomeworkId();
        MemberDto leader = teamUpdate.getLeader();
        List<MemberDto> members = teamUpdate.getMembers();
        String leaderNo = leader.getNo();
        LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
        teamQueryWrapper.eq(Team::getHomeworkId,homeworkId);
        List<Team> teamList = teamService.list(teamQueryWrapper);
        if (!validMember(leaderNo,teamList)){
            return false;
        }
        for (MemberDto member:members){
            String no = member.getNo();
            if (!validMember(no,teamList)){
                return false;
            }
        }
        doUpdateTeam(teamUpdate);
        return true;
    }
    private InsertVo judgeInsert(TeamInsert teamInsert){
        int homeworkId = teamInsert.getHmk().getHomeworkId();
        InsertVo insertVo = new InsertVo();
        MemberDto leader = teamInsert.getLeader();
        List<MemberDto> members = teamInsert.getMembers();
        String leaderNo = leader.getNo();
        LambdaQueryWrapper<Team> teamQueryWrapper = new LambdaQueryWrapper<>();
        teamQueryWrapper.eq(Team::getHomeworkId,homeworkId);
        List<Team> teamList = teamService.list(teamQueryWrapper);
        if (!validMember(leaderNo,teamList)){
            insertVo.setInsert(false);
            return insertVo;
        }
        for (MemberDto member:members){
            String no = member.getNo();
            if (!validMember(no,teamList)){
                insertVo.setInsert(false);
                return insertVo;
            }
        }
        int teamId = doInsertTeam(teamInsert);
        insertVo.setInsertId(teamId);
        insertVo.setInsert(true);
        return insertVo;
    }
    private void doUpdateTeam(TeamUpdate teamUpdate){
        int teamId = teamUpdate.getTeamId();
        MemberDto leader = teamUpdate.getLeader();
        int teamAssignId = doInsertMember(leader, teamId);
        List<MemberDto> members = teamUpdate.getMembers();
        for (MemberDto member:members){
            doInsertMember(member,teamId);
        }
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setTeamAssignId(teamAssignId);
        teamLeader.setTeamLeaderId(teamId);
        teamLeaderService.save(teamLeader);
    }
    private int doInsertTeam(TeamInsert teamInsert){
        Team team = new Team();
        int homeworkId = teamInsert.getHmk().getHomeworkId();
        team.setHomeworkId(homeworkId);
        teamService.save(team);
        Integer teamId = team.getTeamId();
        MemberDto leader = teamInsert.getLeader();
        int teamAssignId = doInsertMember(leader, teamId);
        List<MemberDto> members = teamInsert.getMembers();
        for (MemberDto member:members){
            doInsertMember(member,teamId);
        }
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setTeamAssignId(teamAssignId);
        teamLeader.setTeamLeaderId(teamId);
        teamLeaderService.save(teamLeader);
        return teamId;
    }
    private int doInsertMember(MemberDto member,int teamId){
        String no = member.getNo();
        LambdaQueryWrapper<Student> stuQueryWrapper = new LambdaQueryWrapper<>();
        stuQueryWrapper.eq(Student::getNo,no);
        Student student = studentService.getOne(stuQueryWrapper);
        int studentId = student.getStudentId();
        TeamAssign teamAssign = new TeamAssign();
        teamAssign.setStudentId(studentId);
        teamAssign.setTeamId(teamId);
        teamAssignService.save(teamAssign);
        return teamAssign.getTeamAssignId();
    }
    private Boolean validMember(String no,List<Team> teamList){
        if (teamList==null) return true;
        for (Team team:teamList){
            Integer count = teamAssignService.countFromTeamByNo(team.getTeamId(), no);
            if (count>0) return false;
        }
        return true;
    }
}
