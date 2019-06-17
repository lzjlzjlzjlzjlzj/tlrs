package com.example.user.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface Userservice {
    Map FindZh(String name);
    Map FindCallery(int userid,int page);
    //点赞
    int Dz(Map m);
    //查询用户信息
    Map UserInfo(int userid);
    //根据账号搜索用户信息
    Map SerachZh(String zh);
}
