package com.hospital.hospitalgd.common.configure;

import com.hospital.hospitalgd.common.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * hospital-gd
 * Art
 * 2019-04-08 17:02
 **/
@Configuration
public class MyConfig  implements WebMvcConfigurer
{

    //放开对静态资源的拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截的路径、不拦截的路径、优先级等等
        /*registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/bootstrap-3.3.7-dist/**","/pub**","/mine/**","*.js","*.css");
        super.addInterceptors(registry);*/

        InterceptorRegistration ir=registry.addInterceptor(new SessionInterceptor());
        // ir.addPathPatterns("/**");
        // ir.excludePathPatterns("/login","/bootstrap-3.3.7-dist/**","/pub/**","/mine/**","/login","/js/**","/html/**","/image/**","/css/**");
        // ir.excludePathPatterns("*.js","*.css");
    }
}
