package backend.self_service.impl;

import backend.model.dto.StudentDto;
import backend.model.po.User;
import backend.model.po.Student;
import backend.model.vo.InsertVo;
import backend.self_service.StudentBusiness;
import backend.service.UserService;
import backend.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentBusinessImpl implements StudentBusiness {
    @Resource
    StudentService studentService;
    @Resource
    UserService userService;
    @Override
    public Boolean remove(int studentId){
        boolean removeAcc = userService.removeById(studentId);
        boolean removeStu = studentService.removeById(studentId);
        return removeAcc && removeStu;
    }
    @Override
    public Boolean update(StudentDto studentDto){
        User User = getUser(studentDto);
        Boolean accUpdate = userService.updateById(User);
        Student student = getStudent(studentDto);
        Boolean stuUpdate = studentService.updateById(student);
        return accUpdate && stuUpdate;
    }
    @Override
    public InsertVo insert(StudentDto studentDto){
        InsertVo faultVo = new InsertVo(-1,false);
        User User = getUser(studentDto);
        boolean accUpdate = userService.save(User);
        if (!accUpdate) return faultVo;
        Student student = getStudent(studentDto);
        student.setStudentId(User.getUserId());
        boolean stuUpdate = studentService.save(student);
        if (!stuUpdate) return faultVo;
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(true);
        insertVo.setInsertId(student.getStudentId());
        return insertVo;
    }
    public User getUser(StudentDto studentDto){
        Integer studentId = studentDto.getStudentId();
        String username = studentDto.getUsername();
        String password = studentDto.getPassword();
        User User = new User();
        User.setUserId(studentId);
        User.setUsername(username);
        User.setPassword(password);
        User.setRole("student");
        return User;
    }
    public Student getStudent(StudentDto studentDto){
        Integer studentId = studentDto.getStudentId();
        Integer clazzId = studentDto.getClazzId();
        String name = studentDto.getName();
        String no = studentDto.getNo();
        Integer grade = studentDto.getGrade();
        String phone = studentDto.getPhone();
        Student student = new Student();
        student.setStudentId(studentId);
        student.setClazzId(clazzId);
        student.setName(name);
        student.setNo(no);
        student.setGrade(grade);
        student.setPhone(phone);
        return student;
    }
}
