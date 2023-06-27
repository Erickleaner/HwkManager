package backend.model.dto;


import backend.model.po.Clazz;
import backend.model.po.Course;
import lombok.Data;

import java.util.List;

@Data
public class AcquireDto {
    List<Clazz> clazzList;
    Course course;
    public AcquireDto(){}
}
