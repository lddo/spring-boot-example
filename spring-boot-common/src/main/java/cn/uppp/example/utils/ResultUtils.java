package cn.uppp.example.utils;

import cn.uppp.example.common.Result;
import cn.uppp.example.common.ResultCode;

import java.util.Arrays;

/**
 * 返回结果工具类
 */
public class ResultUtils {

    /**
     * 预期返回结果
     */
    private static final int EXPECT_RESULT = 1;

    /**
     * 任何失败返回
     * @param results
     * @return
     */
    public static Result matchFailure(int... results){
        return matchFailure(ResultCode.REQUEST_ERROR, results);
    }

    /**
     * 任何失败返回
     * @param resultCode 指定错误代码
     * @param results
     * @return
     */
    public static Result matchFailure(ResultCode resultCode, int... results){
        return Arrays.stream(results).anyMatch(result -> result != EXPECT_RESULT) ? Result.failure(resultCode) : Result.success();
    }
}
