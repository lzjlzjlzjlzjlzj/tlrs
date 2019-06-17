package com.example.user.controllor;

import com.example.user.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SendMessageController {
    @Autowired
    MessageService m;
    public void sendSystem(String userid){
        m.sendSystem("您好，欢迎使用图旅人生，在这里我们将为你开启全新的人生",userid);
    }
}
