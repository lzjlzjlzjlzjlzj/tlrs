package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(defaultFallback = "error")
    public String Hello(){
        return restTemplate.getForObject("http://user/hello",String.class);
    }
    String error(){
        return "该服务正在维修当中";
    }
}
