package backend.model.vo;

import lombok.Data;

@Data
public class OptionVo {
    String text;
    int value;
    public OptionVo(){ }

    public OptionVo(String text, int value) {
        this.text = text;
        this.value = value;
    }
}
