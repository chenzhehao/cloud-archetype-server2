package com.czh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@EnableScheduling//增加支持定时任务的注解
@SpringBootApplication(scanBasePackages = "com.czh.springcloud")
@MapperScan("com.czh.springcloud.server.mapper")
@EnableDiscoveryClient
@EnableFeignClients
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