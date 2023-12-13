package com.dck.srb.core.controller.admin;

import com.dck.common.exception.Assert;
import com.dck.common.result.ResponseEnum;
import com.dck.common.result.Result;
import com.dck.srb.core.pojo.entity.IntegralGrade;
import com.dck.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Dawn.yang
 * @date 2023/11/29 16:43
 */
@Api("会员积分")
@RestController
@RequestMapping("/admin/core/integralGrade")
@CrossOrigin(methods = {RequestMethod.OPTIONS,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class AdminIntegralGradeController {
    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("获取列表")
    @GetMapping("/list")
    public Result listAll() {
        return Result.ok().data("list",integralGradeService.list()).message("获取列表成功");
    }

    @ApiOperation("新增积分等级")
    @PostMapping("/save")
    public Result save(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade){
        //如果借款额度为空就手动抛出一个自定义的异常！
//        if(ObjectUtils.isEmpty(integralGrade.getBorrowAmount())){
//            //BORROW_AMOUNT_NULL_ERROR(-201, "借款额度不能为空"),
//            throw new BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
//        }

        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        boolean result = integralGradeService.save(integralGrade);
        if (result) {
            return Result.ok().message("保存成功");
        } else {
            return Result.error().message("保存失败");
        }
    }

    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result removeById(
            @ApiParam(value = "数据id", required = true, example = "1")
            @PathVariable Long id) {
        boolean result = integralGradeService.removeById(id);
        if (result) {
            //return R.setResult(ResponseEnum.UPLOAD_ERROR);
            return Result.ok().message("删除成功");
        } else {
            return Result.error().message("删除失败");
        }
    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("/get/{id}")
    public Result getById(
            @ApiParam(value = "数据id", required = true, example = "1")
            @PathVariable Long id
    ){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        if(integralGrade != null){
            return Result.ok().data("record", integralGrade);
        }else{
            return Result.error().message("数据不存在");
        }
    }

    @ApiOperation("更新积分等级")
    @PutMapping("/update")
    public Result updateById(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade){
        boolean result = integralGradeService.updateById(integralGrade);
        if(result){
            return Result.ok().message("修改成功");
        }else{
            return Result.error().message("修改失败");
        }
    }
}
