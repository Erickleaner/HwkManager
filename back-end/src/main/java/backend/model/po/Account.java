package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer accountId;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
