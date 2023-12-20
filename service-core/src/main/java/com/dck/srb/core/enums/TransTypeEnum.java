package com.dck.srb.core.enums;

import lombok.AllArgsConstructor;

/**
 * @author Dawn.yang
 * @date 2023/12/19 15:56
 */
@AllArgsConstructor
//@Getter
public enum TransTypeEnum {
    RECHARGE(1,"充值"),
    INVEST_LOCK(2,"投标锁定"),
    INVEST_UNLOCK(3,"放款解锁"),
    CANCEL_LEND(4,"撤标"),
    BORROW_BACK(5,"放款到账"),
    RETURN_DOWN(6,"还款扣减"),
    INVEST_BACK(7,"出借回款"),
    WITHDRAW(8,"提现"),
    ;

    private Integer transType ;
    private String transTypeName;

    public Integer getTransType() {
        return transType;
    }

    public String getTransTypeName() {
        return transTypeName;
    }

    public static String getTransTypeName(int transType) {
        for (TransTypeEnum obj : TransTypeEnum.values()) {
            if (transType == obj.getTransType().intValue()) {
                return obj.getTransTypeName();
            }
        }
        return "";
    }

}

