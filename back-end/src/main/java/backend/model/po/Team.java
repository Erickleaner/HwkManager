package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName team
 */
@TableName(value ="team")
@Data
public class Team implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer teamId;

    /**
     *
     */
    private Integer homeworkId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
