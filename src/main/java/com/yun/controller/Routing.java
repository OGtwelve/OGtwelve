package com.yun.controller;

import com.yun.dao.appcatedao;
import com.yun.dao.appdao;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import com.yun.pojo.appcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Routing {
    @Autowired
    appcatedao appcatedao;

    @Autowired
    appdao appdao;



    //管理员登录
    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.html";
    }

    //开发者登录
    @RequestMapping("/login2")
    public String login2(){
        return "redirect:/login2.html";
    }

    //欢迎页面
    @RequestMapping("/welcome")
    public String welcome(){
        return "redirect:/welcome.html";
    }

    //App管理页面（管理员）
    @RequestMapping("/menu1")
    public String menu1(){
        return "redirect:/menu1.html";
    }

    //App管理页面
    @RequestMapping("/menu2")
    public String menu2(){
        return "redirect:/menu2.html";
    }



    //添加页面,进去传入下拉列表框的值
    @RequestMapping("/menuadd2")
    public String menuadd2(Model model){
        List<appcategory> one = appcatedao.getOne();
        model.addAttribute("one", one);
        List<appcategory> two = appcatedao.getTwo();
        model.addAttribute("two", two);
        List<appcategory> three = appcatedao.getThree();
        model.addAttribute("three", three);
            return "index/menu-add2";
    }

    //注册页面
    @RequestMapping("/register")
    public String register(){
        return "redirect:/register.html";
    }

    //App查看详情页面
    @RequestMapping("/Appview")
    public String Appview(){
        return "redirect:/register.html";
    }

    //App版本信息添加页面
    @RequestMapping("/version2")
    public String version2(Model model, HttpSession session){
        DevUser user = (DevUser) session.getAttribute("loginDevUser");
        int id = user.getId();
        List<appInfo> all = appdao.getAll(id);
        model.addAttribute("all",all);
        return "index/menu-version2";
    }

    //个人信息页面(管理员)
    @RequestMapping("/admin-infoDev1")
    public String adminInfoDev(){
        return "redirect:/admin-Info1.html";
    }


    //个人信息页面(技术员)
    @RequestMapping("/admin-infoDev2")
    public String adminInfoDev2(){
        return "redirect:/admin-Info2.html";
    }

    //用户管理跳转页面
    @RequestMapping("/user")
    public String user(){
        return "redirect:/user.html";
    }

    @RequestMapping("/userBack")
    public String userBack(){
        return "redirect:/userBack.html";
    }

    @RequestMapping("/userDev")
    public String userDev(){
        return "redirect:/userDev.html";
    }

    @RequestMapping("/indexRegisters")
    public String registers(){
        return "redirect:/indexRegisters.html";
    }


    //管理员注册
    @RequestMapping("/registersBack")
    public String registerBack(){
        return "redirect:/registersBack.html";
    }

    //技术人员注册
    @RequestMapping("/registersDev")
    public String registersDev(){
        return "redirect:/registersDev.html";
    }


}
