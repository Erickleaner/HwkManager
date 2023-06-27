package backend.model.vo;

import backend.model.po.Clazz;
import lombok.Data;

@Data
public class TeaClazzVo {
    private Integer clazzId;
    private String name;
    private Integer majorId;
    private String contacts;
    private String phone;
    int ctcId;
    public TeaClazzVo(){ }
    public TeaClazzVo(Clazz clazz){
        clazzId = clazz.getClazzId();
        name = clazz.getName();
        majorId = clazz.getMajorId();
        contacts = clazz.getContacts();
        phone = clazz.getPhone();
    }
}
