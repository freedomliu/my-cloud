package com.bedrock.myserver.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: Administrator
 * @Date: 2019/12/12 20:23
 * @Description:
 */
@FeignClient("my-server")
public interface HelloService {

    @GetMapping("hello1")
    String hello();
}
