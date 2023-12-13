package com.dck.srb.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Dawn.yang
 * @date 2023/12/6 14:48
 */
@EnableFeignClients
@SpringBootApplication
@ComponentScan({"com.dck.srb", "com.dck.common"})
public class ServiceSmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSmsApplication.class,args);
    }
}
