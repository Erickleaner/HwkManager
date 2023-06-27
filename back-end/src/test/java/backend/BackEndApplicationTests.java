package backend;

import backend.model.po.Task;
import backend.model.po.User;
import backend.service.TaskService;
import backend.service.UserService;
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
