package com.yun.dao;

import com.yun.pojo.appInfo;
import com.yun.pojo.appcategory;
import com.yun.pojo.appversion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository   //分类表
public interface appcatedao {
    //查看App历史版本
    List<appversion> getAppVer(int id);

    //一级分类
    List<appcategory> getOne();

    //二级分类
    List<appcategory> getTwo();

    //三级分类
    List<appcategory> getThree();
}
