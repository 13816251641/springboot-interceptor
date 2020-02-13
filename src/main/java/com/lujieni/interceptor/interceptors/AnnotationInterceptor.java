package com.lujieni.interceptor.interceptors;

import com.lujieni.interceptor.annotation.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Auther ljn
 * @Date 2020/2/13
 * 基于注解的拦截
 */
public class AnnotationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AnnotationInterceptor");
        // 如果不是映射到方法直接通过,这里我理解有些请求是访问资源的
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否有LoginRequired注解
        LoginRequired annotation = method.getAnnotation(LoginRequired.class);
        if(annotation != null){
            // 这写你拦截需要干的事儿，比如取缓存，SESSION，权限判断等
            System.out.println("需要认证");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
