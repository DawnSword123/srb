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
    BAD_SQL_GRAMMAR_ERROR(504,"sql语法异常"),
    BORROW_AMOUNT_NULL_ERROR(201,"借用金额为空"),
    SERVLET_ERROR(102,"servlet请求异常"),
    ;

    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;
}
