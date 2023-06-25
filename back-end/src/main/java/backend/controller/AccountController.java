package backend.controller;

import backend.model.dto.LoginDto;
import backend.model.vo.LoginVo;
import backend.self_service.AccountBusiness;
import backend.util.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    AccountBusiness accountBusiness;
    @PostMapping("/login")
    public Result<LoginVo> validLogin(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        LoginVo loginVo = accountBusiness.login(loginDto);
        if (loginVo.getIsLogin()){
            request.getSession().setAttribute("localUser",loginVo);
        }
        return Result.success(loginVo);
    }
}
