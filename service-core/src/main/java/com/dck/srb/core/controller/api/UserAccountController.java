package com.dck.srb.core.controller.api;


import com.alibaba.fastjson.JSON;
import com.dck.common.result.Result;
import com.dck.srb.base.util.JwtUtils;
import com.dck.srb.core.hfb.RequestHelper;
import com.dck.srb.core.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 用户账户 前端控制器
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@RestController
@RequestMapping("/api/core/userAccount")
@Api(tags = "会员账户")
@Slf4j
public class UserAccountController {
    @Resource
    private UserAccountService userAccountService;

    @ApiOperation("充值")
    @PostMapping("/auth/commitCharge/{chargeAmt}")
    public Result commitCharge(
            @ApiParam(value = "充值金额", required = true)
            @PathVariable BigDecimal chargeAmt, HttpServletRequest request) {

        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        String formStr = userAccountService.commitCharge(chargeAmt, userId);
        return Result.ok().data("formStr", formStr);
    }

    @ApiOperation(value = "用户充值异步回调")
    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, Object> paramMap = RequestHelper.switchMap(request.getParameterMap());
        log.info("用户充值异步回调：" + JSON.toJSONString(paramMap));
        //校验签名
        if(RequestHelper.isSignEquals(paramMap)) {
            //充值成功交易
            if("0001".equals(paramMap.get("resultCode"))) {
                return userAccountService.notify(paramMap);
            } else {
                log.info("用户充值异步回调充值失败：" + JSON.toJSONString(paramMap));
                return "success";
            }
        } else {
            log.info("用户充值异步回调签名错误：" + JSON.toJSONString(paramMap));
            return "fail";
        }
    }

    @ApiOperation("查询账户余额")
    @GetMapping("/auth/getAccount")
    public Result getAccount(HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        BigDecimal account = userAccountService.getAccount(userId);
        return Result.ok().data("account", account);
    }

    @ApiOperation("用户提现")
    @PostMapping("/auth/commitWithdraw/{fetchAmt}")
    public Result commitWithdraw(
            @ApiParam(value = "金额", required = true)
            @PathVariable BigDecimal fetchAmt, HttpServletRequest request) {

        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        String formStr = userAccountService.commitWithdraw(fetchAmt, userId);
        return Result.ok().data("formStr", formStr);
    }

    @ApiOperation("用户提现异步回调")
    @PostMapping("/notifyWithdraw")
    public String notifyWithdraw(HttpServletRequest request) {
        Map<String, Object> paramMap = RequestHelper.switchMap(request.getParameterMap());
        log.info("提现异步回调：" + JSON.toJSONString(paramMap));

        //校验签名
        if(RequestHelper.isSignEquals(paramMap)) {
            //提现成功交易
            if("0001".equals(paramMap.get("resultCode"))) {
                userAccountService.notifyWithdraw(paramMap);
            } else {
                log.info("提现异步回调充值失败：" + JSON.toJSONString(paramMap));
                return "fail";
            }
        } else {
            log.info("提现异步回调签名错误：" + JSON.toJSONString(paramMap));
            return "fail";
        }
        return "success";
    }
}

