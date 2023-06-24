package backend.self_service.impl;


import backend.enums.Role;
import backend.model.dto.LoginDto;
import backend.model.dto.LoginStuDto;
import backend.model.dto.LoginTeaDto;
import backend.model.po.Account;
import backend.model.po.Clazz;
import backend.model.po.Student;
import backend.model.po.Teacher;
import backend.model.vo.LoginVo;
import backend.self_service.AccountBusiness;
import backend.service.AccountService;
import backend.service.ClazzService;
import backend.service.StudentService;
import backend.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountBusinessImpl implements AccountBusiness {
    @Resource
    private AccountService accountService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private ClazzService clazzService;
    @Override
    public LoginVo login(LoginDto loginDto){
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        String role = loginDto.getRole();
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getUsername,username);
        queryWrapper.eq(Account::getPassword,password);
        queryWrapper.eq(Account::getRole,role);
        Account account = accountService.getOne(queryWrapper);
        LoginVo loginVo = new LoginVo();
        if (account == null){
            loginVo.setIsLogin(false);
            loginVo.setUser(null);
        }else {
            Integer id = account.getAccountId();
            loginVo.setIsLogin(true);
            if (role.equals(Role.STUDENT.value)){
                Student student = studentService.getById(id);
                Integer clazzId = student.getClazzId();
                String name = student.getName();
                String no = student.getNo();
                Integer grade = student.getGrade();
                String phone = student.getPhone();
                LoginStuDto loginStuDto = new LoginStuDto();
                loginStuDto.setUsername(username);
                loginStuDto.setPassword(password);
                loginStuDto.setName(name);
                loginStuDto.setNo(no);
                loginStuDto.setPhone(phone);
                loginStuDto.setGrade(grade);
                loginStuDto.setRole(role);
                Clazz clazz = clazzService.getById(clazzId);
                loginStuDto.setClazz(clazz.getName());
                loginVo.setUser(loginStuDto);
            }
            if (role.equals(Role.TEACHER.value)){
                Teacher teacher = teacherService.getById(id);
                String name = teacher.getName();
                LoginTeaDto loginTeaDto = new LoginTeaDto();
                loginTeaDto.setUsername(username);
                loginTeaDto.setPassword(password);
                loginTeaDto.setName(name);
                loginTeaDto.setRole(role);
                loginVo.setUser(loginTeaDto);
            }
        }
        return loginVo;
    }
}
