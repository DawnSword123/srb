package com.dck.srb.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dawn.yang
 * @date 2023/12/18 15:10
 */
@Getter
@AllArgsConstructor
public enum BorrowInfoStatusEnum {
    NO_AUTH(0, "未提交"),
    CHECK_RUN(1, "审核中"),
    CHECK_OK(2, "审核通过"),
    CHECK_FAIL(-1, "审核不通过"),
            ;
    private Integer status;
    private String msg;

    public static String getMsgByStatus(Integer status) {
        BorrowInfoStatusEnum arrObj[] = BorrowInfoStatusEnum.values();
        for (BorrowInfoStatusEnum obj : arrObj) {
            if (status == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }
}
