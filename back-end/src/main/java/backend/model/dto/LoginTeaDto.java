package backend.model.dto;

import lombok.Data;

@Data
public class LoginTeaDto {
    int teacherId;
    String username;
    String password;
    String name;
    String role;

    String power;
    public LoginTeaDto(){}
}
