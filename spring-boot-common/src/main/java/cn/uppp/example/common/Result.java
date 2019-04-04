package cn.uppp.example.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 * @Param T
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static Result success(){
        return success(ResultCode.SUCCESS, null);
    }

    public static <T> Result success(T data){
        return success(ResultCode.SUCCESS, data);
    }

    private static <T> Result success(ResultCode resultCode, T data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static <T> Result failure(ResultCode resultCode) {
        return failure(resultCode, null);
    }

    public static <T> Result failure(ResultCode resultCode, T data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }


    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
