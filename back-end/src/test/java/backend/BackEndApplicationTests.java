package backend;

import backend.model.po.*;
import backend.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class BackEndApplicationTests {
    @Resource
    UserService userService;
    @Resource
    TeamService teamService;
    @Resource
    StudentService studentService;
    @Resource
    TeamAssignService teamAssignService;
    @Resource
    TeamLeaderService teamLeaderService;
    int teamId;
    @Test
    void initTaskAssign(){
        int no = 20201600;
        for (int i=1;i<=32;i++){
            String stuNo = String.valueOf(no+i);
            if ((i-1)%4==0){
                Team team = new Team();
                team.setHomeworkId(7);
                teamService.save(team);
                teamId = team.getTeamId();
            }
            TeamAssign assign = new TeamAssign();
            assign.setTeamId(teamId);
            Student student = studentService.getById(i);
            assign.setStudentId(student.getStudentId());
            teamAssignService.save(assign);
            if ((i-1)%4==0){
                TeamLeader teamLeader = new TeamLeader();
                teamLeader.setTeamAssignId(assign.getTeamAssignId());
                teamLeader.setTeamLeaderId(teamId);
                teamLeaderService.save(teamLeader);
            }
        }
    }
    @Test
    void insertAllStudents() {
        int no = 20201600;
        for (int i=1;i<=32;i++){
            User user = new User();
            user.setUserId(i);
            String username = String.valueOf(no+i);
            user.setUsername(username);
            user.setPassword("123456");
            user.setRole("student");
            userService.save(user);
        }
        no = 20201700;
        for (int i=1;i<=34;i++){
            User user = new User();
            user.setUserId(49+i);
            String username = String.valueOf(no+i);
            user.setUsername(username);
            user.setPassword("123456");
            user.setRole("student");
            userService.save(user);
        }
    }
}
