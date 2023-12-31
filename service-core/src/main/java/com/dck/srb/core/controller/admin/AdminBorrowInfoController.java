package com.dck.srb.core.controller.admin;

import com.dck.common.result.Result;
import com.dck.srb.core.pojo.entity.BorrowInfo;
import com.dck.srb.core.pojo.vo.BorrowInfoApprovalVO;
import com.dck.srb.core.service.BorrowInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Dawn.yang
 * @date 2023/12/18 16:42
 */
@RestController
@Slf4j
@Api(tags = "借款管理")
@RequestMapping("/admin/core/borrowInfo")
public class AdminBorrowInfoController {

    @Resource
    private BorrowInfoService borrowInfoService;

    @ApiOperation("借款信息列表")
    @GetMapping("/list")
    public Result list() {
        List<BorrowInfo> borrowInfoList = borrowInfoService.selectList();
        return Result.ok().data("list", borrowInfoList);
    }

    @ApiOperation("获取借款信息")
    @GetMapping("/show/{id}")
    public Result show(
            @ApiParam(value = "借款id", required = true)
            @PathVariable Long id) {
        Map<String, Object> borrowInfoDetail = borrowInfoService.getBorrowInfoDetail(id);
        return Result.ok().data("borrowInfoDetail", borrowInfoDetail);
    }

    @ApiOperation("审批借款信息")
    @PostMapping("/approval")
    public Result approval(@RequestBody BorrowInfoApprovalVO borrowInfoApprovalVO) {

        borrowInfoService.approval(borrowInfoApprovalVO);
        return Result.ok().message("审批完成");
    }
}
