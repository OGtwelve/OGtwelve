package com.yun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index/login");
        registry.addViewController("/login.html").setViewName("/index/login");
        registry.addViewController("/login2.html").setViewName("/index/login2");
        registry.addViewController("/index.html").setViewName("/index/index");
        //欢迎页
        registry.addViewController("/welcome.html").setViewName("/index/welcome");
        //App页
        registry.addViewController("/menu2.html").setViewName("/index/menu2");
        //App页（管理员）
        registry.addViewController("/menu1.html").setViewName("/index/menu1");
        //添加页
        registry.addViewController("/menuAdd2.html").setViewName("/index/menu-add2.html");
        //注册
        registry.addViewController("/register.html").setViewName("/index/registers.html");
        //App查看详情页
        registry.addViewController("/AppView.html").setViewName("/index/AppView.html");
        //App版本添加页面
        registry.addViewController("/version2.html").setViewName("/index/menu-version2.html");
        //个人信息跳转(管理员)
        registry.addViewController("/admin-Info1.html").setViewName("/index/admin-info.html");
        //个人信息跳转(技术员)
        registry.addViewController("/admin-Info2.html").setViewName("/index/admin-info2.html");
        //用户管理(跳转页)
        registry.addViewController("/user.html").setViewName("/index/user.html");
        //用户管理(技术员)
        registry.addViewController("/userDev.html").setViewName("/index/userDev.html");
        //用户管理(管理员)
        registry.addViewController("/userBack.html").setViewName("/index/userBack.html");
        //注册(跳转页)
        registry.addViewController("/indexRegisters.html").setViewName("/index/indexRegisters.html");
        //管理员注册
        registry.addViewController("/registersBack.html").setViewName("/index/registers.html");
        //技术人员注册
        registry.addViewController("/registersDev.html").setViewName("/index/registersDev.html");
    }
}
