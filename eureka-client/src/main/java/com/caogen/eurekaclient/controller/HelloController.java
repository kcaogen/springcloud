package com.caogen.eurekaclient.controller;

import com.caogen.eurekaclient.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String sayHello() {
        ServiceInstance instance = client.getLocalServiceInstance();

        //让处理线程等待几秒,由于Hystrix默认超时时间为2000毫秒，
        // 所以这里采用0至3000的随机数让处理过程有一定概率发生超时来触发断路器
        try {
            int sleepTime = new Random().nextInt(3000);
            logger.info("sleepTime:" + sleepTime);
            Thread.sleep(sleepTime);
        }catch (Exception e) {
            logger.error("sayHello: " + e);
            e.printStackTrace();
        }

        return "Hello,World! port:" + instance.getPort();
    }

    @GetMapping(value = "/hello1")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping(value = "/hello3")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", age " + user.getAge();
    }

}
