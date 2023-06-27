package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName team_leader
 */
@TableName(value ="team_leader")
@Data
public class TeamLeader implements Serializable {
    /**
     *
     */
    @TableId
    private Integer teamLeaderId;

    /**
     *
     */
    private Integer teamAssignId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
