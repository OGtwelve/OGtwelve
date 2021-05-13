package com.yun.service;

import com.github.pagehelper.PageInfo;
import com.yun.pojo.appversion;

public interface AppcateService {

    //分页
    PageInfo<appversion> getPage(int index, int size, int id);
}
