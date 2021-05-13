package com.yun.controller;

import com.github.pagehelper.PageInfo;
import com.yun.dao.appcatedao;
import com.yun.dao.appdao;
import com.yun.pojo.DevUser;
import com.yun.pojo.appInfo;
import com.yun.pojo.appcategory;
import com.yun.pojo.dictionary;
import com.yun.service.AppInfoService;
import com.yun.service.AppcateService;
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
@RequestMapping("App")
public class AppInfoController {
    @Autowired
    AppInfoService AppSer;
    @Autowired
    appdao appdao;
    @Autowired
    AppcateService appcateService;
    @Autowired
    appcatedao appcatedao;




    //App分页
    @RequestMapping("/getPage")
    @ResponseBody
    public PageInfo getPage(String pageNum, HttpSession session){
        DevUser user = (DevUser) session.getAttribute("loginDevUser");
        int id = user.getId();
        //需要优化，会使用分页工具，会使用JSON传输数据
        if (pageNum==null){
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        PageInfo<appInfo> list= AppSer.getPage(Integer.parseInt(pageNum),2,id);
        return list;
    }


    //管理员分页
    @RequestMapping("/getPage2")
    @ResponseBody
    public PageInfo getPage2(String pageNum, HttpSession session){
        //需要优化，会使用分页工具，会使用JSON传输数据
        if (pageNum==null){
            pageNum = "1";
        }
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        PageInfo<appInfo> list= AppSer.getPage(Integer.parseInt(pageNum),2);
        return list;
    }


    //查看详情
    @RequestMapping("/AppView")
    public String AppView(int id, Model model,HttpSession session){
        session.setAttribute("Appid",id);
        appInfo appId = appdao.getAppId(id);
        List<appcategory> one = appcatedao.getOne();
        model.addAttribute("one", one);
        List<appcategory> two = appcatedao.getTwo();
        model.addAttribute("two", two);
        List<appcategory> three = appcatedao.getThree();
        model.addAttribute("three", three);

        if (appId!=null){
            model.addAttribute("app",appId);
            return "index/AppView";
        }
        return null;
    }

    //添加App
    @RequestMapping("/AppAdd")
    public String AppAdd(appInfo appInfo,HttpSession session){
        DevUser loginDevUser = (DevUser) session.getAttribute("loginDevUser");
        appInfo.setDevId(loginDevUser.getId());
        appInfo.setStatus(1);
        appInfo.setCreationDate(new Date());
        Boolean aBoolean = appdao.addApp(appInfo);
        return "redirect:/menu2.html";
    }

    //修改查询单个 并获取级联分类
    @RequestMapping("/AppGetOne")
    public String AppGetOne(int id, Model model){
        List<appcategory> one = appcatedao.getOne();
        model.addAttribute("one", one);
        List<appcategory> two = appcatedao.getTwo();
        model.addAttribute("two", two);
        List<appcategory> three = appcatedao.getThree();
        model.addAttribute("three", three);

        appInfo appId = appdao.getAppId(id);
        model.addAttribute("app",appId);

        List<dictionary> name = appdao.getName();
        model.addAttribute("name",name);
        return "index/menu-update2";
    }

    //修改App信息
    @RequestMapping("/AppUpd")
    public String AppUpd(appInfo appInfo,HttpSession session){
        appInfo.setModifyDate(new Date());
        Boolean aBoolean = appdao.UpdAppId(appInfo);
        if (aBoolean==true){
            return "redirect:/menu2.html";
        }
        return "index/menu-update2";
    }


    //删除App信息
    @RequestMapping("/del/{id}/{versionId}")
    @ResponseBody
    public Boolean AppDel(@PathVariable String id,@PathVariable String versionId){
        int Vid = Integer.parseInt(versionId);
        System.out.println("测试versionId:++++++++++++++"+Vid);
        if (Vid==0){
            Boolean aBoolean = appdao.delApp(Integer.parseInt(id));
            if (aBoolean==true){
                return true;
            }
        }else {
            Boolean aBoolean = appdao.delAppVer(Integer.parseInt(id));
            if (aBoolean==true){
                return true;
            }
        }
        return false;
    }

    //修改查询单个 并获取级联分类(管理员)
    @RequestMapping("/AppGetOne2")
    public String AppGetOne2(int id, Model model){
        List<appcategory> one = appcatedao.getOne();
        model.addAttribute("one", one);
        List<appcategory> two = appcatedao.getTwo();
        model.addAttribute("two", two);
        List<appcategory> three = appcatedao.getThree();
        model.addAttribute("three", three);

        appInfo appId = appdao.getAppId(id);
        model.addAttribute("app",appId);

        List<dictionary> name = appdao.getNameAll();
        model.addAttribute("name",name);
        return "index/menu-update1";
    }

    //修改App信息
    @RequestMapping("/AppUpd2")
    public String AppUpd2(appInfo appInfo,HttpSession session){
        Boolean aBoolean = appdao.UpdAppId(appInfo);
        if (aBoolean==true){
            return "redirect:/menu1.html";
        }
        return "index/menu-update1";
    }

}
