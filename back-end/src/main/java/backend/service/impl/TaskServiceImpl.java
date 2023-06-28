package backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import backend.model.po.Task;
import backend.service.TaskService;
import backend.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【task】的数据库操作Service实现
* @createDate 2023-06-28 08:22:09
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

}




