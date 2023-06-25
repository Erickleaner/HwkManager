package backend.model.dto;


import lombok.Data;

@Data
public class LoginStuDto {
    int studentId;
    String username;
    String password;
    String name;
    String no;
    String phone;
    String clazz;
    int grade;
    String role;
    String power;
    public LoginStuDto(){}
}
