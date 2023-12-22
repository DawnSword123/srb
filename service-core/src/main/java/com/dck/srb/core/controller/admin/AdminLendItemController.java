package com.dck.srb.core.controller.admin;

import com.dck.common.result.Result;
import com.dck.srb.core.pojo.entity.LendItem;
import com.dck.srb.core.service.LendItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Dawn.yang
 * @date 2023/12/22 11:27
 */
@Api(tags = "标的投资管理")
@RestController
//@Slf4j
@RequestMapping("/admin/core/lendItem")
public class AdminLendItemController {
    @Resource
    private LendItemService lendItemService;

    @ApiOperation("获取列表")
    @GetMapping("/list/{lendId}")
    public Result list(
            @ApiParam(value = "标的id", required = true)
            @PathVariable Long lendId) {
        List<LendItem> list = lendItemService.selectByLendId(lendId);
        return Result.ok().data("list", list);
    }


}
