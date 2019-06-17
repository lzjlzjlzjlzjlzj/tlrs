package com.example.user.controllor;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.user.service.MessageService;
import com.example.user.service.Userservice;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    Userservice u;
    @Autowired
    MessageService messageService;
    @RequestMapping("hello")
    String hello(){
        return "hello";
    }
    //登录验证
    @RequestMapping("findzh")
    Map FindZh(String name,String pwd){
        Map i=u.FindZh(name);
        Map m=new HashMap();
        if(i==null){
            m.put("code","账号不存在");
            return m;
        }else{
            if(i.get("pwd").equals(pwd)) {
                return i;
            }else{
                m.put("code","密码不正确");
                return m;
            }
        }
    }

    //分页查询未浏览的所有图事
    @RequestMapping("findcallery")
    Object FindCallery(int userid,int page){
        System.out.println(page);
        String s=""+userid+"";
        messageService.sendSystem("您好，欢迎使用图旅人生，在这里我们将为你开启全新的人生",s);
        return u.FindCallery(userid,page);
    }

    //点赞
    @RequestMapping("dz")
    void Dz(int userid,int calleryid,String time){
        System.out.println(userid);
        Map m=new HashMap();
        m.put("userid",userid);
        m.put("calleryid",calleryid);
        m.put("time",time);
        u.Dz(m);
    }
    //加载个人用户信息
    @RequestMapping("userinfo")
    Map UserInfo(int userid){
        return u.UserInfo(userid);
    }

    //搜索账号
    @RequestMapping("serachzh")
    Map SerachZh(String zh){
        System.out.println(zh+"账号");
        return u.SerachZh(zh);
    }

    //支付功能
    @RequestMapping("alipay")
    String Alipay(){
        return null;
    }
}
