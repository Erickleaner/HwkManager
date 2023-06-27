package backend.model.dto;

import backend.model.po.Clazz;
import backend.model.po.Tc;
import lombok.Data;

@Data
public class HmkTeaDto {
    Tc tc;
    Clazz clazz;
    public HmkTeaDto(){}
}
