package com.dck.srb.core.controller;

import com.dck.srb.core.pojo.entity.IntegralGrade;
import com.dck.srb.core.service.IntegralGradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Dawn.yang
 * @date 2023/11/29 16:43
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {
    @Resource
    private IntegralGradeService integralGradeService;

    @GetMapping("/list")
    public List<IntegralGrade> listAll(){
        return integralGradeService.list();
    }

    @DeleteMapping("/remove/{id}")
    public boolean removeById(@PathVariable Long id){
        return integralGradeService.removeById(id);
    }
}
