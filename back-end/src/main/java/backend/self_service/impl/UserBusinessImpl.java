package backend.self_service.impl;


import backend.enums.Role;
import backend.model.dto.LoginDto;
import backend.model.dto.LoginStuDto;
import backend.model.dto.LoginTeaDto;
import backend.model.po.User;
import backend.model.po.Clazz;
import backend.model.po.Student;
import backend.model.po.Teacher;
import backend.model.vo.LoginVo;
import backend.self_service.UserBusiness;
import backend.service.UserService;
import backend.service.ClazzService;
import backend.service.StudentService;
import backend.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBusinessImpl implements UserBusiness {
    @Resource
    private UserService UserService;
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
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        queryWrapper.eq(User::getPassword,password);
        queryWrapper.eq(User::getRole,role);
        User User = UserService.getOne(queryWrapper);
        LoginVo loginVo = new LoginVo();
        if (User == null){
            loginVo.setIsLogin(false);
            loginVo.setUser(null);
        }else {
            Integer id = User.getUserId();
            loginVo.setIsLogin(true);
            if (role.equals(Role.STUDENT.value)){
                Student student = studentService.getById(id);
                Integer studentId = student.getStudentId();
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
                loginStuDto.setStudentId(studentId);
                Clazz clazz = clazzService.getById(clazzId);
                loginStuDto.setClazz(clazz.getName());
                loginVo.setUser(loginStuDto);
                loginVo.setRole("student");
            }
            if (role.equals(Role.TEACHER.value)){
                Teacher teacher = teacherService.getById(id);
                Integer teacherId = teacher.getTeacherId();
                String name = teacher.getName();
                LoginTeaDto loginTeaDto = new LoginTeaDto();
                loginTeaDto.setUsername(username);
                loginTeaDto.setPassword(password);
                loginTeaDto.setName(name);
                loginTeaDto.setRole(role);
                loginTeaDto.setTeacherId(teacherId);
                loginTeaDto.setPower(teacher.getPower());
                loginVo.setUser(loginTeaDto);
                loginVo.setRole("teacher");
            }
        }
        return loginVo;
    }
}
