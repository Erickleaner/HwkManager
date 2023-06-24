package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName major
 */
@TableName(value ="major")
@Data
public class Major implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer majorId;

    /**
     *
     */
    private String name;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
