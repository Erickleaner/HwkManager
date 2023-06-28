package backend.model.dto;

import lombok.Data;

@Data
public class SessionDto {
    boolean ifLogin;
    Object user;
}
