package com.easy_pan.api.config;

import com.easy_pan.api.interception.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthorizationConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor())
                .addPathPatterns("/api/**") // 需要拦截的接口
                .excludePathPatterns(
                        "/api/account/img_verify_code",
                        "/api/account/email_verify_code/send",
                        "/api/account/users/register",
                        "/api/account/user/login"
                );

    }
}
