package com.yun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.dao.appcatedao;
import com.yun.pojo.appversion;
import com.yun.service.AppcateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AppcateService")
@Transactional
public class AppcateServiceImpl implements AppcateService {
    @Autowired
    private appcatedao appcatedao;

    public com.yun.dao.appcatedao getAppcatedao() {
        return appcatedao;
    }

    public void setAppcatedao(com.yun.dao.appcatedao appcatedao) {
        this.appcatedao = appcatedao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageInfo<appversion> getPage(int index, int size, int id) {
        PageInfo pageInfo=null;
        PageHelper.startPage(index,size);
        List<appversion> List=appcatedao.getAppVer(id);
        pageInfo = new PageInfo(List);
        return pageInfo;
    }
}
