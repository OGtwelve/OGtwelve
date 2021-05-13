package com.yun.dao;

import com.yun.pojo.BackUser;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackUserdao {

    //管理员登录
    BackUser getBackUserlogin(@Param("userCode")String userCode, @Param("userPassword")String userPassword);

    //注册
    Boolean addBack(BackUser backUser);


    //App查询全部
    List<appInfo> getAllApp();

    //管理员查询全部
    List<BackUser> getBackAll();

    //查看详情
    BackUser getBackId(int id);

    //修改
    Boolean UpdBackId(BackUser BackUser);

    //删除
    Boolean DelBackId(int id);



}
