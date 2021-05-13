package com.yun.dao;

import com.yun.pojo.appInfo;
import com.yun.pojo.appcategory;
import com.yun.pojo.dictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface appdao {
    //查询App详情
    appInfo getAppId(int id);

    //新增App
    Boolean addApp(appInfo appInfo);

    //修改App信息
    Boolean UpdAppId(appInfo appInfo);

    //有版本信息的删除(两表删除)
    Boolean delAppVer(Integer id);

    //无版本信息的删除
    Boolean delApp(Integer id);

    //查询所有(用于添加版本的下拉框)
    List<appInfo> getAll(Integer devId);

    //查询上架下架
    List<dictionary> getName();

    //查询上架下架（管理员）
    List<dictionary> getNameAll();



}
