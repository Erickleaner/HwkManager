package backend.model.dto;


import lombok.Data;

@Data
public class LoginStuDto {
    String username;
    String password;
    String name;
    String no;
    String phone;
    String clazz;
    int grade;
    String role;
    public LoginStuDto(){}
}
