package com.dck.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dck.srb.core.pojo.bo.TransFlowBO;
import com.dck.srb.core.pojo.entity.TransFlow;

/**
 * <p>
 * 交易流水表 服务类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
public interface TransFlowService extends IService<TransFlow> {

    void saveTransFlow(TransFlowBO transFlowBO);

    boolean isSaveTransFlow(String agentBillNo);
}
