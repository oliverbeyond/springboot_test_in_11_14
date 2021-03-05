package com.wn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*这个是拦截*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
/*    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.jsp").setViewName("index");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }*/



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("开始拦截!");
        registry.addInterceptor(new loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.jsp", "/register.jsp", "/phoneregister.jsp", "/index2.jsp", "/error.jsp",
                        "/ajaxlogin","/static/**","/admin/login","/autologin","/sendcaptcha","/phoneregister","/register","/quit","/ajaxregister"
                        , "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg","/image/**","/ajaxlogin/**");
/*        registry.addInterceptor(new LocaleChangeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.jsp","/register.jsp","/phoneregister.jsp","/index2.jsp","/error.jsp");
        WebMvcConfigurer.super.addInterceptors(registry);*/
    }
}
