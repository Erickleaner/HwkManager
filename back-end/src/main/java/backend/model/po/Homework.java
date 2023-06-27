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
 * @TableName homework
 */
@TableName(value ="homework")
@Data
public class Homework implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer homeworkId;

    /**
     *
     */
    private Integer ctcId;

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
    private String name;

    /**
     *
     */
    private String detail;

    /**
     *
     */
    private Integer publish;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
