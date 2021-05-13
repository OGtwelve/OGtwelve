package com.yun.dao;

import com.yun.pojo.appInfo;
import com.yun.pojo.appversion;
import org.springframework.stereotype.Repository;

@Repository  //版本
public interface appVersionDao {

    //添加版本
    Boolean addVer(appversion appversion);

    //查询单个版本信息
    appversion getOnetVer(Integer id);

    //修改版本
    Boolean UpdVerId(appversion appversion);

    //删除版本
    Boolean DelVerId(Integer id);
}
