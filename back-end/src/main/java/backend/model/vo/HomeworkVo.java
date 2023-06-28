package backend.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HomeworkVo {
    private Integer homeworkId;

    private Integer ctcId;

    private Date startTime;

    private Date endTime;

    private String name;

    private String detail;

    private Integer publish;

    private Integer groupNum;
    public HomeworkVo(){ }
}
