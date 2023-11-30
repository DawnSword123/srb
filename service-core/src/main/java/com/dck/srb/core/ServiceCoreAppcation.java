package com.dck.srb.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
*
*@author Dawn.yang
*@date 2023/11/29 13:54
*
*/
@SpringBootApplication
@ComponentScan({"com.dck.srb", "com.dck.common"})
public class ServiceCoreAppcation {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCoreAppcation.class);
    }
}
