package com.wn.config;

import com.wn.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class loginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //拦截所有请求,判断cookie,有则放行,没有跳登录
        System.out.println("拦截中,寻找cookie...");
        Object loginUser = CookieUtil.queryCookie(request);
        if (loginUser == null) {
            request.setAttribute("interceptor", "请先登录");
            System.out.println("拦截了,来到登录页。");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return false;
        } else {
            System.out.println("所以放行了。");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
