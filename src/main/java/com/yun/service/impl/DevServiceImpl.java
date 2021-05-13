package com.yun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.dao.DevUserDao;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import com.yun.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("DevService")
@Transactional
public class DevServiceImpl implements DevService {

    @Autowired
    private DevUserDao devUserDao;

    public DevUserDao getDevUserDao() {
        return devUserDao;
    }

    public void setDevUserDao(DevUserDao devUserDao) {
        this.devUserDao = devUserDao;
    }

    @Override
    public PageInfo<DevUser> getPage(int index, int size) {
        PageInfo pageInfo=null;
        PageHelper.startPage(index,size);
        List<DevUser> List=devUserDao.getAppAll();
        pageInfo = new PageInfo(List);
        return pageInfo;
    }
}
