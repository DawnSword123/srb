package com.dck.srb.core.service.impl;

import com.dck.srb.core.pojo.entity.UserAccount;
import com.dck.srb.core.mapper.UserAccountMapper;
import com.dck.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
