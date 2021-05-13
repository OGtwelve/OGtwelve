package com.yun.controller;

import com.github.pagehelper.PageInfo;
import com.yun.dao.BackUserdao;
import com.yun.dao.DevUserDao;
import com.yun.pojo.BackUser;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import com.yun.service.BackService;
import com.yun.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class BackUserController {
    @Autowired
    BackUserdao backdao;
    @Autowired
    DevUserDao devDao;
    @Autowired
    BackService backService;

    //管理员登录
    @RequestMapping("/back/login")
    public String backLogin(BackUser backUser, Model model, HttpSession session){
        BackUser us = backdao.getBackUserlogin(backUser.getUserCode(), backUser.getUserPassword());
        if (us!=null){
            session.setAttribute("loginDevUser",us);
            return "redirect:/index.html";
        }else {
            //告诉用户，你登录失败了
            model.addAttribute("msg","用户名或者密码错误！");
            return "/index/login";
        }
    }

    //技术员
    @RequestMapping("/dev/login2")
    public String DevLogin(DevUser devUser, Model model, HttpSession session){
        DevUser us = devDao.getDevUserlogin(devUser.getDevCode(), devUser.getDevPassword());
        if (us!=null){
            session.setAttribute("loginDevUser",us);
            return "redirect:/index.html";
        }else {
            //告诉用户，你登录失败了
            model.addAttribute("msg2","用户名或者密码错误！");
            return "/index/login2";
        }
    }

    //注册
    @RequestMapping("/back/add")
    public String register(BackUser backUser){
        Boolean aBoolean = backdao.addBack(backUser);
        backUser.setCreationDate(new Date());
        if (aBoolean==true){
            return "redirect:/menu2.html";
        }
        return null;
    }

    //退出登录
    @RequestMapping("outLogin")
    public String outLogin(HttpSession httpSession){
        httpSession.setAttribute("loginDevUser",null);
        return "redirect:/login.html";
    }




    //管理人员查询全部
    @RequestMapping("/back/getAllDev")
    @ResponseBody
    public PageInfo getAllBack(String pageNum, HttpSession session){
        //需要优化，会使用分页工具，会使用JSON传输数据
        if (pageNum==null){
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        PageInfo<BackUser> list= backService.getPage(Integer.parseInt(pageNum),2);
        return list;
    }


    //查询单个
    @RequestMapping("/back/userBackUpdateOne")
    public String getOneBack(int id, Model model){
        BackUser backId = backdao.getBackId(id);
        model.addAttribute("back",backId);
        return "index/userBackUpdate";
    }

    //修改
    @RequestMapping("/back/userBackUpdate")
    public String getBackUpd(BackUser backUser){
        Boolean aBoolean = backdao.UpdBackId(backUser);
        if (aBoolean==true){
            return "redirect:/userBack.html";
        }
        return "index/userBackUpdate";
    }

    //删除
    @RequestMapping("/back/delBack/{id}")
    @ResponseBody
    public Boolean getDevUpd(@PathVariable String id){
        return backdao.DelBackId(Integer.parseInt(id));
    }
}

