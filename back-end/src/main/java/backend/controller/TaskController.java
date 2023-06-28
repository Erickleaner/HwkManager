package backend.controller;

import backend.model.dto.StudentDto;
import backend.model.po.Course;
import backend.model.po.Task;
import backend.model.po.TeamAssign;
import backend.model.vo.InsertVo;
import backend.service.TaskService;
import backend.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;
    @GetMapping("/teaList")
    public Result<List<Task>> list(int homeworkId) {
        LambdaQueryWrapper<Task> taskAssignQueryWrapper = new LambdaQueryWrapper<>();
        taskAssignQueryWrapper.eq(Task::getHomeworkId,homeworkId);
        List<Task> taskList =taskService.list(taskAssignQueryWrapper);
        return Result.success(taskList);
    }
    @PostMapping("/insert")
    public Result<InsertVo> insert(@RequestBody Task task) {
        task.setTaskId(null);
        boolean save = taskService.save(task);
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(save);
        if (save){
            insertVo.setInsertId(task.getTaskId());
        }
        return Result.success(insertVo);
    }
    @GetMapping("/publish")
    public Result<Boolean> publish(int taskId) {
        Task task = taskService.getById(taskId);
        task.setPublish(1);
        boolean save = taskService.saveOrUpdate(task);
        return Result.success(save);
    }
}
