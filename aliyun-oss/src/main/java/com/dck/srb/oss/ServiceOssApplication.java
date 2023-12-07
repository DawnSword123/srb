package com.dck.srb.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Dawn.yang
 * @date 2023/12/7 11:29
 */
@SpringBootApplication
@ComponentScan({"com.dck.srb","com.dck.common"})
public class ServiceOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOssApplication.class,args);
    }
}
