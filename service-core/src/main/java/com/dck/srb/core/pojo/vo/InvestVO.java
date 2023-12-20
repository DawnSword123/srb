package com.dck.srb.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Dawn.yang
 * @date 2023/12/20 14:44
 */
@Data
@ApiModel(description = "投标信息")
public class InvestVO {
    private Long lendId;

    //投标金额
    private String investAmount;

    //用户id
    private Long investUserId;

    //用户姓名
    private String investName;
}
