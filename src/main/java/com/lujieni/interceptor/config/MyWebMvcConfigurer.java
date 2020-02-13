package com.lujieni.interceptor.config;

import com.lujieni.interceptor.interceptors.AnnotationInterceptor;
import com.lujieni.interceptor.interceptors.PathInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther ljn
 * @Date 2020/2/13
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 拦截器的执行顺序和代码的配置顺序有关
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
           /*  -> /hello ok /hello/123 ng
           /** -> /hello ok /hello/123 ok
         */
        registry.addInterceptor(getAInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getBInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public PathInterceptor getAInterceptor(){
        return new PathInterceptor();
    }

    @Bean
    public AnnotationInterceptor getBInterceptor(){
        return new AnnotationInterceptor();
    }

}
