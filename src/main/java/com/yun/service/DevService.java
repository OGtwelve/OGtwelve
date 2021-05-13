package com.yun.service;


import com.github.pagehelper.PageInfo;
import com.yun.pojo.DevUser;

//Dev
public interface DevService {
    //分页
    PageInfo<DevUser> getPage(int index, int size);
}
