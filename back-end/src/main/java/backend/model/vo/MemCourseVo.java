package backend.model.vo;


import lombok.Data;

@Data
public class MemCourseVo {
    String name;
    String teacherName;
    String serialNum;
    int score;
    int stuTime;
    int ctcId;
    String semester;
    public MemCourseVo(){ }
}
