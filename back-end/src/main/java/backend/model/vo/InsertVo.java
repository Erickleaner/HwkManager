package backend.model.vo;


import lombok.Data;

@Data
public class InsertVo {
    int insertId;
    boolean isInsert;
    public InsertVo(){}

    public InsertVo(int insertId, boolean isInsert) {
        this.insertId = insertId;
        this.isInsert = isInsert;
    }
}
