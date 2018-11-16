package com.hz.springboot.business.config;

import com.hz.springboot.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: huangzhuo
 * @Date: 2018/11/15 17:13
 * @Description:
 */

@Configuration
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePattens = new ArrayList<>();
        excludePattens.add("/js/**");
        excludePattens.add("/images/**");
        excludePattens.add("/css/**");
//        excludePattens.add("/");
        excludePattens.add("/login/**");
        excludePattens.add("/menu/**");
        excludePattens.add("/templates/**");
        excludePattens.add("/jsp/**");


//        registry.addInterceptor(new LocaleChangeInterceptor());
//        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePattens);
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns(excludePattens);
    }
}