package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName tc
 */
@TableName(value ="tc")
@Data
public class Tc implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer tcId;

    /**
     *
     */
    private Integer teacherId;

    /**
     *
     */
    private Integer courseid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
