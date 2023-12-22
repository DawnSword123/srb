package com.dck.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dck.srb.core.mapper.LendItemReturnMapper;
import com.dck.srb.core.pojo.entity.LendItemReturn;
import com.dck.srb.core.service.LendItemReturnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标的出借回款记录表 服务实现类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@Service
public class LendItemReturnServiceImpl extends ServiceImpl<LendItemReturnMapper, LendItemReturn> implements LendItemReturnService {

    @Override
    public List<LendItemReturn> selectByLendId(Long lendId, Long userId) {
        QueryWrapper<LendItemReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_id", lendId);
        queryWrapper.eq("invest_user_id", userId)
                .orderByAsc("current_period");
        List<LendItemReturn> lendItemReturns = baseMapper.selectList(queryWrapper);
        return lendItemReturns;
    }
}
