package backend.controller;

import backend.model.dto.LoginDto;
import backend.model.dto.SessionDto;
import backend.model.vo.LoginVo;
import backend.self_service.UserBusiness;
import backend.tool.LocalUser;
import backend.tool.Tool;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserBusiness userBusiness;
    @PostMapping("/login")
    public Result<LoginVo> validLogin(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        LoginVo loginVo = userBusiness.login(loginDto);
        if (loginVo.getIsLogin()){
            String role = loginVo.getRole();
            Object user= loginVo.getUser();
            LocalUser localUser = new LocalUser();
            localUser.setRole(role);
            localUser.setUser(user);
            request.getSession().setAttribute("localUser",localUser);
        }
        return Result.success(loginVo);
    }
    @GetMapping("/session")
    public Result<SessionDto> session(HttpServletRequest request) {
        SessionDto sessionDto = new SessionDto();
        LocalUser localUser = Tool.getLocalFromSession(request);
        if (localUser==null){
            sessionDto.setIfLogin(false);
        }else {
            sessionDto.setIfLogin(true);
            sessionDto.setUser(localUser.getUser());
        }
        return Result.success(sessionDto);
    }
    @GetMapping("/quit")
    public Result<Boolean> quit(HttpServletRequest request) {
        request.getSession().removeAttribute("localUser");
        return Result.success(true);
    }
}
