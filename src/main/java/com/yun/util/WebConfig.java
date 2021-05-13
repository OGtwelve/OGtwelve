package com.yun.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 全局配置类 --配置跨域请求
@Configuration   /*注解说明全局配置类*/
public class WebConfig implements WebMvcConfigurer {
    /*
        1.  域访问路径
        2.  请求来源
        3.  方法
        4.  允许携带数据
        5.  最大时间
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
