package com.bedrock.myserver.controller;

import com.bedrock.myserver.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: liuxiangtao90
 * @Date: 2019/12/11 12:26
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public String sayHello(){
        return "this is server02";
    }

    @GetMapping("hello1")
    public void sayHello1(){
        helloService.hello();
    }
}
