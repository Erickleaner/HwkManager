package backend.model.dto;


import lombok.Data;

@Data
public class LoginDto {
    String username;
    String password;
    String role;
    public LoginDto(){}
}
