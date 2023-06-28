package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName task
 */
@TableName(value ="task")
@Data
public class Task implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer taskId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String detail;

    /**
     *
     */
    private Date startTime;

    /**
     *
     */
    private Date endTime;

    /**
     *
     */
    private Integer homeworkId;
    /**
     *
     */
    private Integer publish;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
