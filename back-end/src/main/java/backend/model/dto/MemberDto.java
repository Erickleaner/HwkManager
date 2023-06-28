package backend.model.dto;


import lombok.Data;

@Data
public class MemberDto {
    String no;
    String name;
    public MemberDto(){ }

    public MemberDto(String no, String name) {
        this.no = no;
        this.name = name;
    }
}
