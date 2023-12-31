package com.dck.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dck.srb.core.pojo.entity.UserInfo;
import com.dck.srb.core.pojo.query.UserInfoQuery;
import com.dck.srb.core.pojo.vo.LoginVO;
import com.dck.srb.core.pojo.vo.RegisterVO;
import com.dck.srb.core.pojo.vo.UserIndexVO;
import com.dck.srb.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVO registerVO);

    UserInfoVO login(LoginVO loginVO, String ip);

    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    void lock(Long id, Integer status);

    boolean checkMobile(String mobile);

    UserIndexVO getIndexUserInfo(Long userId);
}
