package com.yun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.dao.BackUserdao;
import com.yun.pojo.BackUser;
import com.yun.pojo.DevUser;
import com.yun.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("BackService")
@Transactional
public class BackServiceImpl implements BackService {

    @Autowired
    BackUserdao backUserdao;

    public BackUserdao getBackUserdao() {
        return backUserdao;
    }

    public void setBackUserdao(BackUserdao backUserdao) {
        this.backUserdao = backUserdao;
    }

    @Override
    public PageInfo<BackUser> getPage(int index, int size) {
        PageInfo pageInfo=null;
        PageHelper.startPage(index,size);
        List<BackUser> List=backUserdao.getBackAll();
        pageInfo = new PageInfo(List);
        return pageInfo;
    }
}
