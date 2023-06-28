package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName team_assign
 */
@TableName(value ="team_assign")
@Data
public class TeamAssign implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer teamAssignId;

    /**
     *
     */
    private Integer studentId;

    /**
     *
     */
    private Integer teamId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
