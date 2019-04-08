package cn.uppp.example.handler;

import cn.uppp.example.common.Result;
import cn.uppp.example.common.ResultCode;
import cn.uppp.example.exception.AppException;
import cn.uppp.example.exception.UtilsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 兜底未知异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exception(){
        return Result.failure(ResultCode.UNKNOWN_ERROR);
    }

    /**
     * 应用异常
     * @return
     */
    @ExceptionHandler(AppException.class)
    public Result appException(){
        return Result.failure(ResultCode.APP_ERROR);
    }

    /**
     * 工具类异常
     * @return
     */
    @ExceptionHandler(UtilsException.class)
    public Result utilsException(){
        return Result.failure(ResultCode.APP_UTILS_ERROR);
    }
}
