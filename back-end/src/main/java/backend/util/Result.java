package backend.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class Result<T> implements Serializable {
    /** 返回信息码*/
    private int code;
    /** 返回信息内容*/
    private String msg;

    private T data = null;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp = new Date();

    public Result(){}

    //相应成功
    public static <T> Result<T> success(T data){
        Result result = new Result();
        result.code = ResultConstant.SUCCESS.code;
        result.msg = ResultConstant.SUCCESS.msg;
        result.data = data;
        return result;
    }
    public static Result success(){
        return new Result(ResultConstant.SUCCESS);
    }

    public Result(ResultConstant msg){
        this.code = msg.code;
        this.msg = msg.msg;
    }
}
