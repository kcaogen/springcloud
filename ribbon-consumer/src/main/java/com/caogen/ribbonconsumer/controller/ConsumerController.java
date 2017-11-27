package com.caogen.ribbonconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/ribbon")
    public String helloConsumer() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello", String.class);
    }

}
