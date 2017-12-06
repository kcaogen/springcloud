package com.caogen.feignconsumer.service;

import com.caogen.feignconsumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "eureka-client", fallback = ConsumerServiceFallback.class)   //通过@FeignClient注解指定服务名来绑定服务
public interface ConsumerService {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})   //绑定方法
    String hello();

    @RequestMapping(value = "/hello1", method = {RequestMethod.GET})
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = {RequestMethod.GET})
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = {RequestMethod.POST})
    String hello(@RequestBody User user);

}
