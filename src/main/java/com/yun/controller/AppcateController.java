package com.yun.controller;

import com.github.pagehelper.PageInfo;
import com.yun.pojo.DevUser;
import com.yun.dao.appcatedao;
import com.yun.pojo.appversion;
import com.yun.service.AppcateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Cate")
public class AppcateController {
    @Autowired
    AppcateService appcateService;
    @Autowired
    appcatedao appcatedao;

    //App分页
    @RequestMapping("/getPageVer")
    @ResponseBody
    public PageInfo getPage(String pageNum, HttpSession session){
        int Appid = (int) session.getAttribute("Appid");
        //需要优化，会使用分页工具，会使用JSON传输数据
        if (pageNum==null){
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        PageInfo<appversion> list= appcateService.getPage(Integer.parseInt(pageNum),1,Appid);
        return list;
    }
}
