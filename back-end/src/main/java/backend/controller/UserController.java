package backend.controller;

import backend.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public Result<Boolean> validLogin(String username, String password, HttpServletRequest request) {
        return Result.success(true);
    }
}
