package com.yun.controller;


import com.github.pagehelper.PageInfo;
import com.yun.dao.DevUserDao;
import com.yun.pojo.DevUser;
import com.yun.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("Dev")
public class DevUserController {
    @Autowired
    DevService devService;
    @Autowired
    DevUserDao devUserDao;

    //技术员人员管理查询全部
    @RequestMapping("/getAllDev")
    @ResponseBody
    public PageInfo getAllDev(String pageNum, HttpSession session){
        //需要优化，会使用分页工具，会使用JSON传输数据
        if (pageNum==null){
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        PageInfo<DevUser> list= devService.getPage(Integer.parseInt(pageNum),2);
        return list;
    }

    //查询单个
    @RequestMapping("/userDevUpdateOne")
    public String getOneDev(int id, Model model){
        DevUser devId = devUserDao.getDevId(id);
        model.addAttribute("dev",devId);
        return "index/userDevUpdate";
    }

    //修改
    @RequestMapping("/userDevUpdate")
    public String getDevUpd(DevUser devUser){
        Boolean aBoolean = devUserDao.UpdDevId(devUser);
        if (aBoolean==true){
            return "redirect:/userDev.html";
        }
        return "index/userDevUpdate";
    }

    //删除
    @RequestMapping("/delDev/{id}")
    @ResponseBody
    public Boolean getDevUpd(@PathVariable String id){
        return devUserDao.DelDevId(Integer.parseInt(id));
    }

    //添加
    @RequestMapping("/userDevAdd")
    public String userDevAdd(DevUser devUser){
        Boolean aBoolean = devUserDao.AddDev(devUser);
        if (aBoolean==true){
            return "redirect:/userDev.html";
        }
        return "false";
    }
}
