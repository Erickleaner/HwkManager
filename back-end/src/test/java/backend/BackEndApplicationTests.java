package backend;

import backend.model.po.Task;
import backend.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class BackEndApplicationTests {
    @Resource
    TaskService taskService;
    @Test
    void contextLoads() {
        taskService.save(new Task());
        System.out.println("Test");
    }
}
