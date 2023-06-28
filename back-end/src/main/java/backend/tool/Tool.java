package backend.tool;

import backend.model.dto.LoginStuDto;
import backend.model.dto.LoginTeaDto;
import backend.model.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;

public class Tool {
    public static Integer teaIdFromSession(HttpServletRequest request){
        LoginVo loginVo = (LoginVo) request.getSession().getAttribute("localUser");
        LoginTeaDto loginTeaDto = (LoginTeaDto) loginVo.getUser();
        return loginTeaDto.getTeacherId();
        //return 100;
    }
    public static Integer stuIdFromSession(HttpServletRequest request){
        Object user = request.getSession().getAttribute("localUser");
        if (user==null) return -1;
        LoginVo loginVo = (LoginVo) user;
        LoginTeaDto loginTeaDto = (LoginTeaDto) loginVo.getUser();
        return loginTeaDto.getTeacherId();
        //return 1;
    }
    public static LocalUser getLocalFromSession(HttpServletRequest request){
        LocalUser localUser = (LocalUser) request.getSession().getAttribute("localUser");
        return localUser;
    }
    public static Integer getUserIdFromSession(HttpServletRequest request){
        LocalUser localUser = (LocalUser) request.getSession().getAttribute("localUser");
        String role = localUser.getRole();
        if (role.equals("student")){
            LoginStuDto loginStuDto = (LoginStuDto) localUser.getUser();
            return loginStuDto.getStudentId();
        }else {
            LoginTeaDto loginTeaDto = (LoginTeaDto) localUser.getUser();
            return loginTeaDto.getTeacherId();
        }
    }
}
