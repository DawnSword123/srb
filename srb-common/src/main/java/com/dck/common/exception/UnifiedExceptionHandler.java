package com.dck.common.exception;

import com.dck.common.result.ResponseEnum;
import com.dck.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Dawn.yang
 * @date 2023/11/30 15:22
 */
@Slf4j
@Component //Spring容易自动管理
@RestControllerAdvice //在controller层添加通知。如果使用@ControllerAdvice，则方法上需要添加@ResponseBody
public class UnifiedExceptionHandler {

    /**
     * 未定义异常
     */
    @ExceptionHandler(value = Exception.class) //当controller中抛出Exception，则捕获
    public Result handleException(Exception e) {
        log.error("发生异常: "+e.getMessage(), e);
        return Result.error();
    }


    /**
     * 特定异常
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result handleBadSqlGrammarException(BadSqlGrammarException e){
        log.error(e.getMessage(), e);
        return Result.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e){
        log.error(e.getMessage(), e);
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
}