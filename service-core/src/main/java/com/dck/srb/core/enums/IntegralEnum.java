package com.dck.srb.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dawn.yang
 * @date 2023/12/18 11:21
 */
@AllArgsConstructor
@Getter
public enum IntegralEnum {
    //    BORROWER_INFO(50, "借款人基本信息"),
    BORROWER_IDCARD(30, "借款人身份证信息"),
    BORROWER_HOUSE(100, "借款人房产信息"),
    BORROWER_CAR(60, "借款人车辆信息"),
    ;

    private Integer integral;
    private String msg;
}
