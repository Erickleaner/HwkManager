package backend.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private Integer taskId;
    private String name;
    private String descr;
    private String startTime;
    private String endTime;
    private Integer isPublish;
    public TaskDto(){}
}
