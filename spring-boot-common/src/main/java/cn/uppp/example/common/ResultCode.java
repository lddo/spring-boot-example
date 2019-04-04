package cn.uppp.example.common;

import lombok.Getter;

/**
 * 返回结果枚举
 */
@Getter
public enum ResultCode {
    SUCCESS(1, "成功"),

    APP_ERROR(1001, "应用发生错误"),
    APP_CONTROLLER_ERROR(1002, "控制层发生错误"),
    APP_SERVICE_ERROR(1003, "服务层发生错误"),
    APP_DAO_ERROR(1004, "持久层发生错误"),
    APP_UTILS_ERROR(1005, "工具类发生错误"),
    APP_API_ERROR(1006, "调用第三方接口发生错误"),

    REQUEST_ERROR(1101, "请求处理发生错误"),
    REQUEST_ILLEGAL_ARGUMENT(1102, "请求包含非法参数"),
    REQUEST_EXECUTE_ERROR(1103, "请求执行错误"),

    USER_ERROR(1201, "用户认证发生错误"),
    USER_NO_AUTHENTICATION(1202, "用户没有认证"),
    USER_NO_GRANT(1203, "用户没有授权"),
    USER_BAD_CREDENTIAL(1204, "用户名或密码错误"),
    USER_DISABLED(1205, "用户被禁止登陆"),

    TOKEN_ERROR(1301, "令牌发生错误"),
    TOKEN_EXPIRED(1302, "令牌已过期"),
    TOKEN_UNSUPPORTED(1303, "令牌不支持"),
    TOKEN_MALFORMED(1304, "令牌格式不正确"),
    TOKEN_SIGNATURE(1305, "令牌验签失败"),
    TOKEN_ILLEGAL_ARGUMENT(1306, "令牌非法参数"),

    VALIDATE_IS_NULL(1401, "参数为空"),
    VALIDATE_FORMAT_NOT_RIGHT(1401, "格式错误"),
    VALIDATE_TYPE_NOT_RIGHT(1401, "参数为空")
    ;

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
