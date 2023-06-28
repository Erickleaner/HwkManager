package backend.model.vo;

import lombok.Data;

@Data
public class LoginVo {
    Object user;
    Boolean isLogin;
    String role;
    public LoginVo(){}
}
