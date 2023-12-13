package com.dck.srb.core.controller.admin;

import com.dck.common.result.Result;
import com.dck.srb.core.pojo.entity.UserLoginRecord;
import com.dck.srb.core.service.UserLoginRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Dawn.yang
 * @date 2023/12/13 10:48
 */
@Api(tags = "会员登录日志接口")
@RestController
@RequestMapping("/admin/core/userLoginRecord")
@Slf4j
@CrossOrigin(methods = {RequestMethod.OPTIONS,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class AdminUserLoginRecordController {

    @Resource
    private UserLoginRecordService userLoginRecordService;

    @ApiOperation("获取会员登录日志列表")
    @GetMapping("/listTop50/{userId}")
    public Result listTop50(
            @ApiParam(value = "用户id", required = true)
            @PathVariable Long userId) {
        List<UserLoginRecord> userLoginRecordList = userLoginRecordService.listTop50(userId);
        return Result.ok().data("list", userLoginRecordList);
    }
}
