package backend.model.vo;

import backend.model.po.Course;
import backend.model.po.Tc;
import lombok.Data;

import java.util.List;

@Data
public class TeachVo {
    Course course;
    List<TeaClazzVo> clazzList;
    Tc tc;
    public TeachVo(){ }

    public TeachVo(Course course, List<TeaClazzVo> clazzList,Tc tc) {
        this.course = course;
        this.clazzList = clazzList;
        this.tc = tc;
    }
}
