package com.example.fortry.intercepter;

import com.example.fortry.utils.jwtUtil;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import tools.jackson.databind.cfg.HandlerInstantiator;
@Component
public class TokenIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String token=request.getHeader("Authorization");

        if (token==null||!token.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"msg\":未提供token或格式错误,\"date\":null}");
            return false;
        }

        String jwttoken= token.substring(7);

        if (!jwtUtil.validateToken(jwttoken)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"msg\":token无效或已过期,\"data\":null}");
            return false;
        }

        String username=jwtUtil.getUsernameFromToken(jwttoken);
        request.setAttribute("username",username);

        return true;
    }
}
