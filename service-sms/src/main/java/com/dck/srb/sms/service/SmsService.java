package com.dck.srb.sms.service;

import java.util.Map;

/**
 * @author Dawn.yang
 * @date 2023/12/6 15:10
 */
public interface SmsService {
    void send(String mobile, String templateCode, Map<String,Object> param);
}
