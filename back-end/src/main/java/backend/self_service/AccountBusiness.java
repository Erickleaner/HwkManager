package backend.self_service;

import backend.model.dto.LoginDto;
import backend.model.vo.LoginVo;

public interface AccountBusiness {

    LoginVo login(LoginDto loginDto);
}
