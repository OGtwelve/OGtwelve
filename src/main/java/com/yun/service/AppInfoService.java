package com.yun.service;

import com.github.pagehelper.PageInfo;
import com.yun.pojo.appInfo;

public interface AppInfoService {

    //分页
    PageInfo<appInfo> getPage(int index, int size,int id);

    //管理员分页不带条件
    PageInfo<appInfo> getPage(int index, int size);
}
