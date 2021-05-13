package com.yun.controller;


import com.yun.dao.appVersionDao;
import com.yun.dao.appdao;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import com.yun.pojo.appversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Ver") //版本
public class AppVerController {

    @Autowired
    appVersionDao appVerDao;
    @Autowired
    appdao appdao;



    //添加App版本信息
    @RequestMapping("/VerAdd")
    public String AppAdd(appversion appversion, HttpSession session){
        DevUser loginDevUser = (DevUser) session.getAttribute("loginDevUser");
        appversion.setPublishStatus(12);
        appversion.setCreateBy(loginDevUser.getId());
        appversion.setCreationDate(new Date());
        Boolean aBoolean = appVerDao.addVer(appversion);
        return "redirect:/menu2.html";
    }

    //查询单个
    @RequestMapping("/VerGetOne")
    public String VerGetOne(int id,HttpSession session, Model model){
        DevUser user = (DevUser) session.getAttribute("loginDevUser");
        int id2 = user.getId();
        List<appInfo> all = appdao.getAll(id2);
        model.addAttribute("all",all);
        appversion onetVer = appVerDao.getOnetVer(id);
        model.addAttribute("ver",onetVer);
        return "index/menu-updateVer2";
    }

    //修改
    @RequestMapping("/VerUpd")
    public String VerUpd(appversion appversion,HttpSession session, Model model){
        appversion.setModifyDate(new Date());
        Boolean aBoolean = appVerDao.UpdVerId(appversion);
        return "redirect:/menu2.html";
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Boolean ProDel(@PathVariable String id){
        return appVerDao.DelVerId(Integer.parseInt(id));
    }

}
