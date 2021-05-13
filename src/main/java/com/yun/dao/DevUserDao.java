package com.yun.dao;

import com.yun.pojo.appInfo;
import com.yun.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevUserDao {
    //开发者登录
    DevUser getDevUserlogin(@Param("devCode")String userCode, @Param("devPassword")String userPassword);

    //App分页查询带条件
    List<appInfo> getApp(int id);

    //开发者人员管理(管理员)
    List<DevUser> getAppAll();

    //查看详情
    DevUser getDevId(int id);

    //修改
    Boolean UpdDevId(DevUser DevUser);

    //删除
    Boolean DelDevId(int id);

    //添加
    Boolean AddDev(DevUser DevUser);
}
