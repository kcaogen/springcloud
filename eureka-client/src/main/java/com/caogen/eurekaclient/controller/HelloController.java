package com.caogen.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String sayHello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        return "Hello,World! port:" + instance.getPort();
    }

}
