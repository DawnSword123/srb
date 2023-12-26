package com.dck.srb.core.controller.api;

import com.dck.common.result.Result;
import com.dck.srb.base.util.JwtUtils;
import com.dck.srb.core.pojo.entity.TransFlow;
import com.dck.srb.core.service.TransFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dawn.yang
 * @date 2023/12/22 16:59
 */
@Api(tags = "资金记录")
@RestController
@Slf4j
@RequestMapping("/api/core/transFlow")
public class TransFlowController {

    @Resource
    private TransFlowService transFlowService;

    @ApiOperation("获取列表")
    @GetMapping("/list")
    public Result list(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        List<TransFlow> list = transFlowService.selectByUserId(userId);
        return Result.ok().data("list", list);
    }
}
