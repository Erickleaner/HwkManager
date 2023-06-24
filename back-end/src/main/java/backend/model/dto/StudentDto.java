package backend.model.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Integer studentId;
    private Integer clazzId;
    private String name;
    private String no;
    private Integer grade;
    private String phone;
    private String username;
    private String password;
    public StudentDto(){}
}
