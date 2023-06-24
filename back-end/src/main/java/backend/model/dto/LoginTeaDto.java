package backend.model.dto;

import lombok.Data;

@Data
public class LoginTeaDto {
    String username;
    String password;
    String name;
    String role;
    public LoginTeaDto(){}
}
