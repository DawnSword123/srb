package com.dck.srb.core.controller.api;


import com.dck.common.exception.Assert;
import com.dck.common.result.ResponseEnum;
import com.dck.common.result.Result;
import com.dck.common.util.RegexValidateUtils;
import com.dck.srb.base.util.JwtUtils;
import com.dck.srb.core.pojo.vo.LoginVO;
import com.dck.srb.core.pojo.vo.RegisterVO;
import com.dck.srb.core.pojo.vo.UserIndexVO;
import com.dck.srb.core.pojo.vo.UserInfoVO;
import com.dck.srb.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@Api(tags = "会员接口")
@RestController
@RequestMapping("/api/core/userInfo")
@Slf4j
//@CrossOrigin(methods = {RequestMethod.OPTIONS,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("会员注册")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterVO registerVO){

        String mobile = registerVO.getMobile();
        String password = registerVO.getPassword();
        String code = registerVO.getCode();

        //MOBILE_NULL_ERROR(-202, "手机号不能为空"),
        Assert.notEmpty(mobile, ResponseEnum.MOBILE_NULL_ERROR);
        //MOBILE_ERROR(-203, "手机号不正确"),
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile), ResponseEnum.MOBILE_ERROR);
        //PASSWORD_NULL_ERROR(-204, "密码不能为空"),
        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
        //CODE_NULL_ERROR(-205, "验证码不能为空"),
        Assert.notEmpty(code, ResponseEnum.CODE_NULL_ERROR);

        //校验验证码
        String codeGen = (String)redisTemplate.opsForValue().get("srb:sms:code:" + mobile);
        //CODE_ERROR(-206, "验证码不正确"),
        Assert.equals(code, codeGen, ResponseEnum.CODE_ERROR);

        //注册
        userInfoService.register(registerVO);
        return Result.ok().message("注册成功");
    }


    @ApiOperation("会员登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVO loginVO, HttpServletRequest request) {
        String mobile = loginVO.getMobile();
        String password = loginVO.getPassword();
        Assert.notEmpty(mobile, ResponseEnum.MOBILE_NULL_ERROR);
        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);

        String ip = request.getRemoteAddr();
        UserInfoVO userInfoVO = userInfoService.login(loginVO, ip);

        return Result.ok().data("userInfo", userInfoVO);
    }

    @ApiOperation("校验令牌")
    @GetMapping("/checkToken")
    public Result checkToken(HttpServletRequest request) {

        String token = request.getHeader("token");
        boolean result = JwtUtils.checkToken(token);

        if(result){
            return Result.ok();
        }else{
            //LOGIN_AUTH_ERROR(-211, "未登录"),
            return Result.setResult(ResponseEnum.LOGIN_AUTH_ERROR);
        }
    }

    @ApiOperation("校验手机号是否注册")
    @GetMapping("/checkMobile/{mobile}")
    public boolean checkMobile(@PathVariable String mobile){
        return userInfoService.checkMobile(mobile);
    }

    @ApiOperation("获取个人空间用户信息")
    @GetMapping("/auth/getIndexUserInfo")
    public Result getIndexUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        UserIndexVO userIndexVO = userInfoService.getIndexUserInfo(userId);
        return Result.ok().data("userIndexVO", userIndexVO);
    }
}

