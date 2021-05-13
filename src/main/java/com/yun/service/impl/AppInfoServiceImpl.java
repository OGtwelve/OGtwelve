package com.yun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.dao.BackUserdao;
import com.yun.dao.DevUserDao;
import com.yun.pojo.appInfo;
import com.yun.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AppService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private DevUserDao devUserDao;

    @Autowired
    private BackUserdao backUserdao;

    public BackUserdao getBackUserdao() {
        return backUserdao;
    }

    public void setBackUserdao(BackUserdao backUserdao) {
        this.backUserdao = backUserdao;
    }

    public DevUserDao getDevUserDao() {
        return devUserDao;
    }

    public void setDevUserDao(DevUserDao devUserDao) {
        this.devUserDao = devUserDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<appInfo> getPage(int index, int size, int id) {
        PageInfo pageInfo=null;
        PageHelper.startPage(index,size);
        List<appInfo> List=devUserDao.getApp(id);
        pageInfo = new PageInfo(List);
        return pageInfo;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<appInfo> getPage(int index, int size) {
        PageInfo pageInfo=null;
        PageHelper.startPage(index,size);
        List<appInfo> List=backUserdao.getAllApp();
        pageInfo = new PageInfo(List);
        return pageInfo;
    }
}
