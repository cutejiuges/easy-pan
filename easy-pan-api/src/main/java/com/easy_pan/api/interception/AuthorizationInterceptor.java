package com.easy_pan.api.interception;

import com.easy_pan.api.infra.utils.JwtTokenHolder;
import com.easy_pan.common.constants.Constants;
import com.easy_pan.common.enums.JwtTokenTypeEnum;
import com.easy_pan.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 先对token进行校验
        String token = request.getHeader("Authorization");
        if (token == null || token.isBlank() || !token.startsWith(Constants.BEARER)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("No valid token is provided");
            return false;
        }
        token = token.substring(Constants.BEARER.length() + 1);
        if (JwtUtil.invalidJwtToken(token, JwtTokenTypeEnum.AccessToken.getCode())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid tokens");
            return false;
        }
        if (JwtUtil.expiredJwtToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token is expired");
            return false;
        }
        // 将token存储进threadLocal
        JwtTokenHolder.threadLocal.set(token);
        // 继续执行逻辑
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 本次调用执行结束之后，把threadLocal释放掉
        JwtTokenHolder.threadLocal.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
