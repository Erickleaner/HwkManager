package backend.tool;

import backend.model.dto.LoginTeaDto;
import backend.model.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;

public class Tool {
    public static Integer teaIdFromSession(HttpServletRequest request){
        /*LoginVo loginVo = (LoginVo) request.getSession().getAttribute("localUser");
        LoginTeaDto loginTeaDto = (LoginTeaDto) loginVo.getUser();
        return loginTeaDto.getTeacherId();*/
        return 100;
    }
}
