package backend.controller;


import backend.model.dto.TaskDto;
import backend.model.dto.LoginTeaDto;
import backend.model.po.Task;
import backend.model.po.Task;
import backend.model.vo.InsertVo;
import backend.model.vo.LoginVo;
import backend.service.TaskService;
import backend.service.TaskService;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;
    @GetMapping("/list")
    public Result<List<Task>> list() {
        List<Task> taskList = taskService.list();
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
    @GetMapping("/remove")
    public Result<Boolean> remove(int taskId) {
        boolean removeById = taskService.removeById(taskId);
        return Result.success(removeById);
    }
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody Task task) {
        boolean updateById = taskService.updateById(task);
        return Result.success(updateById);
    }

}
