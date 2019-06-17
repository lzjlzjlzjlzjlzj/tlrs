package com.example.user.service;
import com.example.user.WebSocketServer.WebSocketServer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    WebSocketServer w;
    //发送系统信息
    public void  sendSystem(Object message,String userid){
        ObjectMapper o=new ObjectMapper();
        Map m=new HashMap();
        m.put("from","System");
        m.put("message",message);
        WebSocketServer newW=w.getWebSocketServer(userid);
        try {
            System.out.println("w: "+w);
            newW.sendMessage(o.writeValueAsString(m));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
}
