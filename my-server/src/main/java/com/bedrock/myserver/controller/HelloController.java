package com.bedrock.myserver.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxiangtao90
 * @Date: 2019/12/11 12:26
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("hello")
    public void sayHello(){
        List<String> services = new ArrayList<>();
        List<String> serviceNames = discoveryClient.getServices();
        for(String serviceName : serviceNames){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for(ServiceInstance serviceInstance : serviceInstances){
                services.add(String.format("%s:%s",serviceName,serviceInstance.getUri()));
            }
        }
        String body = restTemplate.getForEntity("http://my-server02/hello", String.class).getBody();
        System.out.println(body);
    }
}
