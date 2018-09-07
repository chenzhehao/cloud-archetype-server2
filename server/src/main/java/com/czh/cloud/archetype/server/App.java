package com.czh.cloud.archetype.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.czh.cloud")
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.czh.cloud")
@MapperScan("com.czh.cloud.archetype.server.mapper")
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            System.setProperty("log.path", "D:/chenzhehao/workspace/czh");
        } else {
            System.setProperty("log.path", "/opt");
        }
        System.setProperty("context.name", "cloud-archetype-server2-server");

        SpringApplication.run(App.class, args);
    }
}