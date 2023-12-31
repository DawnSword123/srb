package com.dck.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Dawn.yang
 * @date 2023/11/30 15:01
 */
@Getter
@AllArgsConstructor
@ToString
public enum  ResponseEnum {
    SUCCESS(0, "成功"),
    ERROR(-1, "服务器内部错误"),
    BAD_SQL_GRAMMAR_ERROR(-504,"sql语法异常"),
    BORROW_AMOUNT_NULL_ERROR(-201,"借用金额为空"),
    SERVLET_ERROR(-102,"servlet请求异常"),
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(-104, "数据导出失败"),
    ALIYUN_RESPONSE_FAIL(-501, "阿里云响应失败"),
    ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),//业务限流
    ALIYUN_SMS_ERROR(-503, "短信发送失败"),//其他失败
    MOBILE_NULL_ERROR(-202, "手机号不能为空"),
    MOBILE_ERROR(-203, "手机号不正确"),
    PASSWORD_NULL_ERROR(-204, "密码不能为空"),
    CODE_NULL_ERROR(-205, "验证码不能为空"),
    CODE_ERROR(-206, "验证码不正确"),
    MOBILE_EXIST_ERROR(-207, "手机号已被注册"),
    LOGIN_MOBILE_ERROR(-208, "用户不存在"),
    LOGIN_PASSWORD_ERROR(-209, "密码不正确"),
    LOGIN_DISABLED_ERROR(-210, "用户已被禁用"),
    LOGIN_AUTH_ERROR(-211, "未登录"),
    USER_BIND_IDCARD_EXIST_ERROR(-301, "身份证号码已绑定"),
    USER_NO_BIND_ERROR(-302,"用户没有绑定异常"),
    USER_NO_AMOUNT_ERROR(-303,"用户认证异常"),
    USER_AMOUNT_LESS_ERROR(-304,"用户借款额度不足"),
    LEND_INVEST_ERROR(-305,"标的状态必须为募资中"),
    LEND_FULL_SCALE_ERROR(-306,"标不可超卖"),
    NOT_SUFFICIENT_FUNDS_ERROR(-307,"当前用户的余额 >= 当前用户的投资金额"),
    NOT_LEND_ERROR(-308,"当前标不存在"),
    ;

    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;
}
