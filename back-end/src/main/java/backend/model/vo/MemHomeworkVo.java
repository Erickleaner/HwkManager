package backend.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemHomeworkVo {
    private Integer homeworkId;
    private Integer ctcId;
    private Date startTime;
    private Date endTime;
    private String name;
    private String detail;
    private Integer publish;
    boolean ifLeader;
    public MemHomeworkVo(){ }
}
