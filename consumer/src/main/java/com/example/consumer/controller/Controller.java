package com.example.consumer.controller;

import com.example.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    HelloService helloService;
    @RequestMapping("hello")
    String Hello()
    {
        return helloService.Hello();
    }
}
