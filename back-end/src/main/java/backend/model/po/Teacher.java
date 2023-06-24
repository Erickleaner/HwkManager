package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher implements Serializable {
    /**
     *
     */
    @TableId
    private Integer teacherId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String power;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
