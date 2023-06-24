package backend.self_service;

import backend.model.dto.StudentDto;
import backend.model.vo.InsertVo;

public interface StudentBusiness {
    Boolean remove(int studentId);

    Boolean update(StudentDto studentDto);

    InsertVo insert(StudentDto studentDto);
}
