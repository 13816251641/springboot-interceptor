package com.lujieni.interceptor.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther ljn
 * @Date 2020/2/13
 * 基于路径的拦截器
 */
public class PathInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PathInterceptor");
        String path = request.getServletPath();
        /*  利用正则拦截所有/h开头的请求  */
        if (path.matches("/h.*")) {
            // 这写你拦截需要干的事儿，比如取缓存，SESSION，权限判断等
            return true;
        } else {
            //不需要的拦截直接过
            System.out.println("====================================");
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
