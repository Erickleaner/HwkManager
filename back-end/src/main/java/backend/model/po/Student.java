package backend.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     *
     */
    @TableId
    private Integer studentId;

    /**
     *
     */
    private Integer clazzId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String no;

    /**
     *
     */
    private Integer grade;

    /**
     *
     */
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
