package com.bedrock.myserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyServerApplication.class, args);
    }

    @Bean
    @LoadBalanced //这个注解的意思是在启动时先加载注册中心的域名列表
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
