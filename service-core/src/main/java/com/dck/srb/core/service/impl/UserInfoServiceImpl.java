package com.dck.srb.core.service.impl;

import com.dck.srb.core.pojo.entity.UserInfo;
import com.dck.srb.core.mapper.UserInfoMapper;
import com.dck.srb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
