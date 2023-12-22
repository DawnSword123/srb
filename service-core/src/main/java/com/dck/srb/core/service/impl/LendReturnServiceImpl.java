package com.dck.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dck.srb.core.pojo.entity.LendReturn;
import com.dck.srb.core.mapper.LendReturnMapper;
import com.dck.srb.core.service.LendReturnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 还款记录表 服务实现类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@Service
public class LendReturnServiceImpl extends ServiceImpl<LendReturnMapper, LendReturn> implements LendReturnService {

    @Override
    public List<LendReturn> selectByLendId(Long lendId) {
        QueryWrapper<LendReturn> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("lend_id",lendId);
        List<LendReturn> lendReturns = baseMapper.selectList(queryWrapper);
        return lendReturns;
    }
}
