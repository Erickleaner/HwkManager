package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName ctc
 */
@TableName(value ="ctc")
@Data
public class Ctc implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer ctcId;

    /**
     *
     */
    private Integer tcId;

    /**
     *
     */
    private Integer clazzId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
