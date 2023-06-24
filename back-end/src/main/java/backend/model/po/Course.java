package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer courseId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String serialNum;

    /**
     *
     */
    private Integer stuTime;

    /**
     *
     */
    private Integer score;

    /**
     *
     */
    private String semester;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
