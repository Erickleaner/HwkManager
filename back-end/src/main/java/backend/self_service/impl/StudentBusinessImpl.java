package backend.self_service.impl;

import backend.model.dto.StudentDto;
import backend.model.po.Account;
import backend.model.po.Student;
import backend.model.vo.InsertVo;
import backend.self_service.StudentBusiness;
import backend.service.AccountService;
import backend.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentBusinessImpl implements StudentBusiness {
    @Resource
    StudentService studentService;
    @Resource
    AccountService accountService;
    @Override
    public Boolean remove(int studentId){
        boolean removeAcc = accountService.removeById(studentId);
        boolean removeStu = studentService.removeById(studentId);
        return removeAcc && removeStu;
    }
    @Override
    public Boolean update(StudentDto studentDto){
        Account account = getAccount(studentDto);
        Boolean accUpdate = accountService.updateById(account);
        Student student = getStudent(studentDto);
        Boolean stuUpdate = studentService.updateById(student);
        return accUpdate && stuUpdate;
    }
    @Override
    public InsertVo insert(StudentDto studentDto){
        InsertVo faultVo = new InsertVo(-1,false);
        Account account = getAccount(studentDto);
        boolean accUpdate = accountService.save(account);
        if (!accUpdate) return faultVo;
        Student student = getStudent(studentDto);
        student.setStudentId(account.getAccountId());
        boolean stuUpdate = studentService.save(student);
        if (!stuUpdate) return faultVo;
        InsertVo insertVo = new InsertVo();
        insertVo.setInsert(true);
        insertVo.setInsertId(student.getStudentId());
        return insertVo;
    }
    public Account getAccount(StudentDto studentDto){
        Integer studentId = studentDto.getStudentId();
        String username = studentDto.getUsername();
        String password = studentDto.getPassword();
        Account account = new Account();
        account.setAccountId(studentId);
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("student");
        return account;
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
