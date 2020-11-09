package com.wyh.springbootmybatisdemo.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//后续版本不更新
//全局配置类-配置跨域请求
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {




//       访问路径  访问任何东西都允许跨域
        registry.addMapping("/**")
//                添加跨域请求来源; 注释掉是因为要在局域网内前后端分离，允许所有跨域请求来源
//                .allowedOrigins("http://172.17.0.117:8080", "null")

//                允许跨域的方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                最多响应时间
                .maxAge(3600)
//                是否允许携带信息
                .allowCredentials(true);
    }

}
