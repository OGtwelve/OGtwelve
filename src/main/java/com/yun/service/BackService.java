package com.yun.service;

import com.github.pagehelper.PageInfo;
import com.yun.pojo.BackUser;
import com.yun.pojo.DevUser;

public interface BackService {

    //分页
    PageInfo<BackUser> getPage(int index, int size);
}
