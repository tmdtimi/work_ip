package com.ai.snmpvisual;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ai.snmpvisual.repository.mapper")
@EnableDiscoveryClient
public class SnmpVisualApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnmpVisualApplication.class, args);
    }

}
