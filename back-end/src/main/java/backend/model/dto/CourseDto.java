package backend.model.dto;

import lombok.Data;

@Data
public class CourseDto {
    private Integer courseId;
    private String name;
    private String serialNum;
    private Integer stuTime;
    private Integer score;
    private String semester;
    public CourseDto(){}
}
